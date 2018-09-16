package fr.techad.edc.pages.editor;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import fr.techad.edc.pages.editor.contributors.ArticlesTypesComp;
import fr.techad.edc.pages.editor.documentationTypes.HowtosComp;
import fr.techad.edc.pages.editor.editorArea.ArticlesComp;
import fr.techad.edc.pages.editor.editorArea.ParametersComp;

public class CreateDocumentPage {

	private HowtosComp howtos;
	private ParametersComp parameters;
	private ArticlesTypesComp articlesTypes;
	private ConfigEditorMenuComp configEditor;
	private ArticlesComp articles;

	public CreateDocumentPage(WebDriver driver) {
		this.howtos = new HowtosComp(driver);
		this.parameters = new ParametersComp(driver);
		this.articlesTypes = new ArticlesTypesComp(driver);
		this.configEditor = new ConfigEditorMenuComp(driver);
		this.articles = new ArticlesComp(driver);
	}

	/**
	 * Check if the user can create a Procedure
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean rightClickProcedure() throws InterruptedException {
		return howtos.rightClickProcedure(1);
	}

	public boolean rightClickProcedureIDEEclipse() throws InterruptedException {
		return howtos.rightClickProcedureEDCEclipse();
	}

	/**
	 * Check if the user can create a howto
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean rightClickHowTos() throws InterruptedException {
		return howtos.rightClickHowTos();
	}

	public boolean rightClickDocument() throws InterruptedException {
		return howtos.rightClickDocument();
	}

	/**
	 * Fill the title of the parameters page
	 * 
	 * @param strTitle
	 */
	public void setRequiredParameters(String strTitle) {
		parameters.setTitle(strTitle);
	}

	/**
	 * Create the Howto/Procedure
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnCreate() throws InterruptedException {
		parameters.clickOnCreate();
	}

	/**
	 * Right click on the howto to edit
	 * 
	 * @param strHowto
	 * @throws InterruptedException
	 */
	public void editHowTo(String strHowto) throws InterruptedException {
		howtos.editHowTo(strHowto);
	}

	/**
	 * add all the articles to the text area twice
	 */
	public void addArticlesToTextArea() {
		articlesTypes.doubleClickOnArticlesDocument();
	}

	/**
	 * Go to the Articles menu on the parameters
	 * 
	 * @throws InterruptedException
	 */
	public void goToArticles() throws InterruptedException {
		configEditor.clickOnArticles();
	}

	/**
	 * Try to move the text areas
	 * 
	 * @return
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public boolean moveTextAreas() throws AWTException, InterruptedException {
		return articles.moveTextField();
	}

	public boolean writeInTextarea(String strText) throws InterruptedException {
		return articles.writeInTextArea(strText);
	}

	public boolean addTermInsertion(String strGlossary) throws InterruptedException {
		return articles.addGlossary(strGlossary);
	}

	public void addArticle(int index) {
		articlesTypes.addArticle(index);
	}
	
	public boolean checkIsGlossary(String strValue) {
		return articles.checkGlossary(strValue);
	}
}
