package com.jachs.database.jpa;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.database.jpa.dao.ExampleRepository;
import com.jachs.database.jpa.dao.MyStudentRepository;
import com.jachs.database.jpa.dao.MySubjectRepository;
import com.jachs.database.jpa.entity.Example;
import com.jachs.database.jpa.entity.MyStudent;
import com.jachs.database.jpa.entity.MySubject;

/**
 * @author zhanchaohan
 * 
 */
@SpringBootTest
public class MyExampleTest {
    @Autowired
    private MyStudentRepository myStudentRepository;
    @Autowired
    private MySubjectRepository mySubjectRepository;
    
    @Autowired
    private ExampleRepository exampleRepository;
    
    @Test
    public void testAdd() {
    	MyStudent ms=myStudentRepository.findAll().get(0);
    	MySubject mss=mySubjectRepository.findById(ms.getStudentId()).get();
    	
    	Example example=new Example();
    	example.setMyStudent(ms);
    	example.setMySubject(mss);
    	example.setScore(95);
    	
    	exampleRepository.save(example);
    }
    
    @Test
    public void testQuery() {
        Example example= exampleRepository.findAll ().get ( 0 );
        MyStudent ms=example.getMyStudent ();
        
        System.out.println ( ms.getStudentName () );
    }
}
