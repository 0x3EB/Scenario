package fr.techad.edc.pages.editor;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class VersionSelectorComp {
	private WebDriver driver;

	public VersionSelectorComp(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Choose the product and the version to add Bricks or other...
	 * 
	 * @param strProduct
	 * @param strVersion
	 * @throws InterruptedException
	 */

	public void selectProductDocument(String strProduct, String strVersion) throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
		List<WebElement> listMenu = null;
		listMenu = driver.findElements(
				By.xpath("//select[@class='databox-drop-list edc-placeholder ng-untouched ng-pristine ng-invalid']"));
		if (listMenu.isEmpty()) {
			listMenu = driver
					.findElements(By.xpath("//select[@class='databox-drop-list ng-untouched ng-pristine ng-valid']"));
		}
		System.out.println(listMenu.size());
		Select listProducts = new Select(listMenu.get(0));
		listProducts.selectByVisibleText(strProduct);
		Select listVersion = new Select(listMenu.get(1));
		listVersion.selectByVisibleText(strVersion);
	}

	public void selectVersion(String strVersion) throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
		List<WebElement> listVersion = null;
		listVersion = driver.findElements(
				By.xpath("//select[@class='databox-drop-list edc-placeholder ng-untouched ng-pristine ng-invalid']"));
		Select listProducts = new Select(listVersion.get(0));
		listProducts.selectByVisibleText(strVersion);
	}

	/**
	 * Permit to go foward the process of editor
	 */
	public void clickDocument() {
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-document']")).click();
	}
}
