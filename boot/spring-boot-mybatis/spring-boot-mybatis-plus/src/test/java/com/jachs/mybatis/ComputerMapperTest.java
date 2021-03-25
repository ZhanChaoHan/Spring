package com.jachs.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jachs.mybatis.entity.Computer;
import com.jachs.mybatis.mapper.ComputerMapper;

@SpringBootTest(classes =MybatisPlusApplication.class )
public class ComputerMapperTest {
	@Autowired
	private ComputerMapper computerMapper;
	
	@Test
	public void test() {
		Computer cp=computerMapper.selectById("1");
		
		System.out.println(cp.getComputerName());
	}
}
