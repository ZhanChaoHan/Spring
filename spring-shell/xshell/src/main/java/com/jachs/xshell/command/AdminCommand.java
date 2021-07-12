package com.jachs.xshell.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.jachs.xshell.configer.JschConfiger;
import com.jcraft.jsch.JSchException;

/***
 * 
 * @author zhanchaohan
 *
 */
@ShellComponent
@ShellCommandGroup("SSH Commands")
public class AdminCommand {
	private boolean connected;

	@Autowired
	private JschConfiger jsf;
	
	
    @ShellMethod("Connect to the server.")
    public void connect() {
         connected=jsf.session.isConnected();
    }

    @ShellMethod("Exection the command codes.")
    public void exection(String command) throws JSchException {
    	List<String> lList=jsf.remoteExecute(command);
    	
    	for (String str : lList) {
			System.out.println(str);
		}
    }

    public Availability downloadAvailability() {
        return connected
            ? Availability.available()
            : Availability.unavailable("you are not connected");
    }
}