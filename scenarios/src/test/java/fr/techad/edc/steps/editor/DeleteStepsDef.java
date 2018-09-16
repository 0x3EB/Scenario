package fr.techad.edc.steps.editor;

import org.junit.Assert;

import cucumber.api.java.en.And;
import fr.techad.edc.pages.editor.documentationTypes.ContextualisedUIHelpComp;
import fr.techad.edc.pages.editor.documentationTypes.TrashComp;
import fr.techad.edc.utils.WebDriverFactory;

public class DeleteStepsDef {

	ContextualisedUIHelpComp context = new ContextualisedUIHelpComp(WebDriverFactory.getDriver());
	TrashComp trash = new TrashComp(WebDriverFactory.getDriver());

	@And("^delete the brick \"([^\"]*)\"$")
	public void deleteTheBrick(String strBrick) throws Throwable {
		Assert.assertTrue("CAN NOT DELETE", context.deleteBrick(strBrick));
		Assert.assertTrue("THE ITEM DELETED IS NOT STORED INOT THE TRASH", trash.verifyDelete(strBrick));
		Assert.assertTrue("THE ITEM DELETED IS NOT STORED INOT THE TRASH", trash.verifyChild(strBrick));
	}
	
	@And("^can not delete the brick \"([^\"]*)\"$")
	public void canNotDeleteTheBrick(String strBrick) throws Throwable {
		Assert.assertFalse("CAN NOT DELETE", context.deleteBrick(strBrick));
		Assert.assertFalse("THE ITEM DELETED IS NOT STORED INOT THE TRASH", trash.verifyDelete(strBrick));
		Assert.assertFalse("THE ITEM DELETED IS NOT STORED INOT THE TRASH", trash.verifyChild(strBrick));
	}

	@And("^delete the Chapter \"([^\"]*)\"$")
	public void deleteTheChapter(String strChapter) throws Throwable {
		Assert.assertTrue("CAN NOT DELETE", context.deleteChapter(strChapter));
	}
	
	@And("^can not delete the Chapter \"([^\"]*)\"$")
	public void canNotDeleteTheChapter(String strChapter) throws Throwable {
		Assert.assertFalse("CAN DELETE", context.deleteChapter(strChapter));
	}
}
