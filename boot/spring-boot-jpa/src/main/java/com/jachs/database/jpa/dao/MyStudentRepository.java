package com.jachs.database.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jachs.database.jpa.entity.MyStudent;



/**
 * @author zhanchaohan
 * 
 */
public interface MyStudentRepository extends JpaRepository<MyStudent,Integer>{

}
