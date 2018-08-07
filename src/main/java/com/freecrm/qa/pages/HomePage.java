package com.freecrm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	//Page factory OR
	
	@FindBy(xpath = "//td[contains(text(),'User: Vijay kumar')]")
	WebElement titleName;
	
	
	@FindBy(xpath ="//input[@type = 'image']")
	WebElement searchImage;
	
	
	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	WebElement contactTab;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContact;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsTab;
	
	
	@FindBy(xpath = "//a[@Tasks = 'Tasks']")
	WebElement tasksTab;
	
	
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
		
	
	//Perform action for above OR
	
	public boolean validateTitleName() {
		return titleName.isDisplayed();

	}
	
	public String ValidateGetTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage validateContactsTab() {
		contactTab.click();
		return new ContactsPage();
	}


	public HomePage clickOnSearchIcon() {
		searchImage.click();
		return new HomePage();
	}
	
	public DealsPage validateDealsTab() {
 		dealsTab.click();
		return new DealsPage();
	}
	
	public TasksPage validateTasksTab() {
		tasksTab.click();
		return new TasksPage();
		
	}
	
	public void clickOnNewContactTab(){
			Actions action = new Actions(driver);
			action.moveToElement(contactTab).build().perform();
			newContact.click();
			
	}
		
}

















