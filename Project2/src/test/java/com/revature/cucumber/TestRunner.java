package com.revature.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = {"pretty", "html:target/cucumber"}, features = "src\\test\\java\\com\\revature\\cucumber\\loginOutline.feature")
public class TestRunner extends AbstractTestNGCucumberTests{
	
}
