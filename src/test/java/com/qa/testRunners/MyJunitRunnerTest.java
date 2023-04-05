package com.qa.testRunners;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "json:target/cucumber/Jreport.json", "html:target/cucumber/Jreport.html","summary"},
		features="src/test/resources/Features/S003_LoginScreen.feature",
		glue={"com.qa.stepDef", "com.qa.hooks"},
		dryRun=true,
		monochrome=true,
		snippets = CAMELCASE
		//tags="tag1"
		)
public class MyJunitRunnerTest {

}
