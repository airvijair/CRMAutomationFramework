package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	//Have to create Constructor - as should call TestBase class constructor 
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(invocationCount=5, groups = "TitleValidate")
	public void loginPageTitleTest() {
		String str = loginPage.validatePageTitle();
		Assert.assertEquals(str, "#1 Free CRM software in the cloud for sales and service");
	}

	@Test(groups = "LoginValidate")
	public void loginTest() {
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(groups = "LogoValidation")
	public void loginPageFreeCRMLogo() {
		boolean flag =loginPage.validateFreeCRMLog();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

