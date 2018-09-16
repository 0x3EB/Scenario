package fr.techad.edc.steps.editor;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import fr.techad.edc.pages.editor.CreateDocumentPage;
import fr.techad.edc.pages.editor.documentationTypes.DocumentationTypesMenuComp;
import fr.techad.edc.utils.WebDriverFactory;

public class CreateDocumentStepsDef {
	private WebDriver driver = WebDriverFactory.getDriver();
	private DocumentationTypesMenuComp docMenu = new DocumentationTypesMenuComp(driver);
	private CreateDocumentPage createDoc = new CreateDocumentPage(driver);

	@Then("Go to How tos")
	public void go_to_How_tos() throws InterruptedException {
		docMenu.clickOnHowTos();
	}

	@Then("Can create a procedure")
	public void can_create_a_document() throws InterruptedException {
		Assert.assertTrue("CAN T CREATE A PROCEDURE", createDoc.rightClickProcedure());
	}

	@Then("Can not create a procedure")
	public void can_not_create_a_document() throws InterruptedException {
		Assert.assertFalse("CAN CREATE A PROCEDURE", createDoc.rightClickProcedure());
	}

	@Then("Can create a procedure in EDC ECLIPSE")
	public void can_create_a_document_EDC_ECLIPSE() throws InterruptedException {
		Assert.assertTrue("CAN NOT CREATE A PROCEDURE", createDoc.rightClickProcedureIDEEclipse());
	}

	@Then("Enter the title \"([^\\\"]*)\"")
	public void enter_the_title(String strTitle) throws InterruptedException {
		createDoc.setRequiredParameters(strTitle);
	}

	@Then("Click on create")
	public void click_on_create() throws InterruptedException {
		createDoc.clickOnCreate();
	}

	@Then("Can not create a Howto")
	public void can_not_create_howto() throws InterruptedException {
		Assert.assertFalse("CAN CREATE A PROCEDURE", createDoc.rightClickHowTos());
	}

	@Then("Can create a Howto")
	public void can_create_howto_in_the_previous_procedure() throws InterruptedException {
		Assert.assertTrue("CAN T CREATE A PROCEDURE", createDoc.rightClickHowTos());
	}

	@And("^add articles$")
	public void addArticles() throws Throwable {
		createDoc.addArticlesToTextArea();
	}

	@Then("^edit the HowTo \"([^\"]*)\"$")
	public void editTheHowTo(String strHowTo) throws Throwable {
		createDoc.editHowTo(strHowTo);
	}

	@Then("^Go to articles$")
	public void goToArticles() throws Throwable {
		createDoc.goToArticles();
	}

	@And("^can move Articles$")
	public void canMoveArticles() throws Throwable {
		Assert.assertTrue("CAN NOT MOVE ARTICLES", createDoc.moveTextAreas());
	}

	@And("^can not move Articles$")
	public void canNotMoveArticles() throws Throwable {
		Assert.assertFalse("CAN MOVE ARTICLES", createDoc.moveTextAreas());
	}

	@And("^Can create a procedure IDE$")
	public void canCreateAProcedureIDE() throws Throwable {
		Assert.assertTrue("CAN NOT CREATE A PROCEDURE", createDoc.rightClickProcedureIDEEclipse());
	}

	@Then("^Can create a document$")
	public void canCreateADocument() throws Throwable {
		Assert.assertTrue("CAN CREATE A PROCEDURE", createDoc.rightClickDocument());
	}

	@Then("^write in the textarea \"([^\"]*)\"$")
	public void writeInTheTextarea(String strText) throws Throwable {
		TimeUnit.SECONDS.sleep(5);
		Assert.assertTrue(createDoc.writeInTextarea(strText));
	}

	@And("^Select it and insert glossary term \"([^\"]*)\"$")
	public void selectItAndInsertGlossaryTerm(String strGlossary) throws Throwable {
		Assert.assertTrue(createDoc.writeInTextarea(Keys.CONTROL + "a"));
		Assert.assertTrue(createDoc.addTermInsertion(strGlossary));
	}

	@And("^add the first article type$")
	public void addTheFirstArticleType() throws Throwable {
		createDoc.addArticle(0);
	}
	
	@Then("^check if \"([^\"]*)\" is a glossary$")
	public void checkIfIsAGlossary(String strValue) throws Throwable {
		Assert.assertTrue(createDoc.checkIsGlossary(strValue));
	}
}
