package com.revature.testng;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
<<<<<<< Updated upstream
=======
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
>>>>>>> Stashed changes
import org.testng.annotations.Test;

import com.revature.pagefactory.LoginPage;

public class Assignforce_Testing_KW {

	public static WebDriver driver = null;
<<<<<<< Updated upstream
	
	public static void launchApplication() {
=======
	public static BatchDaoImpl batch = new BatchDaoImpl();
	public static LoginDaoImpl login = new LoginDaoImpl();

	@BeforeMethod
	public static void launchApplicationAsAdmin() {
>>>>>>> Stashed changes
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://assignforce-client.cfapps.io/login");
	}

<<<<<<< Updated upstream
	
=======
	@AfterMethod
	public void logoutAndCloseDriver() {
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.logout));
		driver.close();
	}
>>>>>>> Stashed changes
	
	@Test
	public void testDriver() {
		launchApplication();
		LoginPage page = new LoginPage(driver);
		page.email.sendKeys("svp@revature.com");
		page.pwd.sendKeys("p@$$w0rd");
		page.login.click();
<<<<<<< Updated upstream
	}
=======
		driver.close();
	}

	@Test
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
	public void adminCreateNewBatchAndCancel10() {
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
		tab.skillsDropdownCorenet.click();

	}

	// incomplete, need to assert that trainers dropdown is more than usual
	@Test 
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
	public void adminIterateThroughTrainers() {
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdownJava));
		tab.coreDropdownJava.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(tab.calendar));
		tab.calendar.click();
		tab.today.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(tab.trainerDropdown));
		tab.trainerDropdown.click();
		tab.trainer1.click();
		tab.trainerDropdown.click();
		tab.trainer2.click();
	}

	@Test 
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
	}

	@Test 
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
		
		wait.until(ExpectedConditions.elementToBeClickable(tab.calendar));
		tab.calendar.click();
		tab.today.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(tab.trainerDropdown));
		tab.trainerDropdown.click();
		tab.trainer1.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(tab.cotrainerDropdown));
		tab.cotrainerDropdown.click();
		tab.august.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(tab.locationDropdown));
		tab.locationDropdown.click();
		tab.revature.click();
	}

	//test multiple and delete under batches can't delete
	@Test 
	public void adminEditSingleBatch() {
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(tab.editBatch1));
		tab.editBatch1.click();
		tab.editBatch2.click();
		tab.editBatch3.click();
		tab.editBatch4.click();
		tab.editBatch5.click();

	}
	
	//test checkbox and edit (DOEST WORK)
	@Test 
	public void adminEditMultipleBatch () {
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(tab.checkbox1));

		tab.checkbox1.click();
		tab.checkbox2.click();
		tab.checkbox3.click();
		tab.checkbox4.click();
		tab.checkbox5.click();
		tab.editBatch1.click();
		tab.editBatch2.click();
		tab.editBatch3.click();
		tab.editBatch4.click();
		tab.editBatch5.click();
	}

>>>>>>> Stashed changes
}
