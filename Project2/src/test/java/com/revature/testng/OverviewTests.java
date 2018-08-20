package com.revature.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;

public class OverviewTests {
	  @BeforeTest
	  public void beforeTest() {
		  
		  DriverAbstraction.loginSVP();
		  
		  try {
			  TimeUnit.SECONDS.sleep(5);
		  } catch (InterruptedException e) {
			  e.printStackTrace();
		  }
	  }

	  @AfterTest
	  public void afterTest() {
		  DriverAbstraction.driver.quit();
	  }
	  
	  @Test
	  public void testNameUp() {
		  
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-3.cdk-column-name.mat-column-name.ng-star-inserted > div > button")).click();
		  
		  String temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-name.mat-column-name.ng-star-inserted")).getText();
		  assert(temp.equals("-"));
		  temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-name.mat-column-name.ng-star-inserted")).getText();
		  assert(temp.equals("SEED USF 06/05"));
	  }
	  
	  @Test
	  public void testNameDown() {
		  
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-3.cdk-column-name.mat-column-name.ng-star-inserted > div > button")).click();
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-3.cdk-column-name.mat-column-name.ng-star-inserted > div > button")).click();
		  String temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-name.mat-column-name.ng-star-inserted")).getText();
		  assert(temp.equals("SEED USF 06/05"));
		  temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-name.mat-column-name.ng-star-inserted")).getText();
		  assert(temp.equals("-"));
	  }

	  @Test
	  public void testCurriculumUp() {
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-4.cdk-column-curriculum.mat-column-curriculum.ng-star-inserted > div > button")).click();
		  String temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-curriculum.mat-column-curriculum.ng-star-inserted")).getText();
		  assert(temp.equals("Java"));
		  temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-curriculum.mat-column-curriculum.ng-star-inserted")).getText();
		  assert(temp.equals(""));
	  }
	  
	  @Test
	  public void testCurriculumDown() {
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-4.cdk-column-curriculum.mat-column-curriculum.ng-star-inserted > div > button")).click();
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-4.cdk-column-curriculum.mat-column-curriculum.ng-star-inserted > div > button")).click();
		  String temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-curriculum.mat-column-curriculum.ng-star-inserted")).getText();
		  assert(temp.equals(""));
		  temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-curriculum.mat-column-curriculum.ng-star-inserted")).getText();
		  assert(temp.equals("Java"));
	  }
	  
	  @Test
	  public void testTrainerUp() {
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-5.cdk-column-trainer.mat-column-trainer.ng-star-inserted > div > button")).click();
		  String temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-trainer.mat-column-trainer.ng-star-inserted")).getText();
		  assert(temp.equals(""));
		  temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-trainer.mat-column-trainer.ng-star-inserted")).getText();
		  assert(temp.equals("August Duet"));
		  //fails
	  }
	  
	  @Test
	  public void testTrainerDown() {
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-5.cdk-column-trainer.mat-column-trainer.ng-star-inserted > div > button")).click();
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-5.cdk-column-trainer.mat-column-trainer.ng-star-inserted > div > button")).click();
		  String temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-trainer.mat-column-trainer.ng-star-inserted")).getText();
		  assert(temp.equals("August Duet"));
		  temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-trainer.mat-column-trainer.ng-star-inserted")).getText();
		  assert(temp.equals(""));
		  //fails
	  }
	  
	  @Test
	  public void testLocationUp() {
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-6.cdk-column-location.mat-column-location.ng-star-inserted > div > button")).click();
		  String temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-location.mat-column-location.ng-star-inserted")).getText();
		  assert(temp.equals(""));
		  temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-location.mat-column-location.ng-star-inserted")).getText();
		  assert(temp.equals("Revature HQ"));
	  }
	  
	  @Test
	  public void testLocationDown() {
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-6.cdk-column-location.mat-column-location.ng-star-inserted > div > button")).click();
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-6.cdk-column-location.mat-column-location.ng-star-inserted > div > button")).click();
		  String temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-location.mat-column-location.ng-star-inserted")).getText();
		  assert(temp.equals("Revature HQ"));
		  temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-location.mat-column-location.ng-star-inserted")).getText();
		  assert(temp.equals(""));
		  //fails
	  }
	  
	  @Test
	  public void testBuildingUp() {
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-7.cdk-column-building.mat-column-building.ng-star-inserted > div > button")).click();
		  String temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-building.mat-column-building.ng-star-inserted")).getText();
		  assert(temp.equals(""));
		  temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-building.mat-column-building.ng-star-inserted")).getText();
		  assert(temp.equals("11730 Plaza American Drive (HQ)"));
		  //typo: should be Plaza America Drive (HQ)
	  }
	  
