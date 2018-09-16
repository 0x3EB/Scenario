package fr.techad.edc.pages.editor.contributors;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ArticlesTypesComp {
	private WebDriver driver;
	By articles = By.xpath("//li[@class='typology ng-scope']");
	ConfigMenuContributorsComp configContributors;

	public ArticlesTypesComp(WebDriver driver) {
		this.driver = driver;
		this.configContributors = new ConfigMenuContributorsComp(driver);
	}

	/**
	 * Get all the articles Types
	 * 
	 * @return Return a List of WebElements
	 */
	private List<WebElement> getArticles() {
		By article = By.xpath("//li[@class='typology ng-scope']");
		List<WebElement> findArticles = driver.findElements(article);
		return findArticles;
	}

	public void addArticle(int index) {
		Actions act = new Actions(driver);
		act.doubleClick(getArticles().get(index)).perform();
	}

	/**
	 * Test the valuue of the articles
	 * 
	 * @return Return true or false if the article is draggable
	 */
	public boolean isDraggable() {
		return driver.findElement(articles).getAttribute("draggable").equals("true");

	}

	/**
	 * Test if the user can click on the articles types
	 * 
	 * @return Return true or false if the user can go to the Articles types
	 */
	public boolean clickOnArticleTypes() {
		try {
			configContributors.clickOnArticlesTypes();
			configContributors.clickOnArticlesTypes();
			return true;
		} catch (WebDriverException ex) {
			return false;
		}
	}

	/**
	 * Permit to add all the Articles Type to the main brick
	 */
	public void doubleClickOnArticlesBrick() {
		Actions act = new Actions(driver);
		for (WebElement we : getArticles()) {
			act.doubleClick(we).perform();
		}
	}

	/**
	 * Permit to add all the Articles Types twice to the main Document
	 */
	public void doubleClickOnArticlesDocument() {
		Actions act = new Actions(driver);
		for (WebElement we : getArticles()) {
			act.doubleClick(we).perform();
			act.doubleClick(we).perform();
		}
	}

	/**
	 * Check if there are doubles
	 * 
	 * @return
	 */
	public boolean doubleExist() {
		By textArea = By.xpath("//div[@class='cke_inner cke_reset']");
		List<WebElement> findTextAreas = driver.findElements(textArea);
		return (getArticles().stream().allMatch(we -> we.getCssValue("background-color").equals("rgb(204, 204, 204)")
				&& findTextAreas.size() != getArticles().size()));
	}

	public boolean findArticleType(String strArticle) throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
		for (WebElement we : getArticles()) {
			System.out.println(we.getText());
			if (we.getText().contains(strArticle)) {
				return true;
			}
		}
		return false;
	}
}
