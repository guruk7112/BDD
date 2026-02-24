package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Priv_Proc_Driver.DriverManage;
import Priv_proc_ObjectRepositery.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSc {

	WebDriver driver; // don't fetch driver at class-load time
	LoginPage login;

	@Given("i am on the login page")
	public void i_am_on_the_login_page() {
		driver = DriverManage.getDriver();

		login = new LoginPage(driver);
		boolean username = login.getUsername().isDisplayed();
		Assert.assertTrue(username);
	}

	@When("i enter valid username and password")
	public void i_enter_valid_username_and_password(DataTable dataTable) {
		String un = dataTable.cell(0, 0);
		String pwd = dataTable.cell(0, 1);

		login.loginToApp(un, pwd);
	}

	@When("clicking on the login button")
	public void clicking_on_the_login_button() {
		login.getLoginBtn().click();
	}

	@Then("user should be successfully logged in")
	public void user_should_be_successfully_logged_in() {
		boolean text = login.getWelcomeText().isDisplayed();
		Assert.assertTrue(text);
	}
}