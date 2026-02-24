package Priv_proc_ObjectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Get started']") private WebElement getStartedBtn;
	
	@FindBy(xpath="//span[text()='Create']") private WebElement createBtn;
	
	@FindBy(xpath="//span[text()='(RFQ)']") private WebElement rfqBtn;
	
	
	public WebElement getGetStartedBtn() {
		return getStartedBtn;
	}
	public WebElement getCreateBtn() {
		return createBtn;
	}
	public WebElement getRfqBtn() {
		return rfqBtn;
	}
		
}
