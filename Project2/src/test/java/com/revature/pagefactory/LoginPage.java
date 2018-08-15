package com.revature.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
  
	public static WebDriverWait wait;
	
	public LoginPage (WebDriver driver) {
		PageFactory.initElements(driver,  this);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(login));
	}
	
	@FindBy (name = "email")
	public WebElement email;
	
	@FindBy (name = "password")
	public WebElement pwd;
	
	@FindBy (name = "submit")
	public WebElement login;
	

}
