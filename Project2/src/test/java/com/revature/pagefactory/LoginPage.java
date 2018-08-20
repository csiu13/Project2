package com.revature.pagefactory;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
	
	public static WebDriver driver = null;
	
	public static void launchApplication() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://assignforce-client.cfapps.io/login");
	}
	
	public static void loginSVP() {
		launchApplication();
		LoginPage page = new LoginPage(driver);
		page.email.sendKeys("svp@revature.com");
		page.pwd.sendKeys("p@$$w0rd");
		page.login.click();
	}

	public static void loginTrainer() {
		launchApplication();
		LoginPage page = new LoginPage(driver);
		page.email.sendKeys("test.trainer@revature.com");
		page.pwd.sendKeys("p@$$w0rd");
		page.login.click();
	}
	

}
