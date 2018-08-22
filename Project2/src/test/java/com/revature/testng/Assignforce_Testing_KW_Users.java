package com.revature.testng;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.revature.dao.BatchDaoImpl;
import com.revature.dao.LoginDaoImpl;
import com.revature.model.LoginAnnotation;
import com.revature.pagefactory.BatchPage;
import com.revature.pagefactory.LoginPage;
import com.revature.pagefactory.SettingsPage;

public class Assignforce_Testing_KW_Users {

	public static WebDriverWait wait;

	public static WebDriver driver = null;
	public static BatchDaoImpl batch = new BatchDaoImpl();
	public static LoginDaoImpl login = new LoginDaoImpl();

	
	@BeforeMethod 
	public static void launchApplicationAsUser() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://assignforce-client.cfapps.io/login");

		LoginPage page = new LoginPage(driver);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(page.login));
		LoginAnnotation user = new LoginAnnotation();
		page.email.sendKeys("test.trainer@revature.com");
		page.pwd.sendKeys("p@$$w0rd");
		page.login.click();
	}
	
	@AfterMethod 
	public void logoutAndCloseDriver() {
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.logout));
		driver.close();
	}
	
	//test settings as user - CANT IF TOO SMALL
	@Test
	public void userSettings() {
		SettingsPage tab = new SettingsPage(driver);
		
		wait.until(ExpectedConditions.elementToBeClickable(tab.navigate));

		tab.navigate.click();
		tab.navigate.click();
		tab.navigate.click();
		tab.navigate.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(tab.settingsTab));

		tab.settingsTab.click();


		//see if can change input fields - YOU CANT
		wait.until(ExpectedConditions.elementToBeClickable(tab.trainersPerPage));

		tab.trainersPerPage.click();
		tab.outgoingGrads.click();
		tab.candidateIncoming.click();
		tab.minBatchSize.click();
		tab.maxBatchSize.click();
		tab.batchDuration.click();
		tab.daysBetweenBatches.click();
		tab.namePattern.click();
	}
	
	@Test
	public void userProfile() {
		SettingsPage tab = new SettingsPage(driver);
		
		wait.until(ExpectedConditions.elementToBeClickable(tab.navigate));

		tab.navigate.click();
		tab.navigate.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(tab.profileTab));

		tab.profileTab.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(tab.saveAndEditProfile));

		tab.saveAndEditProfile.click();
		tab.saveAndEditProfile.click();
		tab.saveAndEditProfile.click();
		tab.saveAndEditProfile.click();
		tab.saveAndEditProfile.click();
		tab.saveAndEditProfile.click();
		tab.saveAndEditProfile.click();
		tab.saveAndEditProfile.click();
	}
	
}