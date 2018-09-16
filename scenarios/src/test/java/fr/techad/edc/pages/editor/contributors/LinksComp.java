package fr.techad.edc.pages.editor.contributors;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import fr.techad.edc.pages.editor.BrickInfos;

public class LinksComp {
	private WebDriver driver;
	private ConfigMenuContributorsComp configContributors;
	private BrickInfos data = new BrickInfos();

	public LinksComp(WebDriver driver) {
		this.driver = driver;
		this.configContributors = new ConfigMenuContributorsComp(driver);
	}

	/**
	 * Click on the button add links
	 */
	private void clickOnAddLinks() {
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	}

	private List<WebElement> itemsLinks() {
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='link-item']"));
		return findElements;
	}

	/**
	 * Chnage the product name on the popup window
	 * 
	 * @param strProduct
	 */
	private void changeProduct(String strProduct) {
		driver.findElement(By.xpath("//div[@class='value']")).click();
		driver.findElement(By.xpath(
				"/html/body/modal-container/div/div/edc-add-links-modal/div[2]/form/div[1]/ng-select/select-dropdown/div/div[1]/input"))
				.sendKeys(strProduct);
		driver.findElement(By.xpath(
				"/html/body/modal-container/div/div/edc-add-links-modal/div[2]/form/div[1]/ng-select/select-dropdown/div/div[1]/input"))
				.sendKeys(Keys.RETURN);
	}

	/**
	 * Try if the user can click the menu LINKS
	 * 
	 * @return true or false if the menu has been clicked
	 * @throws InterruptedException
	 */
	public boolean clickOnLinks() throws InterruptedException {
		try {
			TimeUnit.SECONDS.sleep(2);
			configContributors.clickOnLinks();
			return true;
		} catch (WebDriverException ex) {
			return false;
		}
	}

	/**
	 * Add a internal link to the brick
	 * 
	 * @param strChapter
	 * @return true or false if the the Link has been added
	 * @throws InterruptedException
	 */
	public boolean addLinkInternal(String strChapter) throws InterruptedException {
		try {
			data.setLink(strChapter);
			TimeUnit.SECONDS.sleep(5);
			driver.findElements(By.xpath("//a[@class='accordion-toggle']")).get(10).click();
			TimeUnit.SECONDS.sleep(2);
			clickOnAddLinks();
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(By.xpath("//input[@style='width: 361px;']")).sendKeys(strChapter);
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(By.xpath("/html/body/modal-container/div/div/edc-add-links-modal/div[2]/form/div[3]/ng-select/div/div/input")).sendKeys(Keys.ENTER);
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(By.xpath("/html/body/modal-container/div/div/edc-add-links-modal/div[3]/button[2]"))
					.click();
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public boolean checkItemLink(String strChapter) throws InterruptedException {
		boolean bool = false;
		TimeUnit.SECONDS.sleep(1);
		for (WebElement we : itemsLinks()) {
			if (we.getText().equals(strChapter)) {
				bool = true;
			}
		}
		return bool;
	}

	/**
	 * Add a external libk to the brick
	 * 
	 * @param strChapter
	 * @param strProduct
	 * @return true or false if the link has been added
	 * @throws InterruptedException
	 */
	public boolean addLinkExternal(String strChapter, String strProduct) throws InterruptedException {
		try {
			TimeUnit.SECONDS.sleep(1);
			clickOnAddLinks();
			try {
				changeProduct(strProduct);
				driver.findElement(By.xpath("//input[@style='width: 361px;']")).sendKeys(strChapter);
				driver.findElement(By.xpath("//input[@style='width: 291px;']")).sendKeys(Keys.ENTER);
				driver.findElement(By.xpath("/html/body/modal-container/div/div/edc-add-links-modal/div[3]/button[2]"))
						.click();
				return true;
			} catch (NoSuchElementException ex) {
				return false;
			}
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
}
