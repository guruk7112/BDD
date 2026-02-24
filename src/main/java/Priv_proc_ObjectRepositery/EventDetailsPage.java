package Priv_proc_ObjectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventDetailsPage {

	WebDriver driver;

	public EventDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),' Event Details')]")
	private WebElement eventDetailsSection;;

	@FindBy(xpath = "//input[@id='urgentEvent1']")
	private WebElement urgentEventCheckbox;

	@FindBy(id = "viewSupplerName")
	private WebElement viewSupplierNameCheckbox;

	@FindBy(xpath = "//input[@placeholder='Select Unmask Owners']")
	private WebElement unmaskOwnersInputField;

	@FindBy(xpath = "(//select[@id='unMaskedUser']/parent::div/descendant::ul/li)[2]")
	private WebElement unmaskOwnersFirstOption;

	@FindBy(id = "submitStep1EventDetail")
	private WebElement submitBtn1;

	@FindBy(xpath = "//label[contains(text(),' Reference Number')]/parent::div/descendant::span")
	private WebElement errorMessageUnmastOwner;

	public WebElement getUnmaskOwnersInputField() {
		return unmaskOwnersInputField;
	}

	public WebElement getEventDetailsSection() {
		return eventDetailsSection;
	}

	public WebElement getUrgentEventCheckbox() {
		return urgentEventCheckbox;
	}

	public WebElement getViewSupplierNameCheckbox() {
		return viewSupplierNameCheckbox;
	}

	public WebElement getUnmaskOwnersFirstOption() {
		return unmaskOwnersFirstOption;
	}

	public WebElement getSubmitBtn1() {
		return submitBtn1;
	}
	public WebElement getErrorMessageUnmastOwner() {
		return errorMessageUnmastOwner;
	}

}
