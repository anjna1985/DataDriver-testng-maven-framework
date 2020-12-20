package com.hrm.qa.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrm.qa.basetest.BaseTest;
import com.hrm.qa.utilities.DataProviderForLogin;

public class TestSuite extends BaseTest {

	@Test (dataProviderClass = DataProviderForLogin.class, dataProvider = "getLoginData" )
	public void test(String username, String pass) {

		SoftAssert soft = new SoftAssert();
		soft.assertEquals("OrangeHRM1", "OrangeHRM", "Failing Case");
		System.out.println("Enter User");
		WebElement uname = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		uname.clear();
		uname.sendKeys(username);

		System.out.println("Enter Password");
		WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		password.clear();
		password.sendKeys(pass);

		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		soft.assertEquals("OrangeHRM", "OrangeHRM", "Passing Case");
		soft.assertAll();
	}

}
