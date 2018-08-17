package com.revature.testng;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.revature.pagefactory.LoginPage;

public class LoginTests {
	
	@Test
	public void testLogin() {
		DriverAbstraction.loginSVP();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert(DriverAbstraction.driver.getCurrentUrl().equals("https://assignforce-client.cfapps.io/overview"));

		DriverAbstraction.driver.quit();
	}
	
	@Test
	public void testLogout() {
		DriverAbstraction.loginSVP();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DriverAbstraction.driver.findElement(By.id("logoutBTN")).click();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assert(DriverAbstraction.driver.getCurrentUrl().equals("https://assignforce-client.cfapps.io/login"));
		
		DriverAbstraction.driver.quit();
	}
	
}
