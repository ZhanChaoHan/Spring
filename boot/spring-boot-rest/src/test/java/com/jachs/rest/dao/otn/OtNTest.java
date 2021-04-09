package com.jachs.rest.dao.otn;


import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.rest.entity.otn.Computer;
import com.jachs.rest.entity.otn.SoftWare;

/****
 * 
 * @author zhanchaohan
 *
 */
@SpringBootTest
public class OtNTest {
	RandomStringUtils rsu=new RandomStringUtils();
	@Autowired
	private ComputerRepository computerRepository;
	@Autowired
	private SoftWareRepository softWareRepository;
	
	@Test
	public void test() {
		Computer computer=new Computer();
		computer.setComputerId("2");
		computer.setComputerName("CZAS电脑");
		computer.setComputerPrice(5145L);
		
		computerRepository.save(computer);
		
		Set<SoftWare>swList=new HashSet<SoftWare>();
		
		for (int kk = 0; kk < 200; kk++) {
			SoftWare sw=new SoftWare();
			sw.setCId(computer.getComputerId());
			sw.setSoftWareId(kk+"");
			sw.setSoftWareName(rsu.random(20, 0x4e00, 0x9fa5, false,false));
			
			softWareRepository.save(sw);
		}
		
//		computer.setSoftWares(swList);
		
	}
	
}
