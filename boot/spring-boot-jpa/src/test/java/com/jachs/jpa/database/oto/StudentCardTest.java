package com.jachs.jpa.database.oto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.database.jpa.dao.oto.StudentCardRepository;
import com.jachs.database.jpa.entity.oto.StudentCard;

/**
 * @author zhanchaohan
 * 
 */
@SpringBootTest
public class StudentCardTest {
    @Autowired
    private StudentCardRepository studentCardRepository;
    
    @Test
    public void testAddOne() {
        StudentCard sc=new StudentCard();
        sc.setCardId ( "cId" );
        sc.setCardMonery ( 598475L );
        sc.setCardType ( "学生卡" );
        studentCardRepository.save ( sc );
    }
}
