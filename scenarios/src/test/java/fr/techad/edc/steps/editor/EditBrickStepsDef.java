package fr.techad.edc.steps.editor;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import fr.techad.edc.pages.DashBoardPage;
import fr.techad.edc.pages.editor.documentationTypes.ContextualisedUIHelpComp;
import fr.techad.edc.pages.editor.documentationTypes.DocumentationTypesMenuComp;
import fr.techad.edc.pages.editor.editorArea.ParametersComp;
import fr.techad.edc.utils.WebDriverFactory;

public class EditBrickStepsDef {
	ParametersComp parameter = new ParametersComp(WebDriverFactory.getDriver());
	DocumentationTypesMenuComp doc = new DocumentationTypesMenuComp(WebDriverFactory.getDriver());
	DashBoardPage dashboard = new DashBoardPage(WebDriverFactory.getDriver());

	@Then("can not edit the parameters page with the desciption \"([^\\\"]*)\" and main key \"([^\\\"]*)\" and subKey \"([^\\\"]*)\"")
	public void can_not_edit_the_parameters_page(String strDesc, String strMainKey, String strSubKey) {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		Assert.assertFalse("CAN EDIT THIS AREA", parameter.editBrick(strMainKey, strSubKey, strDesc));
	}

	@Then("can edit the parameters page with the desciption \"([^\\\"]*)\" and main key \"([^\\\"]*)\" and subKey \"([^\\\"]*)\"")
	public void can_edit_the_parameters_page(String strDesc, String strMainKey, String strSubKey) {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		Assert.assertTrue("CAN'T EDIT THIS AREA", parameter.editBrick(strMainKey, strSubKey, strDesc));
	}

	@Then("^double click on the brick \"([^\"]*)\"$")
	public void doubleClickOnTheBrick(String strBrick) throws Throwable {
		Assert.assertTrue("CAN NOT DOUBLE CLICK ON THE CHAPTER/DOC", doc.doubleClickProduct(strBrick));
	}

	@Then("^click on save$")
	public void clickOnSave() throws Throwable {
		parameter.clickOnCreate();
	}

	@Then("^verify the brick \"([^\"]*)\" is on the activity stream$")
	public void verifyTheBrickIsOnTheActivityStream(String arg1) throws Throwable {
		Assert.assertTrue("THE BRICK IS NOT IN THE DASH BOARD", dashboard.brickCreatedActivity(arg1));
	}

	@And("^click on contextualised UI help$")
	public void clickOnContextualisedUIHelp() throws Throwable {
		doc.clickOnContextualisedUIHelp();
	}

}
