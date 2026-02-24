package Priv_proc_ObjectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventCreationPage {

	WebDriver driver;
	public EventCreationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[text()='Create from blank']") private WebElement createFromBlankLink;
	
	public WebElement getCreateFromBlankLink() {
		return createFromBlankLink;
	}
}
