package com.jachs.mybatisc.dao;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jachs.mybatis.Application;
import com.jachs.mybatis.dao.ComputerMapper;
import com.jachs.mybatis.dao.Soft_wareMapper;
import com.jachs.mybatis.entity.Computer;
import com.jachs.mybatis.entity.Soft_ware;

@SpringBootTest(classes = Application.class)
public class ComputerMapperTest {
	@Autowired
	private ComputerMapper computerMapper;
	@Autowired
	private Soft_wareMapper soft_wareMapper;
	
	private static final String cId="cid";
	
	@Test
	public void test1() {
		Computer computer=new Computer();
		
		computer.setComputerId(cId);
		computer.setComputerName("XXAA");
		computer.setComputerPrice(15287L);
		computerMapper.insert(computer);
	}
	@Test
	public void test2() {
		RandomStringUtils rsu=new RandomStringUtils();
		for (int kk = 0; kk < 100; kk++) {
			Soft_ware sw=new Soft_ware();
			sw.setCid(cId);
			
			sw.setSoftWareId(kk+"");
			sw.setSoftWareName(rsu.randomAlphanumeric(6));
			soft_wareMapper.insert(sw);
		}
	}
	//page helper分页
	@Test
	public void test3() {
		System.out.println("第一页-----------------------");
		PageHelper.startPage(1, 10);
		List<Soft_ware>  swList=soft_wareMapper.selectAll();
		for (Soft_ware soft_ware : swList) {
			System.out.println(soft_ware.getSoftWareId());
		}
		System.out.println("第二页-----------------------");
		PageHelper.startPage(2, 10);
		List<Soft_ware>  swList1=soft_wareMapper.selectAll();
		for (Soft_ware soft_ware : swList1) {
			System.out.println(soft_ware.getSoftWareId());
		}
		
	}
	//分页排序
	@Test
	public void test4() {
		String orderBy ="cid desc";////按照排序字段 倒序 排序
		
		System.out.println("第一页-----------------------");
		PageHelper.startPage(1, 10,orderBy);
		List<Soft_ware>  swList=soft_wareMapper.selectAll();
		for (Soft_ware soft_ware : swList) {
			System.out.println(soft_ware.getSoftWareId());
		}
		System.out.println("第二页-----------------------");
		PageHelper.startPage(2, 10,orderBy);
		List<Soft_ware>  swList1=soft_wareMapper.selectAll();
		for (Soft_ware soft_ware : swList1) {
			System.out.println(soft_ware.getSoftWareId());
		}
		
	}
}
