package com.hrm.qa.utilities;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

public class DataProviderForLogin {
	
	public static HSSFSheet sheet;
	public static String FilePath = System.getProperty("user.dir")+"//src//main//resources//TestData//TestData.xls" ;
	public static String sheetName="Login";
	
	@DataProvider
	public static Object[][] getLoginData() {
		
		sheet = ReadExcel.DataSheet(FilePath, sheetName);
		String username = sheet.getRow(1).getCell(0).toString();
		String pass = sheet.getRow(1).getCell(1).toString();
		
		return new Object[][] { { username, pass } };
	}

}
