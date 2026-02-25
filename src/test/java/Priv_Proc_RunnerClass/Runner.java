package Priv_Proc_RunnerClass;

import org.testng.annotations.DataProvider;

import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"src/test/resources/Features"}, 
glue= {"StepDefinition", "Priv_Proc_Hooks"}, // include hooks package so @Before runs
plugin= {"pretty","html:target/cucumber-reports.html",
		"json:target/cucumber.json",
		"junit:target/cucumber.xml",
		"rerun:target/failed.txt"}, 
 tags="@demo",
 publish=false,
 snippets=CucumberOptions.SnippetType.CAMELCASE,
 dryRun=false,
 monochrome=false
// name=" Validate login details without header"
 )
public class Runner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider
	public Object[][] scenarios() {
		// delegate to parent; rename from scenario() to scenarios() so TestNG uses this provider
		return super.scenarios();
	}
	
 
}
