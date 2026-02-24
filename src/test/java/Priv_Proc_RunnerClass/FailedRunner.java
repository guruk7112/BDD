package Priv_Proc_RunnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="@target/failed.txt",glue= {"StepDefinition", "Priv_Proc_Hooks"}) // include hooks package so @Before runs)
public class FailedRunner extends AbstractTestNGCucumberTests{

	
	
}
