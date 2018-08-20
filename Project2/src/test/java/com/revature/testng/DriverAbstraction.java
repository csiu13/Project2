package com.revature.testng;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pagefactory.LoginPage;

public class DriverAbstraction {
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
		
		  try {
			  TimeUnit.SECONDS.sleep(5);
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
		
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
