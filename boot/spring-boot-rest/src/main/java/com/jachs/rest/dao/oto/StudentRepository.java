package com.jachs.rest.dao.oto;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jachs.rest.entity.oto.Student;


/**
 * @author zhanchaohan
 * 
 */
public interface StudentRepository extends JpaRepository<Student,String>{

}
