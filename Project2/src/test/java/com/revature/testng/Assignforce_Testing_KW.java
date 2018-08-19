package com.revature.testng;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.revature.dao.LoginDaoImpl;
import com.revature.dao.BatchDaoImpl;
import com.revature.model.BatchAnnotation;
import com.revature.model.LoginAnnotation;
import com.revature.pagefactory.BatchPage;
import com.revature.pagefactory.LoginPage;

public class Assignforce_Testing_KW {

	public static WebDriverWait wait;

	public static WebDriver driver = null;
	public static BatchDaoImpl batch = new BatchDaoImpl();
	public static LoginDaoImpl login = new LoginDaoImpl();

	@BeforeTest
	public static void launchApplicationAsAdmin() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://assignforce-client.cfapps.io/login");

		// login as admin
		LoginPage page = new LoginPage(driver);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(page.login));
		LoginAnnotation admin = new LoginAnnotation();
		admin = login.findLoginById(1);
		page.email.sendKeys(admin.getUsername());
		page.pwd.sendKeys(admin.getPassword());
		page.login.click();
	}

	@AfterTest
	public void logoutAndCloseDriver() {
		driver.close();
	}

	@Test
	public void testAdminLogin() {

		// wait until login button is clickable
		LoginPage page = new LoginPage(driver);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(page.login));

		// pull from hibernate admin credentials
		LoginAnnotation admin = new LoginAnnotation();
		admin = login.findLoginById(1);
		page.email.sendKeys(admin.getUsername());
		page.pwd.sendKeys(admin.getPassword());
		page.login.click();
		driver.close();
	}

	@Test
	public void testUserLogin() {

		LoginPage page = new LoginPage(driver);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(page.login));

		LoginAnnotation user = new LoginAnnotation();
		user = login.findLoginById(2);
		page.email.sendKeys(user.getUsername());
		page.pwd.sendKeys(user.getPassword());
		page.login.click();
		driver.close();
	}

	@Test
	//@Ignore
	public void adminCreateNewBatchAndCancel() {
		// click on batch tab and input data using hibernate
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();

		BatchAnnotation newBatch = new BatchAnnotation();
		newBatch = batch.findBatchById(1);

		if (newBatch.getCore().equals("Java") == true) {
			tab.coreDropdownJava.click();
		} else if (newBatch.getCore().equals("Net") == true) {
			tab.coreDropdownNet.click();
		} else if (newBatch.getCore().equals("Salesforce") == true) {
			tab.coreDropdownSalesforce.click();
		} else if (newBatch.getCore().equals("Custom") == true) {
			tab.coreDropdownCustom.click();
		} else if (newBatch.getCore().equals("Testing") == true) {
			tab.coreDropdownTesting.click();
		}

		tab.calendar.click();
		tab.today.click();

		tab.trainerDropdown.click();
		if (newBatch.getTrainer().equals("August")) {
			tab.trainer1.click();
		} else {
			tab.trainer2.click();
		}

		tab.cotrainerDropdown.click();
		tab.august.click();

		tab.locationDropdown.click();
		if (newBatch.getLocation().equals("Revature HQ")) {
			tab.revature.click();
		} else if (newBatch.getLocation().equals("Capital One")) {
			tab.wv.click();
		} else {
			tab.revature.click();
		}

		tab.buildingDropdown.click();
		if (newBatch.getBuilding().equals("11730 Plaza American Drive (HQ)")) {
			tab.firstBuilding.click();
		} else {
			tab.lastBuilding.click();
		}

		tab.roomDropdown.click();
		if (newBatch.getRoom() == 208) {
			tab.firstRoom.click();
		} else {
			tab.lastRoom.click();
		}

		tab.cancelBatch.click();
	}

	@Test
	//@Ignore
	public void adminCreateNewBatchAndCancel2() {
		// click on batch tab and input data using hibernate
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();

		BatchAnnotation newBatch = new BatchAnnotation();
		newBatch = batch.findBatchById(2);

		if (newBatch.getCore().equals("Java") == true) {
			tab.coreDropdownJava.click();
		} else  {
			tab.coreDropdownNet.click();
		}
		
		tab.calendar.click();
		tab.today.click();

		tab.trainerDropdown.click();
		if (newBatch.getTrainer().equals("August")) {
			tab.trainer1.click();
		} else {
			tab.trainer2.click();
		}

		tab.cotrainerDropdown.click();
		tab.august.click();

		tab.locationDropdown.click();
		if (newBatch.getLocation().equals("Revature HQ")) {
			tab.revature.click();
		} else if (newBatch.getLocation().equals("Capital One")) {
			tab.wv.click();
		} else {
			tab.revature.click();
		}

		tab.buildingDropdown.click();
		if (newBatch.getBuilding().equals("11730 Plaza American Drive (HQ)")) {
			tab.firstBuilding.click();
		} else {
			tab.lastBuilding.click();
		}

		tab.roomDropdown.click();
		if (newBatch.getRoom() == 208) {
			tab.firstRoom.click();
		} else {
			tab.lastRoom.click();
		}

		tab.cancelBatch.click();
	}

	@Test
	//@Ignore
	public void adminCreateNewBatchAndCancel3() {
		// click on batch tab and input data using hibernate
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();

		BatchAnnotation newBatch = new BatchAnnotation();
		newBatch = batch.findBatchById(3);

		if (newBatch.getCore().equals("Java") == true) {
			tab.coreDropdownJava.click();
		} else  {
			tab.coreDropdownNet.click();
		}

		tab.calendar.click();
		tab.today.click();

		tab.trainerDropdown.click();
		if (newBatch.getTrainer().equals("August")) {
			tab.trainer1.click();
		} else {
			tab.trainer2.click();
		}

		tab.cotrainerDropdown.click();
		tab.august.click();

		tab.locationDropdown.click();
		if (newBatch.getLocation().equals("Revature HQ")) {
			tab.revature.click();
		} else if (newBatch.getLocation().equals("Capital One")) {
			tab.wv.click();
		} else {
			tab.revature.click();
		}

		tab.buildingDropdown.click();
		if (newBatch.getBuilding().equals("11730 Plaza American Drive (HQ)")) {
			tab.firstBuilding.click();
		} else {
			tab.lastBuilding.click();
		}

		tab.roomDropdown.click();
		if (newBatch.getRoom() == 208) {
			tab.firstRoom.click();
		} else {
			tab.lastRoom.click();
		}

		tab.cancelBatch.click();
	}

	@Test
	@Ignore
	public void adminCreateNewBatchAndCancel4() {
		// click on batch tab and input data using hibernate
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();

		BatchAnnotation newBatch = new BatchAnnotation();
		newBatch = batch.findBatchById(4);

		if (newBatch.getCore().equals("Java") == true) {
			tab.coreDropdownJava.click();
		} else  {
			tab.coreDropdownNet.click();
		}

		tab.calendar.click();
		tab.today.click();

		tab.trainerDropdown.click();
		if (newBatch.getTrainer().equals("August")) {
			tab.trainer1.click();
		} else {
			tab.trainer2.click();
		}

		tab.cotrainerDropdown.click();
		tab.august.click();

		tab.locationDropdown.click();
		if (newBatch.getLocation().equals("Revature HQ")) {
			tab.revature.click();
		} else if (newBatch.getLocation().equals("Capital One")) {
			tab.wv.click();
		} else {
			tab.revature.click();
		}

		tab.buildingDropdown.click();
		if (newBatch.getBuilding().equals("11730 Plaza American Drive (HQ)")) {
			tab.firstBuilding.click();
		} else {
			tab.lastBuilding.click();
		}

		tab.roomDropdown.click();
		if (newBatch.getRoom() == 208) {
			tab.firstRoom.click();
		} else {
			tab.lastRoom.click();
		}

		tab.cancelBatch.click();
	}

	@Test
	@Ignore
	public void adminCreateNewBatchAndCancel5() {
		// click on batch tab and input data using hibernate
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();

		BatchAnnotation newBatch = new BatchAnnotation();
		newBatch = batch.findBatchById(5);

		if (newBatch.getCore().equals("Java") == true) {
			tab.coreDropdownJava.click();
		} else  {
			tab.coreDropdownNet.click();
		}

		tab.calendar.click();
		tab.today.click();

		tab.trainerDropdown.click();
		if (newBatch.getTrainer().equals("August")) {
			tab.trainer1.click();
		} else {
			tab.trainer2.click();
		}

		tab.cotrainerDropdown.click();
		tab.august.click();

		tab.locationDropdown.click();
		if (newBatch.getLocation().equals("Revature HQ")) {
			tab.revature.click();
		} else if (newBatch.getLocation().equals("Capital One")) {
			tab.wv.click();
		} else {
			tab.revature.click();
		}

		tab.buildingDropdown.click();
		if (newBatch.getBuilding().equals("11730 Plaza American Drive (HQ)")) {
			tab.firstBuilding.click();
		} else {
			tab.lastBuilding.click();
		}

		tab.roomDropdown.click();
		if (newBatch.getRoom() == 208) {
			tab.firstRoom.click();
		} else {
			tab.lastRoom.click();
		}

		tab.cancelBatch.click();
	}

	@Test
	@Ignore
	public void adminCreateNewBatchAndCancel6() {
		// click on batch tab and input data using hibernate
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();

		BatchAnnotation newBatch = new BatchAnnotation();
		newBatch = batch.findBatchById(6);

		if (newBatch.getCore().equals("Java") == true) {
			tab.coreDropdownJava.click();
		} else  {
			tab.coreDropdownNet.click();
		}

		tab.calendar.click();
		tab.today.click();

		tab.trainerDropdown.click();
		if (newBatch.getTrainer().equals("August")) {
			tab.trainer1.click();
		} else {
			tab.trainer2.click();
		}

		tab.cotrainerDropdown.click();
		tab.august.click();

		tab.locationDropdown.click();
		if (newBatch.getLocation().equals("Revature HQ")) {
			tab.revature.click();
		} else if (newBatch.getLocation().equals("Capital One")) {
			tab.wv.click();
		} else {
			tab.revature.click();
		}

		tab.buildingDropdown.click();
		if (newBatch.getBuilding().equals("11730 Plaza American Drive (HQ)")) {
			tab.firstBuilding.click();
		} else {
			tab.lastBuilding.click();
		}

		tab.roomDropdown.click();
		if (newBatch.getRoom() == 208) {
			tab.firstRoom.click();
		} else {
			tab.lastRoom.click();
		}

		tab.cancelBatch.click();
	}

	@Test
	@Ignore
	public void adminCreateNewBatchAndCancel7() {
		// click on batch tab and input data using hibernate
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();

		BatchAnnotation newBatch = new BatchAnnotation();
		newBatch = batch.findBatchById(7);

		if (newBatch.getCore().equals("Java") == true) {
			tab.coreDropdownJava.click();
		} else  {
			tab.coreDropdownNet.click();
		}

		tab.calendar.click();
		tab.today.click();

		tab.trainerDropdown.click();
		if (newBatch.getTrainer().equals("August")) {
			tab.trainer1.click();
		} else {
			tab.trainer2.click();
		}

		tab.cotrainerDropdown.click();
		tab.august.click();

		tab.locationDropdown.click();
		if (newBatch.getLocation().equals("Revature HQ")) {
			tab.revature.click();
		} else if (newBatch.getLocation().equals("Capital One")) {
			tab.wv.click();
		} else {
			tab.revature.click();
		}

		tab.buildingDropdown.click();
		if (newBatch.getBuilding().equals("11730 Plaza American Drive (HQ)")) {
			tab.firstBuilding.click();
		} else {
			tab.lastBuilding.click();
		}

		tab.roomDropdown.click();
		if (newBatch.getRoom() == 208) {
			tab.firstRoom.click();
		} else {
			tab.lastRoom.click();
		}

		tab.cancelBatch.click();
	}

	@Test
	@Ignore
	public void adminCreateNewBatchAndCancel8() {
		// click on batch tab and input data using hibernate
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();

		BatchAnnotation newBatch = new BatchAnnotation();
		newBatch = batch.findBatchById(8);

		if (newBatch.getCore().equals("Java") == true) {
			tab.coreDropdownJava.click();
		} else  {
			tab.coreDropdownNet.click();
		}

		tab.calendar.click();
		tab.today.click();

		tab.trainerDropdown.click();
		if (newBatch.getTrainer().equals("August")) {
			tab.trainer1.click();
		} else {
			tab.trainer2.click();
		}

		tab.cotrainerDropdown.click();
		tab.august.click();

		tab.locationDropdown.click();
		if (newBatch.getLocation().equals("Revature HQ")) {
			tab.revature.click();
		} else if (newBatch.getLocation().equals("Capital One")) {
			tab.wv.click();
		} else {
			tab.revature.click();
		}

		tab.buildingDropdown.click();
		if (newBatch.getBuilding().equals("11730 Plaza American Drive (HQ)")) {
			tab.firstBuilding.click();
		} else {
			tab.lastBuilding.click();
		}

		tab.roomDropdown.click();
		if (newBatch.getRoom() == 208) {
			tab.firstRoom.click();
		} else {
			tab.lastRoom.click();
		}

		tab.cancelBatch.click();
	}

	@Test
	@Ignore
	public void adminCreateNewBatchAndCancel9() {
		// click on batch tab and input data using hibernate
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();

		BatchAnnotation newBatch = new BatchAnnotation();
		newBatch = batch.findBatchById(9);

		if (newBatch.getCore().equals("Java") == true) {
			tab.coreDropdownJava.click();
		} else  {
			tab.coreDropdownNet.click();
		}

		tab.calendar.click();
		tab.today.click();

		tab.trainerDropdown.click();
		if (newBatch.getTrainer().equals("August")) {
			tab.trainer1.click();
		} else {
			tab.trainer2.click();
		}

		tab.cotrainerDropdown.click();
		tab.august.click();

		tab.locationDropdown.click();
		if (newBatch.getLocation().equals("Revature HQ")) {
			tab.revature.click();
		} else if (newBatch.getLocation().equals("Capital One")) {
			tab.wv.click();
		} else {
			tab.revature.click();
		}

		tab.buildingDropdown.click();
		if (newBatch.getBuilding().equals("11730 Plaza American Drive (HQ)")) {
			tab.firstBuilding.click();
		} else {
			tab.lastBuilding.click();
		}

		tab.roomDropdown.click();
		if (newBatch.getRoom() == 208) {
			tab.firstRoom.click();
		} else {
			tab.lastRoom.click();
		}

		tab.cancelBatch.click();
	}

	@Test
	@Ignore
	public void adminCreateNewBatchAndCancel0() {
		// click on batch tab and input data using hibernate
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();

		BatchAnnotation newBatch = new BatchAnnotation();
		newBatch = batch.findBatchById(10);

		if (newBatch.getCore().equals("Java") == true) {
			tab.coreDropdownJava.click();
		} else  {
			tab.coreDropdownNet.click();
		}

		tab.calendar.click();
		tab.today.click();

		tab.trainerDropdown.click();
		if (newBatch.getTrainer().equals("August")) {
			tab.trainer1.click();
		} else {
			tab.trainer2.click();
		}

		tab.cotrainerDropdown.click();
		tab.august.click();

		tab.locationDropdown.click();
		if (newBatch.getLocation().equals("Revature HQ")) {
			tab.revature.click();
		} else if (newBatch.getLocation().equals("Capital One")) {
			tab.wv.click();
		} else {
			tab.revature.click();
		}

		tab.buildingDropdown.click();
		if (newBatch.getBuilding().equals("11730 Plaza American Drive (HQ)")) {
			tab.firstBuilding.click();
		} else {
			tab.lastBuilding.click();
		}

		tab.roomDropdown.click();
		if (newBatch.getRoom() == 208) {
			tab.firstRoom.click();
		} else {
			tab.lastRoom.click();
		}

		tab.cancelBatch.click();
	}

	@Test
	@Ignore
	public void adminCreateNewBatchAndSubmit() {
		// click on batch tab and input data using hibernate
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();

		BatchAnnotation newBatch = new BatchAnnotation();
		newBatch = batch.findBatchById(1);

		if (newBatch.getCore().equals("Java") == true) {
			tab.coreDropdownJava.click();
		} else  {
			tab.coreDropdownNet.click();
		}

		tab.calendar.click();
		tab.today.click();

		tab.trainerDropdown.click();
		if (newBatch.getTrainer().equals("August")) {
			tab.trainer1.click();
		} else {
			tab.trainer2.click();
		}

		tab.cotrainerDropdown.click();
		tab.august.click();

		tab.locationDropdown.click();
		if (newBatch.getLocation().equals("Revature HQ")) {
			tab.revature.click();
		} else if (newBatch.getLocation().equals("Capital One")) {
			tab.wv.click();
		} else {
			tab.revature.click();
		}

		tab.buildingDropdown.click();
		if (newBatch.getBuilding().equals("11730 Plaza American Drive (HQ)")) {
			tab.firstBuilding.click();
		} else {
			tab.lastBuilding.click();
		}

		tab.roomDropdown.click();
		if (newBatch.getRoom() == 208) {
			tab.firstRoom.click();
		} else {
			tab.lastRoom.click();
		}

		tab.submitBatch.click();
	}

	@Test
	@Ignore
	public void adminIterateThroughBatchCoreList() {
		// click on batch tab spam clicks
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownNet));
		tab.coreDropdownNet.click();

		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownJava));
		tab.coreDropdownJava.click();

		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownSdet));
		tab.coreDropdownSdet.click();

		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownCustom));
		tab.coreDropdownCustom.click();

		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownCapitalone));
		tab.coreDropdownCapitalone.click();

		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownTesting));
		tab.coreDropdownTesting.click();

		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownTesting2));
		tab.coreDropdownTesting2.click();

		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownName));
		tab.coreDropdownName.click();

		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();

		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownBigdata));
		tab.coreDropdownBigdata.click();

		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownDynamics));
		tab.coreDropdownDynamics.click();

		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownPega));
		tab.coreDropdownPega.click();

		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownOracle));
		tab.coreDropdownOracle.click();

		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownGo));
		tab.coreDropdownGo.click();

		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownSalesforce));
		tab.coreDropdownSalesforce.click();

		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownBa));
		tab.coreDropdownBa.click();

		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownDfsfds));
		tab.coreDropdownDfsfds.click();
	}

	@Test
	@Ignore
	public void adminIterateThroughSkillsList() {
		// click on batch tab spam clicks
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.skillsDropdown));
		tab.skillsDropdown.click();

		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownJava));
		tab.coreDropdownJava.click();

		// click all options under skills
		tab.skillsDropdown.click();
		tab.skillsDropdownCorejava.click();
		tab.skillsDropdownJunit.click();
		tab.skillsDropdownSelenium.click();
		tab.skillsDropdownSpring.click();
		tab.skillsDropdownXYZ.click();
		tab.skillsDropdownSalesforce.click();
		tab.skillsDropdownCoresdet.click();
		tab.skillsDropdownServlets.click();
		tab.skillsDropdownJSP.click();
		tab.skillsDropdownCpp.click();
		tab.skillsDropdownOracle.click();
		tab.skillsDropdownJdbc.click();
		tab.skillsDropdownFreemarker.click();
		tab.skillsDropdownCss.click();
		tab.skillsDropdownjQuery.click();
		tab.skillsDropdownHibernate.click();
		tab.skillsDropdownRest.click();
		tab.skillsDropdownSoap.click();
		tab.skillsDropdownAspmvc.click();
		tab.skillsDropdownAspapi.click();
		tab.skillsDropdownCsharp.click();
		tab.skillsDropdownAdonet.click();
		tab.skillsDropdownMstest.click();
		tab.skillsDropdownTsql.click();
		tab.skillsDropdownEntity.click();
		tab.skillsDropdownXunit.click();
		tab.skillsDropdownNlog.click();
		tab.skillsDropdownIis.click();
		tab.skillsDropdownTestng.click();
		tab.skillsDropdownManual.click();
		tab.skillsDropdownPython.click();
		tab.skillsDropdownUft.click();
		tab.skillsDropdownCucumber.click();
		tab.skillsDropdownC.click();
		tab.skillsDropdownCorenet.click();
		tab.skillsDropdownCorejava.click();
		tab.skillsDropdownJunit.click();
		tab.skillsDropdownSelenium.click();
		tab.skillsDropdownSpring.click();
		tab.skillsDropdownXYZ.click();
		tab.skillsDropdownSalesforce.click();
		tab.skillsDropdownCoresdet.click();
		tab.skillsDropdownServlets.click();
		tab.skillsDropdownJSP.click();
		tab.skillsDropdownCpp.click();
		tab.skillsDropdownOracle.click();
		tab.skillsDropdownJdbc.click();
		tab.skillsDropdownFreemarker.click();
		tab.skillsDropdownCss.click();
		tab.skillsDropdownjQuery.click();
		tab.skillsDropdownHibernate.click();
		tab.skillsDropdownRest.click();
		tab.skillsDropdownSoap.click();
		tab.skillsDropdownAspmvc.click();
		tab.skillsDropdownAspapi.click();
		tab.skillsDropdownCsharp.click();
		tab.skillsDropdownAdonet.click();
		tab.skillsDropdownMstest.click();
		tab.skillsDropdownTsql.click();
		tab.skillsDropdownEntity.click();
		tab.skillsDropdownXunit.click();
		tab.skillsDropdownNlog.click();
		tab.skillsDropdownIis.click();
		tab.skillsDropdownTestng.click();
		tab.skillsDropdownManual.click();
		tab.skillsDropdownPython.click();
		tab.skillsDropdownUft.click();
		tab.skillsDropdownCucumber.click();
		tab.skillsDropdownC.click();
		tab.skillsDropdownCorenet.click();

	}

	// incomplete, need to assert that trainers dropdown is more than usual
	@Test
	@Ignore
	public void adminIterateThroughBatchCoreUntilMemoryFault() {
		// click on batch tab spam clicks
		// CHECK THE TRAINERS TAB! ITS WHERE THE INFORMATION FROM TABBING IS STORED
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		for (int i = 0; i < 10; i++) {
			wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
			tab.coreDropdown.click();
			wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownBigdata));
			tab.coreDropdownBigdata.click();
			wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
			tab.coreDropdown.click();
			wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownDynamics));
			tab.coreDropdownDynamics.click();
		}

	}

	@Test
	@Ignore
	public void adminIterateThroughTrainers() {
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownJava));
		tab.coreDropdownJava.click();
		tab.calendar.click();
		tab.today.click();
		tab.trainerDropdown.click();
		tab.trainer1.click();
		tab.trainerDropdown.click();
		tab.trainer2.click();
		tab.trainerDropdown.click();
		tab.trainer3.click();
		tab.trainerDropdown.click();
		tab.trainer4.click();
		tab.trainerDropdown.click();
		tab.trainer5.click();
		tab.trainerDropdown.click();
		tab.trainer6.click();
		tab.trainerDropdown.click();
		tab.trainer7.click();
		tab.trainerDropdown.click();
		tab.trainer8.click();
		tab.trainerDropdown.click();
		tab.trainer9.click();
		tab.trainerDropdown.click();
		tab.trainer10.click();
	}

	@Test
	@Ignore
	public void adminIterateThroughCotrainers() {
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownJava));
		tab.coreDropdownJava.click();
		tab.calendar.click();
		tab.today.click();
		tab.trainerDropdown.click();
		tab.trainer1.click();
		tab.cotrainerDropdown.click();
		tab.august.click();
		tab.cotrainerDropdown.click();
		tab.fred.click();
		tab.cotrainerDropdown.click();
		tab.joe.click();
		tab.cotrainerDropdown.click();
		tab.brian.click();
		tab.cotrainerDropdown.click();
		tab.taylor.click();
		tab.cotrainerDropdown.click();
		tab.patrick.click();
		tab.cotrainerDropdown.click();
		tab.yuvi.click();
		tab.cotrainerDropdown.click();
		tab.steven.click();
		tab.cotrainerDropdown.click();
		tab.ryan.click();
		tab.cotrainerDropdown.click();
		tab.richard.click();
		tab.cotrainerDropdown.click();
		tab.nicholas.click();
	}

	@Test
	@Ignore
	public void adminIterateThroughLocations() {
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownJava));
		tab.coreDropdownJava.click();
		tab.calendar.click();
		tab.today.click();
		tab.trainerDropdown.click();
		tab.trainer1.click();
		tab.cotrainerDropdown.click();
		tab.august.click();
		tab.locationDropdown.click();
		tab.revature.click();
		tab.locationDropdown.click();
		tab.wv.click();
	}

	@Test
	@Ignore
	public void adminIterateThroughBuildling() {
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownJava));
		tab.coreDropdownJava.click();
		tab.calendar.click();
		tab.today.click();
		tab.trainerDropdown.click();
		tab.trainer1.click();
		tab.cotrainerDropdown.click();
		tab.august.click();
		tab.locationDropdown.click();
		tab.revature.click();
		tab.buildingDropdown.click();
		tab.firstBuilding.click();
		tab.buildingDropdown.click();
		tab.lastBuilding.click();
	}

	@Test
	public void adminIterateThroughRoom() {
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownJava));
		tab.coreDropdownJava.click();
		tab.calendar.click();
		tab.today.click();
		tab.trainerDropdown.click();
		tab.trainer1.click();
		tab.cotrainerDropdown.click();
		tab.august.click();
		tab.locationDropdown.click();
		tab.revature.click();
		tab.roomDropdown.click();
		tab.firstRoom.click();
		tab.roomDropdown.click();
		tab.lastRoom.click();
	}
}
