package com.crm.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AnnotationsOfTestNG {
	@DataProvider
	public Object[][] dataReader(){
		Object[][] data = {{"user","password"},
				{"user1","password1"}};
		return data;
	}
	
	@Test(dataProvider = "dataReader")
	public void userData(String userName,String password) {
		System.out.println("UserName: "+userName+" | Password: "+password);
	}
}
