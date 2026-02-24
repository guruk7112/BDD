package Priv_Proc_Hooks;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import Priv_Proc_Driver.DriverManage;
import Priv_Proc_FileUtility.FileUtility;
import Priv_proc_ObjectRepositery.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

//	Hooks are controlled using:
//
//		@Before("@tag")
//
//		@After("@tag")
//
//		@Before("not @tag")
//
//		@After("not @tag") etc..,

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
	public void configAf() {
		if (DriverManage.getDriver() != null) {
			DriverManage.getDriver().quit();
		}
	}
}