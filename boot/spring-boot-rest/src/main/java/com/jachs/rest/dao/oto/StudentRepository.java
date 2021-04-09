package com.jachs.rest.dao.oto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jachs.rest.entity.oto.Student;


/**
 * @author zhanchaohan
 * 
 */
@RepositoryRestResource(path="student")
public interface StudentRepository extends JpaRepository<Student,String>{

}
