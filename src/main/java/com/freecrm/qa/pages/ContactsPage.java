package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.freecrm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	
	//Page factory OR
	
	@FindBy(xpath = "//*[@id=\"vContactsForm\"]/table/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement contactTitle;
	
	@FindBy(xpath = "//input[@value = '52298403']")
	WebElement checkBoxCheck;
	
	@FindBy(name ="title")
	WebElement titledrop;
	
	@FindBy(id ="first_name")
	WebElement firstName;
	
	@FindBy(id ="surname")
	WebElement lastName;
	
	@FindBy(id ="email")
	WebElement eMail;
	
	@FindBy(xpath = "//input[@type = 'submit' and @value = 'Save']")
	WebElement saveBtn;
	
	//Constructor creation
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Do action 
	
	public boolean ValidateContactTitle() {
		return contactTitle.isDisplayed();
		
	}
	public void validateCheckbox() {
		checkBoxCheck.click();
		return;
	}
	
	public void createNewContact(String title, String ftName, String ltName, String eMailId ) {
		Select select = new Select(titledrop);
		select.selectByVisibleText(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		eMail.sendKeys(eMailId);
		saveBtn.click();
		
	}
}
