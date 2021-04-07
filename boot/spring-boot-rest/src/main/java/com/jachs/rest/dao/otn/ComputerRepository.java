package com.jachs.rest.dao.otn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jachs.rest.entity.otn.Computer;


/**
 * @author zhanchaohan
 * 
 */
@RepositoryRestResource(path="computer")
public interface ComputerRepository extends JpaRepository<Computer,String>{
    
}
