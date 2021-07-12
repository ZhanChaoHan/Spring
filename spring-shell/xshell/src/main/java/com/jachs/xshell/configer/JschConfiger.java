package com.jachs.xshell.configer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import lombok.extern.slf4j.Slf4j;

/***
 * 
 * @author zhanchaohan
 *
 */
@Slf4j
@Configuration
public class JschConfiger {
	private static final int CONNECT_TIMEOUT = 5000;

	public Session session;

	@Bean("jConnection")
	public JSch init() throws JSchException, IOException {
		Properties properties = new Properties();
		properties.load(JschConfiger.class.getResourceAsStream("/jsch.properties"));

		String USER = properties.getProperty("USER");
		String HOST = properties.getProperty("HOST");
		int DEFAULT_SSH_PORT = Integer.parseInt(properties.getProperty("DEFAULT_SSH_PORT"));
		String PASSWORD = properties.getProperty("PASSWORD");

		String pkey = properties.getProperty("pkey");
		String passphrase = properties.getProperty("passphrase");

		JSch jsch = new JSch();

		if (StringUtils.isNoneBlank(pkey)) {
			jsch.addIdentity(pkey, passphrase);
		}
		session = jsch.getSession(USER, HOST, DEFAULT_SSH_PORT);
		session.setPassword(PASSWORD);
		session.setConfig(properties);
		// username and password will be given via UserInfo interface.
//        session.setUserInfo(new UserEntity());
		session.connect();
		if (session.isConnected()) {
			System.out.println("Host({}) connected." + HOST);
		}
		return jsch;
	}
	/***
	 * 
	 * @param session
	 * @param command 远程命令
	 * @return 返回的数据集合
	 * @throws JSchException
	 */
	public List<String> remoteExecute(String command) throws JSchException {
		log.debug(">> {}", command);
		List<String> resultLines = new ArrayList<String>();
		ChannelExec channel = null;
		try {
			channel = (ChannelExec) session.openChannel("exec");
			channel.setCommand(command);
			InputStream input = channel.getInputStream();
			channel.connect(CONNECT_TIMEOUT);
			try {
				BufferedReader inputReader = new BufferedReader(new InputStreamReader(input));
				String inputLine = null;
				while ((inputLine = inputReader.readLine()) != null) {
					log.debug("   {}", inputLine);
					resultLines.add(inputLine);
				}
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (Exception e) {
						log.error("JSch inputStream close error:", e);
					}
				}
			}
		} catch (IOException e) {
			log.error("IOcxecption:", e);
		} finally {
			if (channel != null) {
				try {
					channel.disconnect();
				} catch (Exception e) {
					log.error("JSch channel disconnect error:", e);
				}
			}
		}
		return resultLines;
	}
}
