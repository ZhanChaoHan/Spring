package com.jachs.mybatisc.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.mybatis.Application;
import com.jachs.mybatis.dao.ComputerMapper;
import com.jachs.mybatis.entity.Computer;

@SpringBootTest(classes = Application.class)
public class ComputerMapperTest {
	@Autowired
	private ComputerMapper computerMapper;
	
	@Test
	public void test1() {
		Computer computer=new Computer();
		
//		computer.setComputerId("");
		computer.setComputerName("XXAA");
		computer.setComputerPrice(15287L);
		computerMapper.insert(computer);
	}
}
