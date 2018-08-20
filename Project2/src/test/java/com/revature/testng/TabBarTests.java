package com.revature.testng;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.pagefactory.LoginPage;

public class TabBarTests {
	
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
	public void testOverviewTab() {
		
		DriverAbstraction.driver.findElement(By.id("mat-tab-label-0-1")).click();
		
		DriverAbstraction.driver.findElement(By.id("mat-tab-label-0-0")).click();
		
		assert(DriverAbstraction.driver.getCurrentUrl().equals("https://assignforce-client.cfapps.io/overview"));
	}
	
	@Test
	public void testBatchesTab() {
		
		DriverAbstraction.driver.findElement(By.id("mat-tab-label-0-1")).click();
		
		assert(DriverAbstraction.driver.getCurrentUrl().equals("https://assignforce-client.cfapps.io/batches"));
	}
	
	@Test
	public void testLocationsTab() {
		
		DriverAbstraction.driver.findElement(By.id("mat-tab-label-0-2")).click();
		
		assert(DriverAbstraction.driver.getCurrentUrl().equals("https://assignforce-client.cfapps.io/locations"));
	}
	
	@Test
	public void testCurriculaTab() {
		
		DriverAbstraction.driver.findElement(By.id("mat-tab-label-0-3")).click();
		
		assert(DriverAbstraction.driver.getCurrentUrl().equals("https://assignforce-client.cfapps.io/curricula"));
	}
	
	@Test
	public void testTrainersTab() {
		
		DriverAbstraction.driver.findElement(By.id("mat-tab-label-0-4")).click();
		
		assert(DriverAbstraction.driver.getCurrentUrl().equals("https://assignforce-client.cfapps.io/trainers"));
	}
	
	@Test
	public void testReportsTab() {
		
		DriverAbstraction.driver.findElement(By.id("mat-tab-label-0-5")).click();
		
		assert(DriverAbstraction.driver.getCurrentUrl().equals("https://assignforce-client.cfapps.io/reports"));
		//fails, reports tab actually points to settings page
	}
	
	@Test
	public void testSettingsTab() {
		
		DriverAbstraction.driver.findElement(By.className("mat-tab-header-pagination-after")).click();
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DriverAbstraction.driver.findElement(By.id("mat-tab-label-0-6")).click();
		
		
		assert(DriverAbstraction.driver.getCurrentUrl().equals("https://assignforce-client.cfapps.io/profile/svp@revature.com"));
		//fails, settings tab actually points to reports page
	}
}
