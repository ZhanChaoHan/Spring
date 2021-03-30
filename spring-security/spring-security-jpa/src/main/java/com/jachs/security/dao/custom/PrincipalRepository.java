package com.jachs.security.dao.custom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jachs.security.entity.custom.Principal;

/**
 * @author zhanchaohan
 */
@Repository
public interface PrincipalRepository extends JpaRepository<Principal,String>{

}
