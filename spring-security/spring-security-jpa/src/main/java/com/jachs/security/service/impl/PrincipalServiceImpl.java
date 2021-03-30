package com.jachs.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jachs.security.dao.custom.PrincipalRepository;
import com.jachs.security.entity.custom.Principal;
import com.jachs.security.service.PrincipalService;

/**
 * @author zhanchaohan
 * 
 */
@Service
public class PrincipalServiceImpl implements PrincipalService{
    @Autowired
    private PrincipalRepository principalRepository;
    
    
    @Override
    public List<Principal> findAll () {
        return principalRepository.findAll ();
    }


	@Override
	public Principal queryMySelf(String name) {
		return principalRepository.findById(name).get();
	}


	@Override
	public void deleteOnePrincipal(String principalName) {
		principalRepository.deleteById(principalName);;
	}

}
