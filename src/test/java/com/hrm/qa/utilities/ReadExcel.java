package com.hrm.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ReadExcel {
	
	public static HSSFWorkbook WBook=null;
	public static HSSFSheet WSheet=null;
	
	public static HSSFSheet DataSheet(String FilePath, String sheetName) {
		
		File file = new File(FilePath);
		try {
			FileInputStream fis = new FileInputStream(file);
			try {
				WBook = new HSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			WSheet = WBook.getSheet(sheetName);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return WSheet;
		
	}

}
