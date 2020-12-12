package com.jachs.security.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jachs.security.dao.RememberMeTokenRepository;
import com.jachs.security.entity.RememberMeToken;

/**
 * 持久化登录
 * @author zhanchaohan
 * 
 */
@Service
public class RememberMeTokenService implements PersistentTokenRepository {
	@Autowired
	private RememberMeTokenRepository rememberMeTokenDao;
	
	public void setCreateTableOnStartup(boolean createTableOnStartup) {
	}
	@Override
	public void createNewToken(PersistentRememberMeToken token) {
	    RememberMeToken rm=new RememberMeToken();
	    
	    rm.setLastUsed ( token.getDate () );
	    rm.setLoginName ( token.getUsername () );
	    rm.setSeries ( token.getSeries () );
	    rm.setToken ( token.getTokenValue () );
		rememberMeTokenDao.save ( rm );
	}

	@Transactional
	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) {
	    
	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
	    RememberMeToken RMT= rememberMeTokenDao.findBySeries(seriesId);
	    if(RMT!=null) {
	        return new PersistentRememberMeToken ( RMT.getLoginName (), RMT.getSeries (), RMT.getToken (), RMT.getLastUsed () );
	    }else {
	        return null;
	    }
	}

	@Transactional
	@Override
	public void removeUserTokens(String username) {
		RememberMeToken RMT= rememberMeTokenDao.findById(username).get();
		 if(RMT!=null) {
			 rememberMeTokenDao.deleteById ( username );
		 }
	}
}
