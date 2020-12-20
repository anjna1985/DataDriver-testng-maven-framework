package com.hrm.qa.basetest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties Config = new Properties();
	public static FileInputStream fis;

	@BeforeSuite
	public void setUp() {
	
		if (driver==null) {
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Config.load(fis);
				System.out.println("Config Properties loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		if (Config.getProperty("browser").equals("chrome"))	{
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome Browser Launched");
			
		} else if (Config.getProperty("browser").equals("firefox"))	{
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox Browser Launched");
		} 
		
		driver.get(Config.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);
	}
	
	}
	
//	@AfterSuite
//	public void tearDown() {
//		driver.quit();
//	}
}
