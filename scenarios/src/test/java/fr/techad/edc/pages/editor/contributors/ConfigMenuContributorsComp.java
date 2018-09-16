package fr.techad.edc.pages.editor.contributors;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfigMenuContributorsComp {

	private WebDriver driver;
	private static final int ARTICLES_TYPES = 8;
	private static final int IMAGES = 10;
	private static final int LINKS = 11;
	private static final int LIFE_CYCLE = 12;

	public ConfigMenuContributorsComp(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Get all the menus of the contributors side
	 * 
	 * @return Return a List of WebElement
	 */
	private List<WebElement> getContributors() {
		By contributorsList = By.xpath("//a[@class='accordion-toggle']");
		List<WebElement> findArticles = driver.findElements(contributorsList);
		return findArticles;
	}

	/**
	 * Click method that permit to click on a menu with the index
	 * 
	 * @param index
	 */
	private void clickOnContributors(int index) {
		getContributors().get(index).click();
	}

	/**
	 * Click on the Articles Types
	 * 
	 * @return Return an object of ConfigMenuContributors
	 */
	public ConfigMenuContributorsComp clickOnArticlesTypes() {
		clickOnContributors(ARTICLES_TYPES);
		return this;
	}

	/**
	 * Click on the Images
	 * 
	 * @return Return an object of ConfigMenuContributors
	 */
	public ConfigMenuContributorsComp clickOnImages() {
		clickOnContributors(IMAGES);
		return this;
	}

	/**
	 * Click on Links
	 * 
	 * @return Return an object of ConfigMenuContributors
	 * @throws InterruptedException
	 */
	public ConfigMenuContributorsComp clickOnLinks() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		clickOnContributors(LINKS);
		return this;
	}

	/**
	 * Click on Life Cycle
	 * 
	 * @return Return an object of ConfigMenuContributors
	 */
	public ConfigMenuContributorsComp clickOnLifeCycle() {
		clickOnContributors(LIFE_CYCLE);
		return this;
	}
}
