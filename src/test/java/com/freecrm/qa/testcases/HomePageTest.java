package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.DealsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.pages.TasksPage;
import com.freecrm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	TestUtil testUtil;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
		tasksPage = new TasksPage();
		Thread.sleep(3000);
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@Test(groups = "TitleName")
	public void validateTitleNameTest() {
		testUtil.switchToFrame();
		boolean flage = homePage.validateTitleName();
		Assert.assertTrue(flage);
	}
	
	@Test(groups = "ContactPage")
	public void validateContactsTabTest(){
		testUtil.switchToFrame();
		contactsPage = homePage.validateContactsTab();
	}
	
	@Test(groups = "HomePageGetTitle")
	public void validateGetTitleTest() {
		String str =homePage.ValidateGetTitle();
		Assert.assertEquals(str, "CRMPRO");
	}
	
	@Test(groups = "HomePageGetTitle")
	public void clickOnSearchIconTest() {
		testUtil.switchToFrame();
		homePage.clickOnSearchIcon();
				
	}
	@Test(groups = "DealsPage")
		public void validateDealsTabTest() {
			testUtil.switchToFrame();
			dealsPage = homePage.validateDealsTab();
		}
	
	@Test(groups = "TasksPage")
	public void validateTaskTabTest() {
		testUtil.switchToFrame();
		tasksPage = homePage.validateTasksTab();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
