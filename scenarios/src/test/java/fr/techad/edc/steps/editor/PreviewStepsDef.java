package fr.techad.edc.steps.editor;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import fr.techad.edc.pages.editor.PreviewPage;
import fr.techad.edc.utils.WebDriverFactory;

public class PreviewStepsDef {
	private PreviewPage preview = new PreviewPage(WebDriverFactory.getDriver());

	@Then("^click on the preview$")
	public void clickOnThePreview() throws Throwable {
		preview.clickOnPreview();
	}

	@And("^verify th econtent of the preiew$")
	public void verifyThEcontentOfThePreiew() throws Throwable {
		Assert.assertTrue(preview.checkTitle());
		Assert.assertTrue(preview.checkDesc());
		Assert.assertTrue(preview.checkLink());
	}

}
