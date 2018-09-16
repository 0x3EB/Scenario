package fr.techad.edc.steps.editor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import fr.techad.edc.pages.editor.CreateGlossaryPage;
import fr.techad.edc.utils.WebDriverFactory;

public class GlossaryStepsDef {
	
	CreateGlossaryPage glossary = new CreateGlossaryPage(WebDriverFactory.getDriver());

	@Then("^i click on Glossary$")
	public void iClickOnGlossary() throws Throwable {
		glossary.clickOnGlossary();
	}

	@And("^i create a new term with the name  \"([^\"]*)\"$")
	public void iCreateANewTermWithTheName(String strName) throws Throwable {
		glossary.createTerm(strName);
	}

	
	

}
