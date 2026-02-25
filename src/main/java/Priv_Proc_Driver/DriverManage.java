package Priv_Proc_Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManage {

	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	public static ThreadLocal<WebDriverWait> wait=new ThreadLocal<WebDriverWait>();
	
	public static WebDriver getDriver() {
		return driver.get();
		
	}
	
	public static WebDriverWait getWait() {
		return wait.get();
	}
	
	public static void setDriver(WebDriver actDriver) {
		driver.set(actDriver);
	}
	
	public static void setWebDriverWait(WebDriverWait actWait) {
		wait.set(actWait);
	}
}
