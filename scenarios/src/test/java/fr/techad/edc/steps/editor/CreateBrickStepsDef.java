package fr.techad.edc.steps.editor;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.techad.edc.pages.editor.CreateBrickPage;
import fr.techad.edc.pages.editor.VersionSelectorComp;
import fr.techad.edc.pages.editor.documentationTypes.ContextualisedUIHelpComp;
import fr.techad.edc.steps.BrowserStepDef;
import fr.techad.edc.steps.LoginStepsDef;
import fr.techad.edc.utils.WebDriverFactory;

public class CreateBrickStepsDef {
	WebDriver driver = WebDriverFactory.getDriver();
	CreateBrickPage createBrick = new CreateBrickPage(driver);
	VersionSelectorComp versionSelector = new VersionSelectorComp(driver);
	ContextualisedUIHelpComp context = new ContextualisedUIHelpComp(driver);
	LoginStepsDef login = new LoginStepsDef();
	BrowserStepDef browser = new BrowserStepDef();

	@When("I click on Documentation")
	public void i_click_on_Documentation() {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		createBrick.clickDocumentationBtn();
	}

	@When("select the product \"([^\\\"]*)\" and the version \"([^\\\"]*)\"")
	public void select_the_product_and_the_version(String strProduct, String strVersion) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		versionSelector.selectProductDocument(strProduct, strVersion);
		click_on_Document();
	}

	@When("select the version \"([^\\\"]*)\"")
	public void select_the_version_as_editor(String strVersion) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		versionSelector.selectVersion(strVersion);
		click_on_Document();
	}

	@When("click on Document")
	public void click_on_Document() {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		versionSelector.clickDocument();
	}

	@Then("Documentpage sould be displayed")
	public void documentpage_sould_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@When("can create a new brick")
	public void can_create_a_new_brick() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		Assert.assertTrue("CAN'T CREATE A BRICK", context.rightclickDocument());
	}

	@When("can not create a new brick")
	public void can_not_create_a_new_brick() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		Assert.assertFalse("CAN CREATE A BRICK", context.rightclickDocument());
	}

	@Then("enter the title \"([^\\\"]*)\" and choose the type \"([^\\\"]*)\"")
	public void enter_the_title_and_choose_the_type(String strTitle, String strType) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		createBrick.setRequiredParameters(strTitle, strType);
		create_the_brick();
	}

	@Then("create the brick")
	public void create_the_brick() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		createBrick.createBrick();
	}

	@Given("I log with username \"([^\\\"]*)\" and password \"([^\\\"]*)\", I select the product \"([^\\\"]*)\" and the version \"([^\\\"]*)\" in documentation")
	public void i_log_with_username_and_password_I_select_the_product_and_the_version_in_documentation(
			String strUsername, String strPassword, String strProduct, String strVersion) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		login.i_am_on_the_login_page();
		login.i_log_with_the_username_and_the_password(strUsername, strPassword);
		browser.iWaitTheUrlPageChange();
		login.homepage_should_be_displayed();
		i_click_on_Documentation();
		select_the_product_and_the_version(strProduct, strVersion);
	}

	@Given("I log with username \"([^\\\"]*)\" and password \"([^\\\"]*)\", I select the version \"([^\\\"]*)\" in documentation as an editor")
	public void i_log_with_username_and_password_I_select_the_version_in_documentation_as_editor(String strUsername,
			String strPassword, String strVersion) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		login.i_am_on_the_login_page();
		login.i_log_with_the_username_and_the_password(strUsername, strPassword);
		browser.iWaitTheUrlPageChange();
		login.homepage_should_be_displayed();
		i_click_on_Documentation();
		select_the_version_as_editor(strVersion);
	}
}
