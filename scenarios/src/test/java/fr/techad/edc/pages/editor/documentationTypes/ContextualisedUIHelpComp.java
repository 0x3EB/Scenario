package fr.techad.edc.pages.editor.documentationTypes;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextualisedUIHelpComp {
	private WebDriver driver;
	private DocumentationTypesMenuComp docMenu;
	public ChildComp child = new ChildComp();
	public int numbChild = 0;

	public ContextualisedUIHelpComp(WebDriver driver) {
		this.driver = driver;
		this.docMenu = new DocumentationTypesMenuComp(driver);
	}

	/**
	 * test if the user can create a brick or not
	 * 
	 * @return Return true or false if the users can create a brick
	 * @throws InterruptedException
	 */
	public boolean rightclickDocument() throws InterruptedException {
		Actions action = new Actions(driver);
		TimeUnit.SECONDS.sleep(7);
		try {
			action.contextClick(docMenu.versionMenu().get(0)).perform();
			driver.findElement(By.linkText("Create a brick")).click();
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public boolean checkContextualContent(String strRole) throws InterruptedException, AWTException {
		strRole = strRole.toLowerCase();
		if (strRole.equals("contributor"))
			return contextCont();
		else if (strRole.equals("storehousemanager"))
			return contextStmgr();
		else if (strRole.equals("developper"))
			return contextDev();
		else
			return true;
	}

	private boolean contextStmgr() throws InterruptedException, AWTException {
		try {
			Robot robot = new Robot();
			robot.setAutoDelay(500);
			Actions action = new Actions(driver);
			TimeUnit.SECONDS.sleep(2);
			action.contextClick(docMenu.versionMenu().get(0)).perform();
			driver.findElement(By.linkText("Create a brick"));
			action.contextClick(docMenu.versionMenu().get(1)).perform();
			driver.findElement(By.linkText("Create a brick"));
			driver.findElement(By.linkText("Delete"));
			driver.findElement(By.linkText("Edit"));
			driver.findElement(By.linkText("Add a comment"));
			robot.mouseMove(800, 800);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	private boolean contextCont() throws InterruptedException {
		try {
			Actions action = new Actions(driver);
			TimeUnit.SECONDS.sleep(2);
			action.contextClick(docMenu.versionMenu().get(1)).perform();
			driver.findElement(By.linkText("Edit"));
			driver.findElement(By.linkText("Add a comment"));
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	private boolean contextDev() throws InterruptedException, AWTException {
		try {
			Robot robot = new Robot();
			robot.setAutoDelay(500);
			Actions action = new Actions(driver);
			TimeUnit.SECONDS.sleep(2);
			action.contextClick(docMenu.versionMenu().get(0)).perform();
			driver.findElement(By.linkText("Create a brick"));
			driver.findElement(By.linkText("Publish a test content"));
			action.contextClick(docMenu.versionMenu().get(1)).perform();
			driver.findElement(By.linkText("Create a brick"));
			driver.findElement(By.linkText("Delete"));
			driver.findElement(By.linkText("Edit"));
			driver.findElement(By.linkText("Add a comment"));
			robot.mouseMove(800, 800);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	/**
	 * Do a rigth click and go to edit
	 * 
	 * @param strBrick
	 * @throws InterruptedException
	 */
	public void edit(String strEdit) throws InterruptedException {
		Actions action = new Actions(driver);
		TimeUnit.SECONDS.sleep(2);
		for (WebElement we : docMenu.versionMenu()) {
			if (we.getText().equals(strEdit)) {
				try {
					action.contextClick(we).perform();
					driver.findElement(By.linkText("Edit")).click();
				} catch (NoSuchElementException ex) {
					System.out.println("err");
				}
			}
		}
	}

	public void clickAddComment(String strDoc) throws InterruptedException {
		Actions action = new Actions(driver);
		TimeUnit.SECONDS.sleep(2);
		for (WebElement we : docMenu.versionMenu()) {
			if (we.getText().equals(strDoc)) {
				try {
					action.contextClick(we).perform();
					driver.findElement(By.linkText("Add a comment")).click();
				} catch (NoSuchElementException ex) {
					System.out.println("err");
				}
			}
		}
	}

	public boolean deleteChapter(String strDoc) throws InterruptedException {
		boolean val = false;
		Actions action = new Actions(driver);
		TimeUnit.SECONDS.sleep(2);
		for (WebElement we : docMenu.versionMenu()) {
			if (we.getText().equals(strDoc)) {
				try {
					action.contextClick(we).perform();
					driver.findElement(By.linkText("Delete")).click();
					TimeUnit.SECONDS.sleep(2);
					driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
					val = true;
				} catch (NoSuchElementException ex) {
					System.out.println("err");
					return false;
				}
			}
		}
		return val;
	}

	public boolean deleteBrick(String strBrick) throws InterruptedException {
		Actions action = new Actions(driver);
		boolean cmpt = false;
		TimeUnit.SECONDS.sleep(2);
		for (WebElement we : docMenu.versionMenu()) {
			if (we.getText().equals(strBrick)) {
				TimeUnit.SECONDS.sleep(5);
				try {
					try {
						List<WebElement> chevronBrick = driver.findElements(By.xpath("//a[@class='ng-scope']"));
						chevronBrick.get(docMenu.versionMenu().indexOf(we)).click();
						TimeUnit.SECONDS.sleep(2);
						action.contextClick(we).perform();
						driver.findElement(By.linkText("Delete")).click();
						TimeUnit.SECONDS.sleep(2);
						driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
						cmpt = true;
						child.setNumChild(getNumbChidren());
					} catch (IndexOutOfBoundsException ex) {
						action.contextClick(we).perform();
						driver.findElement(By.linkText("Delete")).click();
						TimeUnit.SECONDS.sleep(2);
						driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
						cmpt = true;
					}
				} catch (NoSuchElementException ex) {
					return false;
				}
			}
		}
		return cmpt;
	}

	public int getNumbChidren() {
		return getListChildren().size();
	}

	public List<WebElement> getListChildren() {
		List<WebElement> findChild = driver.findElements(By.xpath(
				"/html/body/ui-view/edc-app/div/ui-view/edc-edition/div/edc-left-sidebar/aside/ul/div/edc-left-sidebar-item[1]/li/div[2]/div/edc-loader/div/edc-explorer/edc-ng-tree/div/div/div/edc-ng-tree-item/div[2]/div/edc-ng-tree-item/div[2]/div"));

		return findChild;
	}
}
