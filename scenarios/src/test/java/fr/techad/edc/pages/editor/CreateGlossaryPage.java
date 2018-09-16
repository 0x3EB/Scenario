package fr.techad.edc.pages.editor;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import fr.techad.edc.pages.editor.documentationTypes.DocumentationTypesMenuComp;
import fr.techad.edc.pages.editor.documentationTypes.GlossaryComp;
import fr.techad.edc.pages.editor.editorArea.ParametersComp;

public class CreateGlossaryPage {
	WebDriver driver;
	private DocumentationTypesMenuComp documentation;
	private GlossaryComp glossary;
	private ParametersComp parameters;
	public CreateGlossaryPage(WebDriver driver) {
		this.driver = driver;
		this.documentation = new DocumentationTypesMenuComp(driver);
		this.glossary = new GlossaryComp(driver);
		this.parameters = new ParametersComp(driver);
	}
	public void clickOnGlossary() throws InterruptedException {
		documentation.clickOnGlossary();
	}
	
	public void createTerm(String strName) throws InterruptedException {
		Assert.assertTrue(glossary.createTerm());
		parameters.setTitle(strName).clickOnCreate();
	}
  
}
