package fr.techad.edc.steps.editor;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import fr.techad.edc.pages.editor.contributors.LinksComp;
import fr.techad.edc.utils.WebDriverFactory;

public class ArticleLinksStepsDef {

	LinksComp links = new LinksComp(WebDriverFactory.getDriver()); 
	@Then("can not go to Links")
	public void check_doubles() throws InterruptedException {
		Assert.assertFalse("CAN CLICK ON LINKS", links.clickOnLinks());
	}
}
