package Priv_proc_ObjectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "loginSigninBtn")
	private WebElement loginBtn;

	@FindBy(xpath = "//div[text()='WELCOME TO PROCUREHERE']")
	private WebElement welcomeText;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public WebElement getWelcomeText() {
		return welcomeText;
	}

	/**
	 * login to the application using username and password
	 * 
	 * @param un
	 * @param pwd
	 */
	public void loginToApp(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
	}
}
