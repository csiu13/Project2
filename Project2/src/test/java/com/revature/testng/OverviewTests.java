package com.revature.testng;

import org.testng.annotations.Test;

import com.revature.pagefactory.LoginPage;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OverviewTests {
	public static WebDriver driver = null;
	
	public static void launchApplication() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();
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
	
	@BeforeTest
	  public void beforeTest() {
		  
		  loginSVP();
		  
		  try {
			  TimeUnit.SECONDS.sleep(5);
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.quit();
	  }
	  
	  @Test
	  public void testNameUp() {
		  
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-3.cdk-column-name.mat-column-name.ng-star-inserted > div > button")).click();
		  
		  String temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-name.mat-column-name.ng-star-inserted")).getText();
		  assert(temp.equals("-"));
		  temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-name.mat-column-name.ng-star-inserted")).getText();
		  assert(temp.equals("1808 Aug20 Java"));
	  }
	  
	  @Test(dependsOnMethods = {"testNameUp"})
	  public void testNameDown() {
		  
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-3.cdk-column-name.mat-column-name.ng-star-inserted > div > button")).click();
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-3.cdk-column-name.mat-column-name.ng-star-inserted > div > button")).click();
		  String temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-name.mat-column-name.ng-star-inserted")).getText();
		  assert(temp.equals("SEED USF 06/05"));
		  temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-name.mat-column-name.ng-star-inserted")).getText();
		  assert(temp.equals("-"));
	  }

	  @Test
	  public void testCurriculumUp() {
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-4.cdk-column-curriculum.mat-column-curriculum.ng-star-inserted > div > button")).click();
		  String temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-curriculum.mat-column-curriculum.ng-star-inserted")).getText();
		  assert(temp.equals("Java"));
		  temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-curriculum.mat-column-curriculum.ng-star-inserted")).getText();
		  assert(temp.equals(""));
	  }
	  
	  @Test(dependsOnMethods = {"testCurriculumUp"})
	  public void testCurriculumDown() {
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-4.cdk-column-curriculum.mat-column-curriculum.ng-star-inserted > div > button")).click();
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-4.cdk-column-curriculum.mat-column-curriculum.ng-star-inserted > div > button")).click();
		  String temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-curriculum.mat-column-curriculum.ng-star-inserted")).getText();
		  assert(temp.equals(""));
		  temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-curriculum.mat-column-curriculum.ng-star-inserted")).getText();
		  assert(temp.equals("Java"));
	  }
	  
	  @Test
	  public void testTrainerUp() {
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-5.cdk-column-trainer.mat-column-trainer.ng-star-inserted > div > button")).click();
		  String temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-trainer.mat-column-trainer.ng-star-inserted")).getText();
		  assert(temp.equals(""));
		  temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-trainer.mat-column-trainer.ng-star-inserted")).getText();
		  assert(temp.equals("August Duet"));
		  //fails
	  }
	  
	  @Test(dependsOnMethods = {"testTrainerUp"})
	  public void testTrainerDown() {
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-5.cdk-column-trainer.mat-column-trainer.ng-star-inserted > div > button")).click();
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-5.cdk-column-trainer.mat-column-trainer.ng-star-inserted > div > button")).click();
		  String temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-trainer.mat-column-trainer.ng-star-inserted")).getText();
		  assert(temp.equals("first last"));
		  temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-trainer.mat-column-trainer.ng-star-inserted")).getText();
		  assert(temp.equals(""));
		  //fails
	  }
	  
	  @Test
	  public void testLocationUp() {
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-6.cdk-column-location.mat-column-location.ng-star-inserted > div > button")).click();
		  String temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-location.mat-column-location.ng-star-inserted")).getText();
		  assert(temp.equals(""));
		  temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-location.mat-column-location.ng-star-inserted")).getText();
		  assert(temp.equals("Revature HQ"));
	  }
	  
	  @Test(dependsOnMethods = {"testLocationUp"})
	  public void testLocationDown() {
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-6.cdk-column-location.mat-column-location.ng-star-inserted > div > button")).click();
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-6.cdk-column-location.mat-column-location.ng-star-inserted > div > button")).click();
		  String temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-location.mat-column-location.ng-star-inserted")).getText();
		  assert(temp.equals("Revature HQ"));
		  temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-location.mat-column-location.ng-star-inserted")).getText();
		  assert(temp.equals(""));
		  //fails
	  }
	  
	  @Test
	  public void testBuildingUp() {
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-7.cdk-column-building.mat-column-building.ng-star-inserted > div > button")).click();
		  String temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-building.mat-column-building.ng-star-inserted")).getText();
		  assert(temp.equals(""));
		  temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-building.mat-column-building.ng-star-inserted")).getText();
		  assert(temp.equals("11730 Plaza American Drive (HQ)"));
		  //typo: should be Plaza America Drive (HQ)
	  }
	  
	  @Test(dependsOnMethods = {"testBuildingUp"})
	  public void testBuildingDown() {
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-7.cdk-column-building.mat-column-building.ng-star-inserted > div > button")).click();
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-7.cdk-column-building.mat-column-building.ng-star-inserted > div > button")).click();
		  String temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-building.mat-column-building.ng-star-inserted")).getText();
		  assert(temp.equals("11730 Plaza American Drive (HQ)"));
		  temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-building.mat-column-building.ng-star-inserted")).getText();
		  assert(temp.equals(""));
		  //typo: should be Plaza America Drive (HQ)
	  }
	  
	  @Test
	  public void testRoomUp() {
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-8.cdk-column-room.mat-column-room.ng-star-inserted > div > button")).click();
		  String temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-room.mat-column-room.ng-star-inserted")).getText();
		  assert(temp.equals(""));
		  temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-room.mat-column-room.ng-star-inserted")).getText();
		  assert(temp.equals("208"));
	  }
	  
	  @Test(dependsOnMethods = {"testRoomUp"})
	  public void testRoomDown() {
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-8.cdk-column-room.mat-column-room.ng-star-inserted > div > button")).click();
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-8.cdk-column-room.mat-column-room.ng-star-inserted > div > button")).click();
		  String temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-room.mat-column-room.ng-star-inserted")).getText();
		  assert(temp.equals("208"));
		  temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-room.mat-column-room.ng-star-inserted")).getText();
		  assert(temp.equals(""));
	  }
	  
	  @Test
	  public void testStartUp() {
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-9.cdk-column-startDate.mat-column-startDate.ng-star-inserted > div > button")).click();
		  String temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-startDate.mat-column-startDate.ng-star-inserted")).getText();
		  assert(temp.equals("Nov 14, 2016"));
		  temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-startDate.mat-column-startDate.ng-star-inserted")).getText();
		  assert(temp.equals("Sep 10, 2018"));
	  }
	  
	  @Test(dependsOnMethods = {"testStartUp"})
	  public void testStartDown() {
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-9.cdk-column-startDate.mat-column-startDate.ng-star-inserted > div > button")).click();
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-9.cdk-column-startDate.mat-column-startDate.ng-star-inserted > div > button")).click();
		  String temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-startDate.mat-column-startDate.ng-star-inserted")).getText();
		  assert(temp.equals("Sep 10, 2018"));
		  temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-startDate.mat-column-startDate.ng-star-inserted")).getText();
		  assert(temp.equals("Dec 12, 2016"));
	  }
	  
	  @Test
	  public void testEndUp() {
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-10.cdk-column-endDate.mat-column-endDate.ng-star-inserted > div > button")).click();
		  String temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-endDate.mat-column-endDate.ng-star-inserted")).getText();
		  assert(temp.equals("Feb 3, 2017"));
		  temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-endDate.mat-column-endDate.ng-star-inserted")).getText();
		  assert(temp.equals("Nov 30, 2018"));
	  }
	  
	  @Test(dependsOnMethods = {"testEndUp"})
	  public void testEndDown() {
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-10.cdk-column-endDate.mat-column-endDate.ng-star-inserted > div > button")).click();
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-10.cdk-column-endDate.mat-column-endDate.ng-star-inserted > div > button")).click();
		  String temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-endDate.mat-column-endDate.ng-star-inserted")).getText();
		  assert(temp.equals("Nov 30, 2018"));
		  temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(122) > mat-cell.mat-cell.cdk-column-startDate.mat-column-startDate.ng-star-inserted")).getText();
		  assert(temp.equals("Nov 14, 2016"));
	  }
	  
	  @Test
	  public void testProgressUp() {
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-11.cdk-column-progress.mat-column-progress.ng-star-inserted > div > button")).click();
		  String temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-endDate.mat-column-endDate.ng-star-inserted")).getText();
		  assert(temp.equals("Oct 31, 2018"));
		  temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-endDate.mat-column-endDate.ng-star-inserted")).getText();
		  assert(temp.equals("Mar 30, 2018"));
	  }
	  
	  @Test(dependsOnMethods = {"testProgressUp"})
	  public void testProgressDown() {
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-11.cdk-column-progress.mat-column-progress.ng-star-inserted > div > button")).click();
		  driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-11.cdk-column-progress.mat-column-progress.ng-star-inserted > div > button")).click();
		  String temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-endDate.mat-column-endDate.ng-star-inserted")).getText();
		  assert(temp.equals("Jun 16, 2017"));
		  temp = driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-endDate.mat-column-endDate.ng-star-inserted")).getText();
		  assert(temp.equals("Nov 1, 2018"));
	  }
}
