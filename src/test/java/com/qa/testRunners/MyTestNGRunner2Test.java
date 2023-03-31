//package com.qa.testRunners;
//
//import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;
//
//import org.testng.annotations.DataProvider;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//@CucumberOptions(
//		plugin = {"pretty", "json:target/cucumber/Cucumber_report.json", "html:target/cucumber/Cucumber_report.html","summary"},
//		features="src/test/resources/Features/Logout.feature",
//		glue={"com.qa.stepDef", "com.qa.hooks"},
//		dryRun=false,
//		monochrome=true,
//		snippets = CAMELCASE
//		//tags="tag1"
//		)
//public class MyTestNGRunner2Test extends AbstractTestNGCucumberTests {
//
//	// for parallel run
//	
//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios(){
//		return super.scenarios();
//	}
//	
//	
//	
//}
