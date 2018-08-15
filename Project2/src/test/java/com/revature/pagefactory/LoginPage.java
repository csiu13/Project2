package com.revature.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  
	public LoginPage (WebDriver driver) {
		PageFactory.initElements(driver,  this);
	}
	
	@FindBy (name = "email")
	public WebElement email;
	
	@FindBy (name = "password")
	public WebElement pwd;
	
	@FindBy (name = "submit")
	public WebElement login;
}
