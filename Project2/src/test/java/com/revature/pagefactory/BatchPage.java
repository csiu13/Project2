package com.revature.pagefactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BatchPage {
	public static WebDriverWait wait;
	
	public BatchPage (WebDriver driver) {
		PageFactory.initElements(driver,  this);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-tab-label-0-1")));
	}
	@FindBy (id = "mat-tab-label-0-1")
	public WebElement batchTab;
	
	@FindBy (id = "mat-select-3")
	public WebElement coreDropdown;
	


}