package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	//Page Factory OR
	
	@FindBy(xpath = "//input[@name = 'username']")
	WebElement uname;
	
	@FindBy(xpath = "//input[@name = 'password']")
	WebElement pword;
	
	@FindBy(xpath = "//*[@id=\"loginForm\"]/div/div/input")
	WebElement loginbtn;
	
	
	@FindBy(xpath = "//button[contains(text(), 'Sign Up')]")
	WebElement signupbtn;
	
	@FindBy(xpath ="//img[@alt = 'free crm logo']")
	WebElement crmlogo;
	
	//have to create constructor for the LoginPage class to initialing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Perform action what you want to check
	
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public HomePage Login(String un, String pw) {
		uname.sendKeys(un);
		pword.sendKeys(pw);
		loginbtn.click();
		
		return new HomePage();
			
	}

	public boolean validateFreeCRMLog() {
		return crmlogo.isDisplayed();
	}
	
}
