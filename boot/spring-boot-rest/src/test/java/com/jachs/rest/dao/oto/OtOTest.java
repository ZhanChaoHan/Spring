package com.jachs.rest.dao.oto;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.rest.entity.oto.Student;
import com.jachs.rest.entity.oto.StudentCard;

/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class OtOTest {
	RandomStringUtils rsu=new RandomStringUtils();
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentCardRepository studentCardRepository;
	
	@Test
	public void test() {
		Student student=new Student();
		StudentCard studentCard=new StudentCard();
		
		for (int kl = 0; kl < 100; kl++) {
			student.setStudentId(kl+"");
			student.setStudentAge(kl);
			student.setStudentName(rsu.random(3, 0x4e00, 0x9fa5, false,false));
			
			studentCard.setCardId(kl+"");
			studentCard.setCardMonery(25L);
			studentCard.setCardType(rsu.random(3, 0x4e00, 0x9fa5, false,false));
			
			studentRepository.save(student);
			studentCardRepository.save(studentCard);
		}
	}
}
