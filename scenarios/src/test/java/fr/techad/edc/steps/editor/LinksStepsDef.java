package fr.techad.edc.steps.editor;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import fr.techad.edc.pages.editor.contributors.LinksComp;
import fr.techad.edc.utils.WebDriverFactory;

public class LinksStepsDef {

	LinksComp link = new LinksComp(WebDriverFactory.getDriver());

	@And("^can add an internal link of the document \"([^\"]*)\"$")
	public void canAddAnInternalLinkOfTheDocument(String strChapter) throws Throwable {
		Assert.assertTrue("CAN NOT ADD INTERNAL LINKS", link.addLinkInternal(strChapter));
		Assert.assertTrue("THE LINK HAS NOT BEEN ADD", link.checkItemLink(strChapter));
	}

	@Then("^can add an external link of the product \"([^\"]*)\" and the document \"([^\"]*)\"$")
	public void CanAddAnExternalLinkOfTheProductAndTheDocument(String strProduct, String strDoc) throws Throwable {
		Assert.assertTrue("CAN NOT ADD EXTERNAL LINKS", link.addLinkExternal(strDoc, strProduct));
		Assert.assertTrue("THE LINK HAS NOT BEEN ADD", link.checkItemLink(strDoc));
	}

	@And("^can not add an internal link of the document \"([^\"]*)\"$")
	public void canNotAddAnInternalLinkOfTheDocument(String strChapter) throws Throwable {
		Assert.assertFalse("CAN NOT ADD INTERNAL LINKS", link.addLinkInternal(strChapter));
	}

	@Then("^can not add an external link of the product \"([^\"]*)\" and the document \"([^\"]*)\"$")
	public void canNotAddAnExternalLinkOfTheProductAndTheDocument(String strProduct, String strDoc) throws Throwable {
		Assert.assertFalse("CAN NOT ADD EXTERNAL LINKS", link.addLinkExternal(strDoc, strProduct));
	}
}
