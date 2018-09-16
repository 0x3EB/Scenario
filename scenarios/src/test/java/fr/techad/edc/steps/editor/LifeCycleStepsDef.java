package fr.techad.edc.steps.editor;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import fr.techad.edc.pages.editor.contributors.ConfigMenuContributorsComp;
import fr.techad.edc.pages.editor.contributors.LifeCycleComp;
import fr.techad.edc.utils.WebDriverFactory;

public class LifeCycleStepsDef {
	WebDriver driver = WebDriverFactory.getDriver();
	ConfigMenuContributorsComp conf = new ConfigMenuContributorsComp(driver);
	LifeCycleComp lifeCycle = new LifeCycleComp(driver);

	@And("^i can click on life cycle$")
	public void iClickOnLifeCycle() throws Throwable {
		conf.clickOnLifeCycle();
	}

	@And("^i can click on finish$")
	public void iClickOnFinish() throws Throwable {
		Assert.assertFalse("CAN NOT CLICK ON FINSH", lifeCycle.clickFinish());
	}

	@Then("^i can not edit everything$")
	public void iCanNotEditEverything() throws Throwable {
		Assert.assertFalse("CAN EDIT THE TEXT AREA", lifeCycle.editTextArea());
		Assert.assertFalse("CAN EDIT THE PARAMETERS", lifeCycle.editParameters());
		Assert.assertTrue("CAN NOT COMMENT", lifeCycle.addComment());
		Assert.assertFalse("CAN CLICK ON CONTRIBUTORS MENU", lifeCycle.clickOnContributors());
	}

	@Then("^i can click on validate$")
	public void iClickOnValidate() throws Throwable {
		Assert.assertFalse("CAN NOT CLICK ON VALIDATE", lifeCycle.clickValid());
	}

	@And("^i can not click on finish$")
	public void iCanNotClickOnFinish() throws Throwable {
		Assert.assertTrue("CAN CLICK ON FINISH", lifeCycle.clickFinish());
	}

	@Then("^i can not click on validate$")
	public void iCanNotClickOnValidate() throws Throwable {
		Assert.assertTrue("CAN CLICK ON VALIDATE", lifeCycle.clickValid());
	}
}
