package fr.techad.edc.pages.editor;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfigEditorMenuComp {
	private WebDriver driver;
	private static final int ARTICLES = 0;
	private static final int PARAMETERS = 1;
	private static final int COMMENTS = 2;

	public ConfigEditorMenuComp(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Get all the menu of the editor in a list
	 * 
	 * @return Return a list of WebElement
	 */
	public List<WebElement> MenuEditor() {
		List<WebElement> findElements = driver.findElements(By.xpath("//a[@class='nav-link ng-binding']"));
		return findElements;
	}

	/**
	 * Click on a menu method
	 * 
	 * @param index
	 * @throws InterruptedException
	 */
	private void clickOnMenu(int index) throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		MenuEditor().get(index).click();
	}

	/**
	 * Click on the menu of the editor ARTICLES
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public ConfigEditorMenuComp clickOnArticles() throws InterruptedException {
		clickOnMenu(ARTICLES);
		return this;
	}

	/**
	 * Click on the menu of the editor PARAMETERS
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public ConfigEditorMenuComp clickOnParameters() throws InterruptedException {
		clickOnMenu(PARAMETERS);
		return this;
	}

	/**
	 * Click on the menu of the editor COMMENTS
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public ConfigEditorMenuComp clickOnComments() throws InterruptedException {
		clickOnMenu(COMMENTS);
		return this;
	}
}
