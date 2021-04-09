package com.jachs.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jachs.rest.entity.People;


/**
 * @author zhanchaohan
 * 
 */
@RepositoryRestResource(path="people")
public interface PeopleRepository extends JpaRepository<People,Integer>{
    
}
