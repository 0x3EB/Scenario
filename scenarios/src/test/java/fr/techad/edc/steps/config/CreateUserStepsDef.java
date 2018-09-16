package fr.techad.edc.steps.config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.techad.edc.pages.config.AccesConfigMenuComp;
import fr.techad.edc.pages.config.users.CreationContactPage;
import fr.techad.edc.utils.WebDriverFactory;

public class CreateUserStepsDef {

	CreationContactPage createContact = new CreationContactPage(WebDriverFactory.getDriver());
	AccesConfigMenuComp accesConfig = new AccesConfigMenuComp(WebDriverFactory.getDriver());

	@When("I click on User Management")
	public void i_clik_on_User_Management() {
		// Write code here that turns the phrase above into concrete actions
		createContact.clickOnUserManagement();
	}

	@When("I enter the username \"([^\\\"]*)\" and email \"([^\\\\\\\"]*)\" and the firstname \"([^\\\\\\\"]*)\" and the lastname \"([^\\\\\\\"]*)\"$")
	public void i_enter_the_username_and_email_and_the_firstname_and_the_lastname(String username, String email,
			String firstname, String lastname) {
		// Write code here that turns the phrase above into concrete actions
		createContact.fillContact(email, firstname, lastname, username);
	}

	@When("I Click on create")
	public void i_Click_on_create() throws InterruptedException, MessagingException, IOException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		TimeUnit.SECONDS.sleep(5);
		createContact.CreateUser();
		;
	}

	@When("verify if username \"([^\\\"]*)\" and email \"([^\\\"]*)\" and the firstname \"([^\\\"]*)\" and the lastname \"([^\\\"]*)\" are correct")
	public void verify_if_username_and_email_and_the_firstname_and_the_lastname_are_correct(String strUser,
			String strEmail, String strFirstName, String strLastName) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		TimeUnit.SECONDS.sleep(5);
		createContact.VerifyUser(strUser, strEmail, strLastName, strFirstName);
	}

	@Then("^I click on configuration$")
	public void iClickOnConfiguration() throws Throwable {
		Assert.assertTrue("CAN NOT CLICK ON CONFIGURATION", accesConfig.clickOnConfig());
	}

}