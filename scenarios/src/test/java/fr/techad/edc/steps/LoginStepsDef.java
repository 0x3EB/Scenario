package fr.techad.edc.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.techad.edc.pages.LoginPage;
import fr.techad.edc.utils.WebDriverFactory;

public class LoginStepsDef {

	public static WebDriver webdriver;
	LoginPage loginTest;

	@Given("^I am on the login page")
	public void i_am_on_the_login_page() {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		webdriver = WebDriverFactory.getDriver();
		WebDriverFactory.setup(webdriver);
		loginTest = new LoginPage(webdriver, WebDriverFactory.getConfiguration());
	}

	@When("^I enter the username \"([^\"]*)\" and  the password \"([^\"]*)\"$")
	public void iEnterTheUsernameAndThePassword(String username, String password) throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		loginTest.setUsername(username).setPassword(password);
	}

	@When("^^I click on login")
	public void i_click_on_login() {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		loginTest.clickLogin();
	}

	@Then("Homepage should be displayed")
	public void homepage_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		Assert.assertFalse(loginTest.isLoginPage());
	}

	@Then("^LoginPage should be displayed$")
	public void loginpageShouldBeDisplayed() {
		Assert.assertTrue(loginTest.isLoginPage());
	}

	@When("I log with the username \"([^\\\"]*)\" and  the password \"([^\\\"]*)\"")
	public void i_log_with_the_username_and_the_password(String strUser, String strPwd) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		TimeUnit.SECONDS.sleep(2);
		i_am_on_the_login_page();
		iEnterTheUsernameAndThePassword(strUser, strPwd);
		loginTest.clickLogin();
	}
}