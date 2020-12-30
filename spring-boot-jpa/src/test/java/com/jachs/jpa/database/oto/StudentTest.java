package com.jachs.jpa.database.oto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.database.jpa.dao.oto.StudentCardRepository;
import com.jachs.database.jpa.dao.oto.StudentRepository;
import com.jachs.database.jpa.entity.oto.Student;
import com.jachs.database.jpa.entity.oto.StudentCard;

/**
 * @author zhanchaohan
 * 
 */
@SpringBootTest
public class StudentTest {
    @Autowired
    private StudentRepository studentRepository;
    
    //单存
    @Test
    public void saveAStudent() {
        Student s=new Student();
        s.setStudentId ( "sOne" );
        s.setStudentName ( "马保国" );
        s.setStudentAge ( 69 );
        
        studentRepository.save ( s );
    }
    //关联存储
    @Test
    public void saveAStudentAndCard() {
        Student s=new Student();
        s.setStudentId ( "sOne" );
        s.setStudentName ( "马保国" );
        s.setStudentAge ( 69 );
        
        StudentCard sc=new StudentCard();
        sc.setCardId ( "sOneC" );
        sc.setCardMonery ( 5L );
        sc.setCardType ( "老年卡" );
        
        
        s.setStudentCard ( sc );
        studentRepository.save ( s );
    }
    //删除主表从表数据一起删了
    @Test
    public void deleteStuend() {
        studentRepository.delete ( studentRepository.findById ( "sOne" ).get () );
    }
}