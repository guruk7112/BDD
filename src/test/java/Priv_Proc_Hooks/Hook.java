package Priv_Proc_Hooks;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Priv_Proc_Driver.DriverManage;
import Priv_Proc_FileUtility.FileUtility;
import Priv_proc_ObjectRepositery.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {


	FileUtility fu=new FileUtility();
	WebDriver driver;
	@Before()
	
	public void configBf() throws IOException {
		
           WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		DriverManage.setDriver(driver);
        DriverManage.getDriver().get("http://demo.procurehere.com");
        
        LoginPage login=new LoginPage(DriverManage.getDriver());
        login.loginToApp(fu.getTheDataFromPropertiesFile("un"), fu.getTheDataFromPropertiesFile("pwd"));
        login.getLoginBtn().click();
	}
	@After ()
	public void configAf(Scenario scenario) {
		
		if(scenario.isFailed()) {
			TakesScreenshot ts=(TakesScreenshot)driver;
		byte[] screen=	ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screen, "image/png", scenario.getName());
		}
		DriverManage.getDriver().quit();
	}
}