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

	// Core Curriculum dropdown menu options
	@FindBy(xpath = "//*[@id=\"cdk-accordion-child-3\"]/div/form/div[1]/mat-form-field[1]/div/div[1]/div")
	public WebElement coreDropdown;
	@FindBy(css = "mat-option:first-of-type")
	public WebElement coreDropdownNet;
	@FindBy(css = "mat-option:nth-child(2)")
	public WebElement coreDropdownJava;
	@FindBy(css = "mat-option:nth-child(3)")
	public WebElement coreDropdownSdet;
	@FindBy(css = "mat-option:nth-child(4)")
	public WebElement coreDropdownCustom;
	@FindBy(css = "mat-option:nth-child(5)")
	public WebElement coreDropdownCapitalone;
	@FindBy(css = "mat-option:nth-child(6)")
	public WebElement coreDropdownTesting;
	@FindBy(css = "mat-option:nth-child(7)")
	public WebElement coreDropdownTesting2;
	@FindBy(css = "mat-option:nth-child(8)")
	public WebElement coreDropdownName;
	@FindBy(css = "mat-option:nth-child(9)")
	public WebElement coreDropdownBigdata;
	@FindBy(css = "mat-option:nth-child(10)")
	public WebElement coreDropdownDynamics;
	@FindBy(css = "mat-option:nth-child(11)")
	public WebElement coreDropdownPega;
	@FindBy(css = "mat-option:nth-child(12)")
	public WebElement coreDropdownOracle;
	@FindBy(css = "mat-option:nth-child(13)")
	public WebElement coreDropdownGo;
	@FindBy(css = "mat-option:nth-child(14)")
	public WebElement coreDropdownSalesforce;
	@FindBy(css = "mat-option:nth-child(15)")
	public WebElement coreDropdownBa;
	@FindBy(css = "mat-option:last-of-type")
	public WebElement coreDropdownDfsfds;

	// Skills dropdown
	@FindBy(xpath = "//*[@id=\"mat-select-4\"]/div/div[2]/div")
	public WebElement skillsDropdown;
	@FindBy(css = "mat-pseudo-checkbox:first-of-type")
	public WebElement skillsDropdownCorejava;
	@FindBy(css = "#mat-option-127 > mat-pseudo-checkbox")
	public WebElement skillsDropdownJunit;
	@FindBy(css = "#mat-option-128 > mat-pseudo-checkbox")
	public WebElement skillsDropdownSelenium;
	@FindBy(css = "#mat-option-129 > mat-pseudo-checkbox")
	public WebElement skillsDropdownSpring;
	@FindBy(css = "#mat-option-130 > mat-pseudo-checkbox")
	public WebElement skillsDropdownXYZ;
	@FindBy(css = "#mat-option-131 > mat-pseudo-checkbox")
	public WebElement skillsDropdownSalesforce;
	@FindBy(css = "#mat-option-132 > mat-pseudo-checkbox")
	public WebElement skillsDropdownCoresdet;
	@FindBy(css = "#mat-option-133 > mat-pseudo-checkbox")
	public WebElement skillsDropdownServlets;
	@FindBy(css = "#mat-option-134 > mat-pseudo-checkbox")
	public WebElement skillsDropdownJSP;
	@FindBy(css = "#mat-option-135 > mat-pseudo-checkbox")
	public WebElement skillsDropdownCpp;
	@FindBy(css = "#mat-option-136 > mat-pseudo-checkbox")
	public WebElement skillsDropdownOracle;
	@FindBy(css = "#mat-option-137 > mat-pseudo-checkbox")
	public WebElement skillsDropdownJdbc;
	@FindBy(css = "#mat-option-138 > mat-pseudo-checkbox")
	public WebElement skillsDropdownFreemarker;
	@FindBy(css = "#mat-option-139 > mat-pseudo-checkbox")
	public WebElement skillsDropdownCss;
	@FindBy(css = "#mat-option-140 > mat-pseudo-checkbox")
	public WebElement skillsDropdownjQuery;
	@FindBy(css = "#mat-option-141 > mat-pseudo-checkbox")
	public WebElement skillsDropdownHibernate;
	@FindBy(css = "#mat-option-142 > mat-pseudo-checkbox")
	public WebElement skillsDropdownRest;
	@FindBy(css = "#mat-option-143 > mat-pseudo-checkbox")
	public WebElement skillsDropdownSoap;
	@FindBy(css = "#mat-option-144 > mat-pseudo-checkbox")
	public WebElement skillsDropdownAspmvc;
	@FindBy(css = "#mat-option-145 > mat-pseudo-checkbox")
	public WebElement skillsDropdownAspapi;
	@FindBy(css = "#mat-option-146 > mat-pseudo-checkbox")
	public WebElement skillsDropdownCsharp;
	@FindBy(css = "#mat-option-147 > mat-pseudo-checkbox")
	public WebElement skillsDropdownAdonet;
	@FindBy(css = "#mat-option-148 > mat-pseudo-checkbox")
	public WebElement skillsDropdownMstest;
	@FindBy(css = "#mat-option-149 > mat-pseudo-checkbox")
	public WebElement skillsDropdownTsql;
	@FindBy(css = "#mat-option-150 > mat-pseudo-checkbox")
	public WebElement skillsDropdownEntity;
	@FindBy(css = "#mat-option-151 > mat-pseudo-checkbox")
	public WebElement skillsDropdownXunit;
	@FindBy(css = "#mat-option-152 > mat-pseudo-checkbox")
	public WebElement skillsDropdownNlog;
	@FindBy(css = "#mat-option-153 > mat-pseudo-checkbox")
	public WebElement skillsDropdownIis;
	@FindBy(css = "#mat-option-154 > mat-pseudo-checkbox")
	public WebElement skillsDropdownTestng;
	@FindBy(css = "#mat-option-155 > mat-pseudo-checkbox")
	public WebElement skillsDropdownManual;
	@FindBy(css = "#mat-option-156 > mat-pseudo-checkbox")
	public WebElement skillsDropdownPython;
	@FindBy(css = "#mat-option-157 > mat-pseudo-checkbox")
	public WebElement skillsDropdownUft;
	@FindBy(css = "#mat-option-158 > mat-pseudo-checkbox")
	public WebElement skillsDropdownCucumber;
	@FindBy(css = "#mat-option-159 > mat-pseudo-checkbox")
	public WebElement skillsDropdownC;
	@FindBy(css = "#mat-option-160 > mat-pseudo-checkbox")
	public WebElement skillsDropdownCorenet;

	// Trainer options
	@FindBy(xpath = "//*[@id=\"mat-select-5\"]")
	public WebElement trainerDropdown;
	@FindBy(css = "#mat-option-166")
	public WebElement trainer1;
	@FindBy(css = "#mat-option-167")
	public WebElement trainer2;
	@FindBy(css = "#mat-option-168")
	public WebElement trainer3;
	@FindBy(css = "#mat-option-169")
	public WebElement trainer4;
	@FindBy(css = "#mat-option-170")
	public WebElement trainer5;
	@FindBy(css = "#mat-option-171")
	public WebElement trainer6;
	@FindBy(css = "#mat-option-172")
	public WebElement trainer7;
	@FindBy(css = "#mat-option-173")
	public WebElement trainer8;
	@FindBy(css = "#mat-option-174")
	public WebElement trainer9;
	@FindBy(css = "#mat-option-175")
	public WebElement trainer10;

	// Calendar options
	@FindBy(xpath = "//*[@id=\"cdk-accordion-child-3\"]/div/form/div[2]/mat-form-field[1]/div/div[1]/div[1]/mat-datepicker-toggle/button")
	public WebElement calendar;
	@FindBy(css = "#mat-datepicker-2 > div.mat-calendar-content > mat-month-view > table > tbody > tr:nth-child(3) > td.mat-calendar-body-cell.mat-calendar-body-active.ng-star-inserted > div")
	public WebElement today;

	// Co-Trainer options
	@FindBy(css = "#mat-select-6")
	public WebElement cotrainerDropdown;
	@FindBy(css = "#mat-option-20")
	public WebElement august;
	@FindBy(css = "#mat-option-21")
	public WebElement fred;
	@FindBy(css = "#mat-option-22")
	public WebElement joe;
	@FindBy(css = "#mat-option-23")
	public WebElement brian;
	@FindBy(css = "#mat-option-24")
	public WebElement taylor;
	@FindBy(css = "#mat-option-25")
	public WebElement patrick;
	@FindBy(css = "#mat-option-26")
	public WebElement yuvi;
	@FindBy(css = "#mat-option-27")
	public WebElement steven;
	@FindBy(css = "#mat-option-28")
	public WebElement ryan;
	@FindBy(css = "#mat-option-29")
	public WebElement richard;
	@FindBy(css = "#mat-option-30")
	public WebElement nicholas;
	
	// Location options
	@FindBy(css = "#mat-select-7")
	public WebElement locationDropdown;
	@FindBy(css = "mat-option:first-of-type")
	public WebElement revature;
	@FindBy(css = "mat-option:last-of-type")
	public WebElement wv;

	// Building options
	@FindBy(css = "#mat-select-8")
	public WebElement buildingDropdown;
	@FindBy(css = "mat-option:first-of-type")
	public WebElement firstBuilding;
	@FindBy(css = "mat-option:last-of-type")
	public WebElement lastBuilding;
	
	// Location options
	@FindBy(css = "#mat-select-9")
	public WebElement roomDropdown;
	@FindBy(css = "mat-option:first-of-type")
	public WebElement firstRoom;
	@FindBy(css = "mat-option:last-of-type")
	public WebElement lastRoom;
	
	@FindBy(css = "#cdk-accordion-child-3 > div > form > div:nth-child(5) > button:nth-child(1)")
	public WebElement submitBatch;
	
	@FindBy(css = "#cdk-accordion-child-3 > div > form > div:nth-child(5) > button:nth-child(2)")
	public WebElement cancelBatch;
}