	  @Test
	  public void testBuildingDown() {
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-7.cdk-column-building.mat-column-building.ng-star-inserted > div > button")).click();
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-7.cdk-column-building.mat-column-building.ng-star-inserted > div > button")).click();
		  String temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-building.mat-column-building.ng-star-inserted")).getText();
		  assert(temp.equals("11730 Plaza American Drive (HQ)"));
		  temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-building.mat-column-building.ng-star-inserted")).getText();
		  assert(temp.equals(""));
		  //typo: should be Plaza America Drive (HQ)
	  }
	  
	  @Test
	  public void testRoomUp() {
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-8.cdk-column-room.mat-column-room.ng-star-inserted > div > button")).click();
		  String temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-room.mat-column-room.ng-star-inserted")).getText();
		  assert(temp.equals(""));
		  temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-room.mat-column-room.ng-star-inserted")).getText();
		  assert(temp.equals("208"));
	  }
	  
	  @Test
	  public void testRoomDown() {
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-8.cdk-column-room.mat-column-room.ng-star-inserted > div > button")).click();
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-8.cdk-column-room.mat-column-room.ng-star-inserted > div > button")).click();
		  String temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-room.mat-column-room.ng-star-inserted")).getText();
		  assert(temp.equals("208"));
		  temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-room.mat-column-room.ng-star-inserted")).getText();
		  assert(temp.equals(""));
	  }
	  
	  @Test
	  public void testStartUp() {
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-9.cdk-column-startDate.mat-column-startDate.ng-star-inserted > div > button")).click();
		  String temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-startDate.mat-column-startDate.ng-star-inserted")).getText();
		  assert(temp.equals("Nov 14, 2016"));
		  temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-startDate.mat-column-startDate.ng-star-inserted")).getText();
		  assert(temp.equals("Sep 10, 2018"));
	  }
	  
	  @Test
	  public void testStartDown() {
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-9.cdk-column-startDate.mat-column-startDate.ng-star-inserted > div > button")).click();
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-9.cdk-column-startDate.mat-column-startDate.ng-star-inserted > div > button")).click();
		  String temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-startDate.mat-column-startDate.ng-star-inserted")).getText();
		  assert(temp.equals("Sep 10, 2018"));
		  temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-startDate.mat-column-startDate.ng-star-inserted")).getText();
		  System.out.println(temp);
		  assert(temp.equals("Nov 14, 2016"));
		  //fails, returns Dec 12, 2016
	  }
	  
	  @Test
	  public void testEndUp() {
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-10.cdk-column-endDate.mat-column-endDate.ng-star-inserted > div > button")).click();
		  String temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-endDate.mat-column-endDate.ng-star-inserted")).getText();
		  assert(temp.equals("Feb 3, 2017"));
		  temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-endDate.mat-column-endDate.ng-star-inserted")).getText();
		  assert(temp.equals("Nov 30, 2018"));
	  }
	  
	  @Test
	  public void testEndDown() {
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-10.cdk-column-endDate.mat-column-endDate.ng-star-inserted > div > button")).click();
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-10.cdk-column-endDate.mat-column-endDate.ng-star-inserted > div > button")).click();
		  String temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-endDate.mat-column-endDate.ng-star-inserted")).getText();
		  assert(temp.equals("Nov 30, 2018"));
		  temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-endDate.mat-column-endDate.ng-star-inserted")).getText();
		  assert(temp.equals("Feb 3, 2017"));
	  }
	  
	  @Test
	  public void testProgressUp() {
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-11.cdk-column-progress.mat-column-progress.ng-star-inserted > div > button")).click();
		  String temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-endDate.mat-column-endDate.ng-star-inserted")).getText();
		  assert(temp.equals("Oct 31, 2018"));
		  temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-endDate.mat-column-endDate.ng-star-inserted")).getText();
		  assert(temp.equals("Feb 3, 2017"));
	  }
	  
	  @Test
	  public void testProgressDown() {
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-11.cdk-column-progress.mat-column-progress.ng-star-inserted > div > button")).click();
		  DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-header-row > mat-header-cell.mat-header-cell.ng-tns-c13-11.cdk-column-progress.mat-column-progress.ng-star-inserted > div > button")).click();
		  String temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(2) > mat-cell.mat-cell.cdk-column-endDate.mat-column-endDate.ng-star-inserted")).getText();
		  assert(temp.equals("Jun 16, 2017"));
		  temp = DriverAbstraction.driver.findElement(By.cssSelector("#cdk-accordion-child-0 > div > div > mat-table > mat-row:nth-child(121) > mat-cell.mat-cell.cdk-column-endDate.mat-column-endDate.ng-star-inserted")).getText();
		  assert(temp.equals("Nov 1, 2018"));
	  }
}
