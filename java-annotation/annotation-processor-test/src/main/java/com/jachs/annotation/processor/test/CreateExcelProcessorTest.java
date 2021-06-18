package com.jachs.annotation.processor.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jachs.annotation.part3.CreateClass;
import com.jachs.annotation.part4.ExportExcel;

/***
 * 
 * @author zhanchaohan
 *
 */
public class CreateExcelProcessorTest {
	@ExportExcel(fileName = "",filePath = "")
	public Map<String, List<String>> a(){
		Map<String, List<String>>map=new HashMap<String, List<String>>();
		List<String> listA=new ArrayList<String>();
		listA.add("皮皮虾");
		listA.add("gugubird");
		listA.add("一个名字");
		map.put("名字", listA);
		
		
		List<String> listB=new ArrayList<String>();
		listB.add("男");
		listB.add("女");
		listB.add("未知");
		map.put("性别", listB);
		return map;
	}
	public void cje() {}
	@CreateClass(className = "GuguBird")
	public class d{};
	
	public static void main(String[] args) {
		
	}
}
