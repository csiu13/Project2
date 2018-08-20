package com.revature.cucumber;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pagefactory.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GC_Login {

	static WebDriver driver;
	static WebDriverWait wait;
	
	@Given("^the application is opened$")
	public void the_application_is_opened() throws Throwable {
		launchApplication();
	}
	
	public static void launchApplication() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://assignforce-client.cfapps.io/login");
	}
	

	@When("^valid \"([^\"]*)\" and \"([^\"]*)\" are entered$")
	public void valid_and_are_entered(String arg1, String arg2) throws Throwable {
		LoginPage page = new LoginPage(driver);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(page.email));
		page.email.sendKeys(arg1);
		page.pwd.sendKeys(arg2);
	}

	@When("^the user clicks the login button$")
	public void the_user_clicks_the_login_button() throws Throwable {
		LoginPage page = new LoginPage(driver);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(page.login));
		page.login.click();
	}

	@Then("^the user should be able to gain access to the application$")
	public void the_user_should_be_able_to_gain_access_to_the_application() throws Throwable {
	    System.out.println("Login successful!");
	    driver.quit();
	}

}
