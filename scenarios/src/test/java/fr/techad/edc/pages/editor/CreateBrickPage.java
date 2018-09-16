package fr.techad.edc.pages.editor;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import fr.techad.edc.pages.editor.contributors.ArticlesTypesComp;
import fr.techad.edc.pages.editor.documentationTypes.ContextualisedUIHelpComp;
import fr.techad.edc.pages.editor.editorArea.ParametersComp;
import fr.techad.edc.utils.DragNDropImg;

public class CreateBrickPage {

	private WebDriver driver;
	ArticlesTypesComp articlesTypes;
	ContextualisedUIHelpComp context;
	ParametersComp parameters;
	VersionSelectorComp versionSelector;
	DragNDropImg dragNdrop;
	By documentationBtn = By.xpath("//i[@class='icon glyphicon glyphicon-edit']");
	By imgLocation = By.xpath("//div[@class='dz-default dz-message']");
	BrickInfos data = new BrickInfos();

	public CreateBrickPage(WebDriver driver) {
		this.driver = driver;
		this.articlesTypes = new ArticlesTypesComp(driver);
		this.context = new ContextualisedUIHelpComp(driver);
		this.parameters = new ParametersComp(driver);
		this.versionSelector = new VersionSelectorComp(driver);
		this.dragNdrop = new DragNDropImg(driver);
	}

	/**
	 * Click on documentation on the main page
	 */

	public void clickDocumentationBtn() {
		driver.findElement(documentationBtn).click();
	}

	/**
	 * Right Click to create the brick
	 * 
	 * @param strVersion
	 * @throws InterruptedException
	 */
	public void rightClickBrick(String strVersion) throws InterruptedException {
		context.rightclickDocument();
	}

	/**
	 * Fill all the required field of parameters
	 * 
	 * @param strTitle
	 * @param strTypeProduct
	 * @param strPath
	 */
	public void setRequiredParameters(String strTitle, String strTypeProduct) {
		parameters.setTitle(strTitle).setBrickType(strTypeProduct);
		data.setTitle(strTitle);
	}
	/**
	 * upload IMG
	 * 
	 * @param strPath
	 * @throws InterruptedException
	 */
	public boolean setImage(String strPath) throws InterruptedException {
		try {
			dragNdrop.DropFile(new File(strPath), 0, 0, imgLocation);
			return true;
		} catch (WebDriverException ex) {
			return false;
		}
	}

	/**
	 * Click on create the brick
	 * @throws InterruptedException 
	 */

	public void createBrick() throws InterruptedException {
		parameters.clickOnCreate();
	}

	/**
	 * Select all the Articles Types and set them up
	 * 
	 * @throws InterruptedException
	 */

	public void selectArticlesTypes() throws InterruptedException {
		articlesTypes.doubleClickOnArticlesBrick();
	}

	/**
	 * Select the correct Product and version to go to the editor
	 * 
	 * @param strProduct
	 * @param strVersion
	 * @throws InterruptedException
	 */
	public void selectProductAndVersion(String strProduct, String strVersion) throws InterruptedException {
		versionSelector.selectProductDocument(strProduct, strVersion);
	}

	/**
	 * Replace the image by another path
	 * 
	 * @param strPath
	 * @return
	 * @throws InterruptedException
	 */
	public boolean replaceImg(String strPath) throws InterruptedException {
		try {
			parameters.exchangeImg(strPath);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	/**
	 * Delete the Image
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean deleteImg() throws InterruptedException {
		try {
			parameters.removeImg();
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

}