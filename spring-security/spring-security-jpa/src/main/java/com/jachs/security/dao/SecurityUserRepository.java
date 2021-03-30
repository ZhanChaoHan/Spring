package com.jachs.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jachs.security.entity.SecurityUser;

/**
 * @author zhanchaohan
 * 
 */
@Repository
public interface SecurityUserRepository extends JpaRepository<SecurityUser,Long>{

}
