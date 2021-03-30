package com.jachs.security.service;

import java.util.List;

import com.jachs.security.entity.custom.Principal;

/**
 * @author zhanchaohan
 * 
 */
public interface PrincipalService {
    List<Principal> findAll ();

	Principal   queryMySelf(String name);

	void deleteOnePrincipal(String principalName);

}
