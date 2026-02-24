package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.NoSuchElementException;

import Priv_Proc_Driver.DriverManage;
import Priv_Proc_FileUtility.WebDriverUtility;
import Priv_proc_ObjectRepositery.EventCreationPage;
import Priv_proc_ObjectRepositery.EventDetailsPage;
import Priv_proc_ObjectRepositery.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EventDetailsRFQ {

	WebDriver driver;
	HomePage home;
	EventCreationPage event;
	EventDetailsPage details;
	WebDriverUtility web = new WebDriverUtility();

	String buyer;

	@Given("Buyer successfully loggedin")
	public void buyer_successfully_loggedin() {
		driver = DriverManage.getDriver();
		home = new HomePage(driver);
		home.getGetStartedBtn().click();

	}

	@Given("clicks on CreateButton")
	public void clicks_on_create_button() {
		home.getCreateBtn().click();
	}

	@Given("select the rfq from the options")
	public void select_the_rfq_from_the_options() {
		home.getRfqBtn().click();
	}

	@When("buyer clicks on create from blank")
	public void buyer_clicks_on_create_from_blank() {
		event = new EventCreationPage(driver);
		event.getCreateFromBlankLink().click();
	}

	@Then("the event details section should be displayed")
	public void the_event_details_section_should_be_displayed() {
		details = new EventDetailsPage(driver);
		boolean section = details.getEventDetailsSection().isDisplayed();
		Assert.assertTrue(section);
	}

	// Helper to lazily initialize details page object
	private void ensureDetailsInitialized() {
		if (details == null) {
			details = new EventDetailsPage(driver);
		}
	}

	@Given("when the buyer scroll to event settings section")
	public void when_the_buyer_scroll_to_event_settings_section() {
		web.actionScrollToAmount(driver, 0, 200);
	}

	@When("buyer clicks on urgent event checkbox")
	public void buyer_clicks_on_urgent_event_checkbox() {
		details = new EventDetailsPage(driver);
		details.getUrgentEventCheckbox().click();
	}

	@Then("the urgen event should be checked")
	public void the_urgen_event_should_be_checked() {
		ensureDetailsInitialized();
		WebElement checkbox = details.getUrgentEventCheckbox();
		boolean checked = checkbox.isSelected();
		Assert.assertTrue(checked);
	}

	@Then("uncheck the urgent event checkbox")
	public void the_urgent_event_should_be_unchecked() {
		ensureDetailsInitialized();
		WebElement checkbox = details.getUrgentEventCheckbox();
		checkbox.click();
	}

	@Then("the urgent event should be unchecked")
	public void the_event_details_section_should_be_closed() {
		ensureDetailsInitialized();
		boolean unchek = details.getUrgentEventCheckbox().isSelected();
		Assert.assertFalse(unchek);
	}

	@When("buyer clicks on unmasking owner checkbox")
	public void buyer_clicks_on_unmasking_owner_checkbox() {
		ensureDetailsInitialized();
		details.getViewSupplierNameCheckbox().click();
	}

	@Then("the unmasking owner should be checked")
	public void the_unmasking_owner_should_be_checked() {
		ensureDetailsInitialized();
		WebElement checkbox = details.getViewSupplierNameCheckbox();
		boolean checked = checkbox.isSelected();
		Assert.assertTrue(checked);
	}

	@Then("input field should be enabled")
	public void input_field_should_be_enabled() {
		ensureDetailsInitialized();
		boolean inputFiled = details.getUnmaskOwnersInputField().isEnabled();
		Assert.assertTrue(inputFiled);

	}

	@Then("buyer can enter the unmasking owner name {string}")
	public void buyer_can_enter_the_unmasking_owner_name(String buyerName) {
		ensureDetailsInitialized();
		details.getUnmaskOwnersInputField().clear();
		details.getUnmaskOwnersInputField().sendKeys(buyerName);
		buyer = buyerName;

	}

	@Then("select the option from the dropdown")
	public void select_the_option_from_the_dropdown() {
		ensureDetailsInitialized();
		details.getUnmaskOwnersFirstOption().click();

	}

	@Then("the unmasking owner should be displayed in the input field")
	public void the_unmasking_owner_should_be_displayed_in_the_input_field() {
		ensureDetailsInitialized();

		String actualValue = details.getUnmaskOwnersInputField().getAttribute("value");
		String expected = (buyer != null) ? buyer.trim() : "";
		String actual = (actualValue != null) ? actualValue.trim() : "";
		Assert.assertEquals(actual, expected);

	}

	@When("the unmasking owner is set to {string}")
	public void the_unmasking_owner_is_set_to(String action) {

	    ensureDetailsInitialized();
	    boolean expectedState = Boolean.parseBoolean(action);
	    boolean currentState = details.getViewSupplierNameCheckbox().isSelected();

	    if (currentState != expectedState) {
	        details.getViewSupplierNameCheckbox().click();
	    }
	}

	@When("click on next button at the bottom of the page")
	public void click_on_next_button_at_the_bottom_of_the_page() {
		ensureDetailsInitialized();
		web.actionScrollToElement(driver, details.getSubmitBtn1());
		details.getSubmitBtn1().click();
	}

	@Then("it should display as {string}")
	public void it_should_display_as(String expectedMessage) {

	    ensureDetailsInitialized();

	    try {
	        WebElement err = details.getErrorMessageUnmastOwner();
	        String actualMessage = (err != null) ? err.getText().trim() : "";

	        if (expectedMessage == null || expectedMessage.isEmpty()) {
	            // either no text or the element is not displayed
	            Assert.assertTrue(actualMessage.isEmpty() || !err.isDisplayed());
	        } else {
	            Assert.assertEquals(actualMessage, expectedMessage);
	        }
	    } catch (NoSuchElementException e) {
	        // If the element is not present and we expected no message that's fine
	        if (expectedMessage != null && !expectedMessage.isEmpty()) {
	            Assert.fail("Expected message '" + expectedMessage + "' but no error element was found.");
	        }
	    }
	}

	@When("the unmasking owner should be checked {string}")
	public void the_unmasking_owner_should_be_checked(String action) {
		// Feature uses quoted example: "<action>" -> values like "true" or "false"
		boolean shouldBeChecked = Boolean.parseBoolean(action.trim());
		// Ensure details page object is initialized
		ensureDetailsInitialized();
		WebElement checkbox = details.getViewSupplierNameCheckbox();
		boolean isChecked = checkbox.isSelected();
		// Click only when the current state differs from desired state
		if (shouldBeChecked != isChecked) {
			checkbox.click();
		}
		// Final assertion to guarantee correct state
		Assert.assertEquals(details.getViewSupplierNameCheckbox().isSelected(), shouldBeChecked,
				"Unmasking owner checkbox state does not match expected value: " + action);
	}
}