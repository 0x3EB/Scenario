package fr.techad.edc.steps.editor;

import org.junit.Assert;

import cucumber.api.java.en.And;
import fr.techad.edc.pages.editor.documentationTypes.ContextualisedUIHelpComp;
import fr.techad.edc.pages.editor.documentationTypes.HowtosComp;
import fr.techad.edc.utils.WebDriverFactory;

public class ContextualCheckStepsDef {

	ContextualisedUIHelpComp contextalisedUI = new ContextualisedUIHelpComp(WebDriverFactory.getDriver());
	HowtosComp howto = new HowtosComp(WebDriverFactory.getDriver());

	@And("^verify the context of the \"([^\"]*)\" for the brick$")
	public void verifyTheContextOfTheForTheBrick(String strRole) throws Throwable {
		Assert.assertTrue("WRONG CONTEXTUAL CONTENT", contextalisedUI.checkContextualContent(strRole));
	}

	@And("^verify the context of the \"([^\"]*)\" for the document$")
	public void verifyTheContextOfTheForTheDocument(String strRole) throws Throwable {
		Assert.assertTrue("WRONG CONTEXTUAL CONTENT", howto.checkContextualContent(strRole));
	}

	@And("^verify the context of the \"([^\"]*)\" for the chapter$")
	public void verifyTheContextOfTheForTheChapter(String strRole) throws Throwable {
		Assert.assertTrue("WRONG CONTEXTUAL CONTENT", contextalisedUI.checkContextualContent(strRole));
	}
}
