package com.jachs.rest.http.get;

import org.junit.jupiter.api.Test;

import com.jachs.rest.http.HttpBaseTest;

/***
 * GET请求rest功能测试
 * @author zhanchaohan
 *
 */
public class PeopleTest extends HttpBaseTest {

	// 不给定任何参数
	@Test
	public void test() {
		String stc = httpClientUtill.sendGet(people);

		System.out.println(stc);
	}
	//分页测试
	@Test
	public void test1() {
		//分页第1页，每页展示10条数据
//		String stc = httpClientUtill.sendGet(people+"?page=1&size=10");
		//分页第2页，每页展示10条数据
//		String stc = httpClientUtill.sendGet(people+"?page=2&size=10");
		//分页第2页，每页展示20条数据
		String stc = httpClientUtill.sendGet(people+"?page=2&size=20");
		System.out.println(stc);
	}
	//指定ID查询
	@Test
	public void test2() {
		String stc = httpClientUtill.sendGet(people+"/1");
		System.out.println(stc);
	}
	
	//DELETE:http://127.0.0.1:8080/api/people/49,删除ID49
	
}
