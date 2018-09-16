package fr.techad.edc.pages.editor.documentationTypes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DocumentationTypesMenuComp {

	private WebDriver driver;
	private static final int CONTEXTUALISED_UI_HELP = 0;
	private static final int HOW_TOS = 1;
	private static final int CONCEPTS = 2;
	private static final int TRAINING = 3;
	private static final int QNA = 4;
	private static final int GLOSSARY = 5;
	private static final int RELEASE_NOTES = 6;
	By productName = By.xpath("//a[@class='tree-item-name slate-gray']");

	public DocumentationTypesMenuComp(WebDriver driver) {
		this.driver = driver;
	}

	private List<WebElement> MenuDocumentationTypes() {
		List<WebElement> findElements = driver
				.findElements(By.xpath("//div[@class='accordion-header header-container ng-scope']"));
		return findElements;
	}

	public List<WebElement> getDocumentationTypesName() {
		List<WebElement> NameList = driver.findElements(By.xpath("//span[@class='menu-text ng-binding']"));
		return NameList;
	}

	private DocumentationTypesMenuComp clickOn(int index) {
		MenuDocumentationTypes().get(index).click();
		return this;
	}

	/**
	 * Click on the CONTEXTUALISED UI HELP menu
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public DocumentationTypesMenuComp clickOnContextualisedUIHelp() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		clickOn(CONTEXTUALISED_UI_HELP);
		return this;
	}

	/**
	 * Clikc on the HOW TOS menu
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public DocumentationTypesMenuComp clickOnHowTos() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		clickOn(HOW_TOS);
		return this;
	}

	/**
	 * Click on the CONCEPTS menu
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public DocumentationTypesMenuComp clickOnConcepts() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		clickOn(CONCEPTS);
		return this;
	}

	/**
	 * Click on the TRAINING menu
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public DocumentationTypesMenuComp clickOnTraining() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		clickOn(TRAINING);
		return this;
	}

	/**
	 * Click on the Q and A menu
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public DocumentationTypesMenuComp clickOnQnA() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		clickOn(QNA);
		return this;
	}

	/**
	 * Click on the GLOSSARY menu
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public DocumentationTypesMenuComp clickOnGlossary() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		clickOn(GLOSSARY);
		return this;
	}

	/**
	 * Click on the RELEASE NOTES menu
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public DocumentationTypesMenuComp clickOnreleaseNotes() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		clickOn(RELEASE_NOTES);
		return this;
	}

	/**
	 * Click ont the TRASH menu
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public DocumentationTypesMenuComp clickOnTrash() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.xpath("//div[@class='accordion-header ng-scope']")).click();
		return this;
	}

	/**
	 * Get all the version name to click
	 * 
	 * @return
	 */
	public List<WebElement> versionMenu() {
		List<WebElement> findElements = driver.findElements(productName);
		return findElements;
	}

	public List<WebElement> procedureList() {
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='tree-folder-header selected']"));
		return findElements;
	}

	public List<WebElement> arrowList() {
		List<WebElement> findElements = driver.findElements(By.xpath("//a[@class='ng-scope']"));
		return findElements;
	}

	/**
	 * Double click on a brick
	 * 
	 * @param strProduct
	 * @return return true or false if the brick has been double clicked
	 * @throws InterruptedException
	 */
	public boolean doubleClickProduct(String strProduct) throws InterruptedException {
		boolean val = false;
		try {
			TimeUnit.SECONDS.sleep(2);
			for (WebElement we : versionMenu()) {
				if (we.getText().equals(strProduct)) {
					Actions a = new Actions(driver);
					a.doubleClick(we).perform();
					val = true;
				}
			}
		} catch (NoSuchElementException ex) {
			return false;
		}
		return val;
	}

	public boolean checkDocumentationTypes(String strName) throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
		System.out.println(getDocumentationTypesName().size());
		for (WebElement we : getDocumentationTypesName()) {
			System.out.println(we.getText());
			if (we.getText().equals(strName))
				return true;
		}
		return false;
	}
	
	public void clickOnTESTSTRATEGY(String strName) throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
		System.out.println(getDocumentationTypesName().size());
		for (WebElement we : getDocumentationTypesName()) {
			System.out.println(we.getText());
			if (we.getText().equals(strName))
				we.click();
		}
	}
}
