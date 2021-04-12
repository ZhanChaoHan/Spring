package com.jachs.rest.http.post;

import org.junit.Test;

import com.jachs.rest.http.HttpBaseTest;

/***
 * POST请求rest功能测试
 * @author zhanchaohan
 *
 */
public class PeopleTest extends HttpBaseTest {
	private static final String url="http://127.0.0.1:8080/api/peoplec";
	
	@Test
	public void test() {
		String json=httpClientUtill.sendPost(url+"/save", "{pId:'csa',pName:'aaa',pRealName:'vvv'}");
		System.out.println(json);
	}
}
