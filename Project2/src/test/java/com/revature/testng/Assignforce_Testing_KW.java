package com.revature.testng;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.revature.dao.LoginDaoImpl;
import com.revature.dao.NewBatchDaoImpl;
import com.revature.model.LoginAnnotation;
import com.revature.pagefactory.BatchPage;
import com.revature.pagefactory.LoginPage;

public class Assignforce_Testing_KW {

	public static WebDriverWait wait;
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
	@Ignore
	public void testAdminLogin() {
		launchApplication();
		LoginPage page = new LoginPage(driver);
		LoginAnnotation admin = new LoginAnnotation();
		admin = login.findLoginById(1);
		page.email.sendKeys(admin.getUsername());
		page.pwd.sendKeys(admin.getPassword());
		page.login.click();
		driver.close();
	}
	
	@Test 
	@Ignore
	public void testUserLogin() {
		launchApplication();
		LoginPage page = new LoginPage(driver);
		LoginAnnotation admin = new LoginAnnotation();
		admin = login.findLoginById(2);
		page.email.sendKeys(admin.getUsername());
		page.pwd.sendKeys(admin.getPassword());
		page.login.click();
		driver.close();
	}
	
	@Test
	public void adminCreateNewBatch() {
		launchApplication();
		LoginPage page = new LoginPage(driver);
		LoginAnnotation admin = new LoginAnnotation();
		admin = login.findLoginById(1);
		page.email.sendKeys(admin.getUsername());
		page.pwd.sendKeys(admin.getPassword());
		page.login.click();
		BatchPage tab = new BatchPage(driver);
		tab.batchTab.click();
		
		//wait isn't working...
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-select-3")));
		Select dropdown = new Select(tab.coreDropdown);
		dropdown.selectByVisibleText("java");
		driver.close();
		
	}
}
