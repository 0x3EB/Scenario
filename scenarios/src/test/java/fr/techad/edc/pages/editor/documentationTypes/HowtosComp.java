package fr.techad.edc.pages.editor.documentationTypes;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HowtosComp {
	private WebDriver driver;
	private DocumentationTypesMenuComp docMenu;

	public HowtosComp(WebDriver driver) {
		this.driver = driver;
		this.docMenu = new DocumentationTypesMenuComp(driver);
	}

	/**
	 * Check if the creating procedure is possible
	 * 
	 * @return Return true or false if the the rigth click has been done
	 * @throws InterruptedException
	 */
	public boolean rightClickProcedure(int index) throws InterruptedException {
		Actions action = new Actions(driver);
		TimeUnit.SECONDS.sleep(2);
		try {
			try {
				action.contextClick(driver.findElement(By.xpath(
						"/html/body/ui-view/edc-app/div/ui-view/edc-edition/div/edc-left-sidebar/aside/ul/div/edc-left-sidebar-item[2]/li/div[2]/div/edc-loader/div/edc-explorer/edc-ng-tree/div/div/div/edc-ng-tree-item/div[1]/a[2]")))
						.perform();
			} catch (NoSuchElementException ex) {
				action.contextClick(driver.findElement(By.xpath(
						"/html/body/ui-view/edc-app/div/ui-view/edc-edition/div/edc-left-sidebar/aside/ul/div/edc-left-sidebar-item[2]/li/div[2]/div/edc-loader/div/edc-explorer/edc-ng-tree/div/div/div/edc-ng-tree-item/div[1]/a")))
						.perform();
			}
			driver.findElement(By.linkText("Create a procedure")).click();
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public boolean rightClickProcedureEDCEclipse() throws InterruptedException {
		Actions action = new Actions(driver);
		TimeUnit.SECONDS.sleep(2);
		try {
			try {
				action.contextClick(driver.findElement(By.xpath(
						"/html/body/ui-view/edc-app/div/ui-view/edc-edition/div/edc-left-sidebar/aside/ul/div/edc-left-sidebar-item[2]/li/div[2]/div/edc-loader/div/edc-explorer/edc-ng-tree/div/div/div/edc-ng-tree-item/div[1]/a[2]")))
						.perform();
			} catch (NoSuchElementException ex) {
				action.contextClick(driver.findElement(By.xpath(
						"/html/body/ui-view/edc-app/div/ui-view/edc-edition/div/edc-left-sidebar/aside/ul/div/edc-left-sidebar-item[2]/li/div[2]/div/edc-loader/div/edc-explorer/edc-ng-tree/div/div/div/edc-ng-tree-item/div[1]/a")))
						.perform();
			}
			System.out.println(driver);
			driver.findElement(By.linkText("Create a procedure")).click();
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	/**
	 * Check if the creating howtos is possible
	 * 
	 * @return Return true or false if the rigth click has been done
	 * @throws InterruptedException
	 */
	public boolean rightClickHowTos() throws InterruptedException {
		Actions action = new Actions(driver);
		TimeUnit.SECONDS.sleep(5);
		try {
			//action.contextClick(docMenu.versionMenu().get(0)).perform();
			action.contextClick(driver.findElement(By.xpath("//*[@id=\"NG2_UPGRADE_31_2\"]/div/edc-explorer/edc-ng-tree/div/div/div/edc-ng-tree-item/div[1]/a[2]"))).perform();
			System.out.println(driver);
			try {
				driver.findElement(By.linkText("Create a howto")).click();
			} catch (WebDriverException ex) {
				driver.findElement(By.linkText("Create a document")).click();
			}
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public boolean rightClickDocument() throws InterruptedException {
		Actions action = new Actions(driver);
		TimeUnit.SECONDS.sleep(2);
		try {
			try {
				action.contextClick(driver.findElement(By.xpath(
						"//*[@id=\"NG2_UPGRADE_31_8\"]/div/edc-explorer/edc-ng-tree/div/div/div/edc-ng-tree-item/div[1]")))
						.perform();
			} catch (WebDriverException ex) {
				action.contextClick(driver.findElement(By.xpath(
						"/html/body/ui-view/edc-app/div/ui-view/edc-edition/div/edc-left-sidebar/aside/ul/div/edc-left-sidebar-item[2]/li/div[2]/div/edc-loader/div/edc-explorer/edc-ng-tree/div/div/div/edc-ng-tree-item/div[1]/a[2]")))
						.perform();
			}

			System.out.println(driver);
			try {
				driver.findElement(By.linkText("Create a howto")).click();
			} catch (WebDriverException ex) {
				driver.findElement(By.linkText("Create a document")).click();
			}
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	/**
	 * Go tot the edit page of the how to
	 * 
	 * @param strHowto
	 * @throws InterruptedException
	 */
	public void editHowTo(String strHowto) throws InterruptedException {
		Actions action = new Actions(driver);
		TimeUnit.SECONDS.sleep(2);
		// docMenu.arrowList().get(2).click();
		TimeUnit.SECONDS.sleep(2);
		for (WebElement we : docMenu.versionMenu()) {
			if (we.getText().equals(strHowto)) {
				try {
					action.contextClick(we).perform();
					driver.findElement(By.linkText("Edit")).click();
				} catch (NoSuchElementException ex) {
					System.out.println("err");
				}
			}
		}
	}

	public boolean checkContextualContent(String strRole) throws InterruptedException, AWTException {
		strRole = strRole.toLowerCase();
		if (strRole.equals("contributor"))
			return contextCont();
		else if (strRole.equals("storehousemanager"))
			return contextStmgr();
		else
			return contextCont();
	}

	private boolean contextStmgr() throws InterruptedException {
		try {
			Actions action = new Actions(driver);
			TimeUnit.SECONDS.sleep(2);
			action.contextClick(docMenu.versionMenu().get(1)).perform();
			driver.findElement(By.linkText("Create a procedure"));
			driver.findElement(By.linkText("Create a howto"));
			TimeUnit.SECONDS.sleep(2);
			action.contextClick(docMenu.versionMenu().get(2)).perform();
			driver.findElement(By.linkText("Edit"));
			driver.findElement(By.linkText("Add a comment"));
			driver.findElement(By.linkText("Add as link"));
			driver.findElement(By.linkText("Delete"));
			driver.findElement(By.linkText("Edit"));
			driver.findElement(By.linkText("Add a comment"));
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	private boolean contextCont() throws InterruptedException {
		try {
			Actions action = new Actions(driver);
			TimeUnit.SECONDS.sleep(2);
			action.contextClick(docMenu.versionMenu().get(4)).perform();
			driver.findElement(By.linkText("Edit"));
			driver.findElement(By.linkText("Add a comment"));
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
}
