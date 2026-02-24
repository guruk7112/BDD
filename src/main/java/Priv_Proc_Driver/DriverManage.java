package Priv_Proc_Driver;
import org.openqa.selenium.WebDriver;

public class DriverManage {

	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() {
		return driver.get();
		
	}
	public static void setDriver(WebDriver actDriver) {
		driver.set(actDriver);
	}
}
