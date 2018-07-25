package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page factory OR
	
	@FindBy(xpath = "//td[contains(text(), 'User: Vijay kumar')]")
	WebElement titleName;
	
	
	@FindBy(xpath ="//input[@type = 'image']")
	WebElement searchImage;
	

	@FindBy(xpath = "//a[@title = 'Contacts']")
	WebElement contactTab;
	
	@FindBy(xpath = "//a[@Deals = 'Deals']")
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



}















