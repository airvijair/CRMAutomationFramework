package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		Thread.sleep(3000);
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority = 4, groups = "TitleName")
	public void validateTitleNameTest() {
		boolean flage = homePage.validateTitleName();
		Assert.assertTrue(flage);
	}
	
	@Test(priority = 7, groups = "ContactPage")
	public void validateContactsTabTest() {
		homePage.validateContactsTab();
		
	}
	
	@Test(priority = 6, groups = "HomePageGetTitle")
	public void validateGetTitleTest() {
		String str =homePage.ValidateGetTitle();
		Assert.assertEquals(str, "CRMPRO");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
