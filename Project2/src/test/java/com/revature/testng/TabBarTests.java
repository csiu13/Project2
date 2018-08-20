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
		  driver.close();
	  }
	
	@Test
	public void testOverviewTab() {
		
		driver.findElement(By.id("mat-tab-label-0-1")).click();
		
		driver.findElement(By.id("mat-tab-label-0-0")).click();
		
		assert(driver.getCurrentUrl().equals("https://assignforce-client.cfapps.io/overview"));
	}
	
	@Test
	public void testBatchesTab() {
		
		driver.findElement(By.id("mat-tab-label-0-1")).click();
		
		assert(driver.getCurrentUrl().equals("https://assignforce-client.cfapps.io/batches"));
	}
	
	@Test
	public void testLocationsTab() {
		
		driver.findElement(By.id("mat-tab-label-0-2")).click();
		
		assert(driver.getCurrentUrl().equals("https://assignforce-client.cfapps.io/locations"));
	}
	
	@Test
	public void testCurriculaTab() {
		
		driver.findElement(By.id("mat-tab-label-0-3")).click();
		
		assert(driver.getCurrentUrl().equals("https://assignforce-client.cfapps.io/curricula"));
	}
	
	@Test
	public void testTrainersTab() {
		
		driver.findElement(By.id("mat-tab-label-0-4")).click();
		
		assert(driver.getCurrentUrl().equals("https://assignforce-client.cfapps.io/trainers"));
	}
	
	@Test
	public void testReportsTab() {
		
		driver.findElement(By.id("mat-tab-label-0-5")).click();
		
		assert(driver.getCurrentUrl().equals("https://assignforce-client.cfapps.io/reports"));
		//fails, reports tab actually points to settings page
	}
	
	@Test
	public void testSettingsTab() {
		
		driver.findElement(By.className("mat-tab-header-pagination-after")).click();
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.id("mat-tab-label-0-6")).click();
		
		
		assert(driver.getCurrentUrl().equals("https://assignforce-client.cfapps.io/profile/svp@revature.com"));
		//fails, settings tab actually points to reports page
	}
}
