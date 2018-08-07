package com.freecrm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{
	
		LoginPage loginPage;
		HomePage homePage;
		TestUtil testUtil;
		ContactsPage contactsPage;
		
		String sheetName = "Contacts";

		public ContactPageTest(){
			super();
		}
			
		@BeforeMethod
		public void setup() throws InterruptedException {
			initialization();
			testUtil = new TestUtil();
			loginPage = new LoginPage();
			homePage = new HomePage();
			Thread.sleep(3000);
			homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
			testUtil.switchToFrame();
			contactsPage = homePage.validateContactsTab();
			Thread.sleep(3000);
			
		}
		
		@Test(groups = "ContactsPage")
		public void ValidateContactTitleTest() {
			Assert.assertTrue(contactsPage.ValidateContactTitle(), "Contact lable is missmatch");
			
		}
		
		@Test(groups = "ContactsPage")
		public void validatecheckboxTest() {
			contactsPage.validateCheckbox();
		}
		
		@DataProvider
		public Object[][] getFreeCRMTestData() {
			Object data [][] = TestUtil.getTestData(sheetName);
			return data;			
		}
		
		@Test(dataProvider = "getFreeCRMTestData")
		public void CreateNewContactTest(String title, String firstname, String lastname, String email) {
			homePage.clickOnNewContactTab();
			//contactsPage.createNewContact("Mr.", "Deepan", "kumar", "dkumar@gmail.com");
			contactsPage.createNewContact(title, firstname, lastname, email);
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
}


