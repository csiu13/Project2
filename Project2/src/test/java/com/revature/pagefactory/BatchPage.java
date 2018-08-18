package com.revature.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BatchPage {
	public static WebDriverWait wait;

	public BatchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "mat-tab-label-0-1")
	public WebElement batchTab;

	@FindBy(xpath = "//*[@id=\"cdk-accordion-child-3\"]/div/form/div[1]/mat-form-field[1]/div/div[1]/div")
	public WebElement coreDropdown;

	@FindBy(xpath = "//*[@id=\"mat-option-0\"]/span")
	public WebElement coreDropdownNet;

	@FindBy(xpath = "//*[@id=\"mat-option-1\"]/span")
	public WebElement coreDropdownJava;

	@FindBy(xpath = "//*[@id=\"mat-option-2\"]/span")
	public WebElement coreDropdownSdet;

	@FindBy(id = "mat-option-3")
	public WebElement coreDropdownCustom;

	@FindBy(id = "mat-option-4")
	public WebElement coreDropdownCapitalone;

	@FindBy(id = "mat-option-5")
	public WebElement coreDropdownTesting;

	@FindBy(id = "mat-option-6")
	public WebElement coreDropdownTesting2;

	@FindBy(id = "mat-option-7")
	public WebElement coreDropdownName;

	@FindBy(id = "mat-option-8")
	public WebElement coreDropdownBigdata;

	@FindBy(id = "mat-option-9")
	public WebElement coreDropdownDynamics;
	
	@FindBy(id = "mat-option-10")
	public WebElement coreDropdownPega;
	
	@FindBy(id = "mat-option-11")
	public WebElement coreDropdownOracle;
	
	@FindBy(id = "mat-option-12")
	public WebElement coreDropdownGo;
	
	@FindBy(id = "mat-option-13")
	public WebElement coreDropdownSalesforce;
	
	@FindBy(id = "mat-option-14")
	public WebElement coreDropdownBa;
	
	@FindBy(id = "mat-option-15")
	public WebElement coreDropdownDfsfds;

	@FindBy(xpath = "//*[@id=\"cdk-accordion-child-3\"]/div/form/div[2]/mat-form-field[1]/div/div[1]/div[1]/mat-datepicker-toggle/button")
	public WebElement calendar;
	
	@FindBy(xpath = "//*[@id=\"mat-datepicker-2\"]/div[2]/mat-month-view/table/tbody/tr[3]/td[6]/div")
	public WebElement today;

}