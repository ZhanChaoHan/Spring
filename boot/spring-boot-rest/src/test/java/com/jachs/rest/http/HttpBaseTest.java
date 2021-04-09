package com.jachs.rest.http;

import com.jachs.httpclient.HttpClientUtill;

/***
 * 
 * @author zhanchaohan
 *
 */
public abstract class HttpBaseTest {
	protected static final HttpClientUtill httpClientUtill=new HttpClientUtill();
	protected static final String ServerPath="http://127.0.1.1:8080/api/";
	
	protected static final String computer=ServerPath+"computer";
	protected static final String software=ServerPath+"software";
	protected static final String student=ServerPath+"student";
	protected static final String studentcard=ServerPath+"studentcard";
	
	protected static final String people=ServerPath+"people";
	
}
