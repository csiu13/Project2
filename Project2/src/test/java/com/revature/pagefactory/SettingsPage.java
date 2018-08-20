package com.revature.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SettingsPage {
	public SettingsPage (WebDriver driver) {
		PageFactory.initElements(driver,  this);
	}
	
	//settings tab
	@FindBy(css = "#mat-tab-label-0-7")
	public WebElement settingsTab;
	
	@FindBy(css = "#mat-tab-label-0-5")
	public WebElement profileTab;
	
	@FindBy(css = "#profileDiv > mat-card > mat-toolbar-row > mat-toolbar > button > span > mat-icon")
	public WebElement saveAndEditProfile;
	
	@FindBy(css = "body > app-root > div:nth-child(2) > app-menu-bar > mat-tab-group > mat-tab-header > div.mat-tab-header-pagination.mat-tab-header-pagination-after.mat-elevation-z4.mat-ripple")
	public WebElement navigate;

	@FindBy(name = "trainerPerPage")
	public WebElement trainersPerPage;
	
	@FindBy(name = "outgoingGrads")
	public WebElement outgoingGrads;
	
	@FindBy(name = "candidateIncoming")
	public WebElement candidateIncoming;

	@FindBy(name = "minBatchSize")
	public WebElement minBatchSize;
	@FindBy(name = "maxBatchSize")
	public WebElement maxBatchSize;
	@FindBy(name = "batchDuration")
	public WebElement batchDuration;
	@FindBy(name = "daysBetweenBatches")
	public WebElement daysBetweenBatches;
	@FindBy(name = "namePattern")
	public WebElement namePattern;
}
