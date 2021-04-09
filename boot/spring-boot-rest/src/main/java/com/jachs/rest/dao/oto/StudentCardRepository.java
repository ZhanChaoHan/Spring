package com.jachs.rest.dao.oto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jachs.rest.entity.oto.StudentCard;


/**
 * @author zhanchaohan
 * 
 */
@RepositoryRestResource(path="studentcard")
public interface StudentCardRepository extends JpaRepository<StudentCard,String>{

}
