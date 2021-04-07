package com.jachs.rest.dao.otn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jachs.rest.entity.otn.SoftWare;


/**
 * @author zhanchaohan
 * 
 */
@RepositoryRestResource(path="software")
public interface SoftWareRepository extends JpaRepository<SoftWare,String>{

}
