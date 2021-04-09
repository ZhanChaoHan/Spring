package com.jachs.rest.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.rest.entity.People;

/***
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class PeopleTest {
	@Autowired
	private PeopleRepository peopleRepository;
	
	@Test
	public void test() {
		for (int vs = 0; vs <50; vs++) {
			People people=new People();
			people.setPId(vs);
			people.setPName("testname"+vs);
			people.setPRealName("测试"+vs);
			
			peopleRepository.save(people);
		}
		
	}
}
