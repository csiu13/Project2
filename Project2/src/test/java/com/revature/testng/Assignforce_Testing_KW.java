package com.revature.testng;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.revature.dao.LoginDaoImpl;
import com.revature.dao.NewBatchDaoImpl;
import com.revature.model.LoginAnnotation;
import com.revature.pagefactory.LoginPage;

public class Assignforce_Testing_KW {

	public static WebDriver driver = null;
	public static NewBatchDaoImpl batch = new NewBatchDaoImpl();
	LoginDaoImpl login = new LoginDaoImpl();
	
	public static void launchApplication() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://assignforce-client.cfapps.io/login");
	}
	
	@Test
	public void testAdminLogin() {
		launchApplication();
		LoginPage page = new LoginPage(driver);
		LoginAnnotation admin = new LoginAnnotation();
		admin = login.findLoginById(1);
		page.email.sendKeys(admin.getUsername());
		page.pwd.sendKeys(admin.getPassword());
		page.login.click();
	}
	
	@Test
	public void testUserLogin() {
		launchApplication();
		LoginPage page = new LoginPage(driver);
		LoginAnnotation admin = new LoginAnnotation();
		admin = login.findLoginById(2);
		page.email.sendKeys(admin.getUsername());
		page.pwd.sendKeys(admin.getPassword());
		page.login.click();
	}
}
