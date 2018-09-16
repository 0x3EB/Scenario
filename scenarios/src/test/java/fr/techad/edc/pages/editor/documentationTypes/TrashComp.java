package fr.techad.edc.pages.editor.documentationTypes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrashComp extends ChildComp{

	WebDriver driver;
	DocumentationTypesMenuComp docMenu;
	ContextualisedUIHelpComp context;

	public TrashComp(WebDriver driver) {
		this.driver = driver;
		this.docMenu = new DocumentationTypesMenuComp(driver);
		this.context = new ContextualisedUIHelpComp(driver);
	}

	private List<WebElement> listTrashContent() {
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='tree-folder-header']"));
		return findElements;
	}

	private List<WebElement> listTrashContentChild() {
		List<WebElement> findElements = driver.findElements(By.xpath(
				"/html/body/ui-view/edc-app/div/ui-view/edc-edition/div/edc-left-sidebar/aside/ul/div/edc-trash/li/div[2]/div/edc-loader/div/edc-ng-tree/div/div/div/edc-ng-tree-item/div[2]/div/edc-ng-tree-item/div[2]/div"));
		return findElements;
	}

	private List<WebElement> listChevron() {
		List<WebElement> findElements = driver.findElements(By.xpath(
				"//*[@id=\"NG2_UPGRADE_31_0\"]/div/edc-ng-tree/div/div/div/edc-ng-tree-item/div[2]/div/edc-ng-tree-item/div[1]/a"));
		return findElements;
	}

	/**
	 * Check if the brick has been deleted
	 * @param strProductName
	 * @return
	 * @throws InterruptedException
	 */
	public boolean verifyDelete(String strProductName) throws InterruptedException {
		docMenu.clickOnTrash();
		boolean bool = false;
		try {
			TimeUnit.SECONDS.sleep(1);

			for (WebElement we : listChevron()) {
				TimeUnit.SECONDS.sleep(1);
				we.click();
			}
			for (WebElement we : listTrashContent()) {
				if (we.getText().equals(strProductName)) {
					bool = true;
				}
			}
		} catch (NoSuchElementException ex) {
			return false;
		}
		return bool;
	}

	/**
	 * compare the child from the ContextualisedUIHelp area with the trash content
	 * @param strProductName
	 * @return
	 * @throws InterruptedException
	 */
	public boolean verifyChild(String strProductName) throws InterruptedException {
		boolean bool = false;
		try {
			TimeUnit.SECONDS.sleep(1);
			for (WebElement we : listTrashContentChild()) {
				if (we.getText().equals(strProductName)) {
					int indexParent = listTrashContentChild().indexOf(we);
					List<WebElement> chevrons = driver.findElements(By.xpath(
							"/html/body/ui-view/edc-app/div/ui-view/edc-edition/div/edc-left-sidebar/aside/ul/div/edc-trash/li/div[2]/div/edc-loader/div/edc-ng-tree/div/div/div/edc-ng-tree-item/div[2]/div/edc-ng-tree-item/div/div/edc-ng-tree-item/div[1]/a[1]"));
					TimeUnit.SECONDS.sleep(2);
					chevrons.get(indexParent).click();
					TimeUnit.SECONDS.sleep(2);
					List<WebElement> children = driver.findElements(By.xpath("//div[@style='padding-left: 65px;']"));
					TimeUnit.SECONDS.sleep(2);
					ChildComp child = new ChildComp();
					if (child.getNumbChild()==children.size())
						bool = true;
					else
						bool = false;
				}
			}
		} catch (NoSuchElementException ex) {
			return false;
		}
		return bool;
	}
}
