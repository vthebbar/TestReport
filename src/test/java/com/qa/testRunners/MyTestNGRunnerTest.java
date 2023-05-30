package com.qa.testRunners;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		plugin = {"pretty","html:target/cucumber/Cucumber_report.html","json:target/cucumber/Cucumber_report.json","summary",
				"rerun:target/failed.txt" },
		features="src/test/resources/Features/S029_Physical&VirtualCard1.feature",
		glue={"com.qa.stepDef", "com.qa.hooks"},
		dryRun=false,
		monochrome=true,
		snippets = CAMELCASE,
		tags="@TEST"
		)
public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests {

	// for parallel run
	
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
	
	
	
}
