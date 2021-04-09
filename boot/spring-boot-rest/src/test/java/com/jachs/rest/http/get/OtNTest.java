package com.jachs.rest.http.get;


import org.junit.jupiter.api.Test;

import com.jachs.rest.http.HttpBaseTest;

/***
 * 
 * @author zhanchaohan
 *
 */
public class OtNTest extends HttpBaseTest{
	
	@Test
	public void testComputer() {
		String stc=httpClientUtill.sendGet(computer);
		
		System.out.println(stc);
	}
}
