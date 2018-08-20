package com.revature.cucumber;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.model.BatchAnnotation;
import com.revature.pagefactory.BatchPage;
import com.revature.pagefactory.LoginPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GC_Batch {
	static WebDriver driver;
	public static WebDriverWait wait;
	
	public void launchAndLoginAsAdmin() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://assignforce-client.cfapps.io/login");

		LoginPage page = new LoginPage(driver);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(page.login));
		page.email.sendKeys("svp@revature.com");
		page.pwd.sendKeys("p@$$w0rd");
		page.login.click();
	}

	@Given("^the user navigates to the batch tab$")
	public void the_user_navigates_to_the_batch_tab() throws Throwable {
		launchAndLoginAsAdmin();
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.batchTab));
		tab.batchTab.click();
	}

	@When("^the user inputs \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", and (\\d+)$")
	public void the_user_inputs_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6,
			int arg7) throws Throwable {
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.coreDropdown));
		tab.coreDropdown.click();
		if (arg1.equals("Java") == true) {
			tab.coreDropdownJava.click();
		} else {
			tab.coreDropdownNet.click();
		}

		wait.until(ExpectedConditions.elementToBeClickable(tab.calendar));
		tab.calendar.click();
		tab.today.click();

		wait.until(ExpectedConditions.elementToBeClickable(tab.trainerDropdown));
		tab.trainerDropdown.click();
		if (arg3.equals("August")) {
			tab.trainer1.click();
		} else {
			tab.trainer2.click();
		}

		wait.until(ExpectedConditions.elementToBeClickable(tab.cotrainerDropdown));
		tab.cotrainerDropdown.click();
		if (arg4.equals("August")) {
			tab.august.click();
		} else {
			tab.fred.click();
		}

		wait.until(ExpectedConditions.elementToBeClickable(tab.locationDropdown));
		tab.locationDropdown.click();
		if (arg5.equals("Revature")) {
			tab.revature.click();
		} else {
			tab.wv.click();
		}

		wait.until(ExpectedConditions.elementToBeClickable(tab.buildingDropdown));
		tab.buildingDropdown.click();
		if (arg5.equals("HQ")) {
			tab.firstBuilding.click();
		} else {
			tab.lastBuilding.click();
		}

		wait.until(ExpectedConditions.elementToBeClickable(tab.roomDropdown));
		tab.roomDropdown.click();
		if (arg6.equals("208")) {
			tab.firstRoom.click();
		} else {
			tab.lastRoom.click();
		}
	}

	@When("^the user clicks the cancel button$")
	public void the_user_clicks_the_cancel_button() throws Throwable {
		BatchPage tab = new BatchPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tab.cancelBatch));
		tab.cancelBatch.click();
	}

	@Then("^the program should clear all fields$")
	public void the_program_should_clear_all_fields() throws Throwable {
		driver.close();
	}

}
