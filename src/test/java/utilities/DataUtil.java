package utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import base.BaseTest;

public class DataUtil extends BaseTest{
	
	
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m){
		
		String sheetName= m.getName();
		int rowCount = excel
		return null;
		
		
	}
	
	

}
