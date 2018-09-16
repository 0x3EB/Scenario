package fr.techad.edc.pages.editor.editorArea;

import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import fr.techad.edc.utils.DragNDropImg;

public class ArticlesComp {

	private WebDriver driver;
	private DragNDropImg dragNdrop;
	By textArea = By.xpath("//div[@class='cke_inner cke_reset']");

	public ArticlesComp(WebDriver driver) {
		this.driver = driver;
		this.dragNdrop = new DragNDropImg(driver);
	}

	/**
	 * Get all the texts areas in a list
	 * 
	 * @return
	 */
	public List<WebElement> getTextAreas() {
		List<WebElement> findElements = driver.findElements(textArea);
		return findElements;
	}

	public boolean writeInTextArea(String strText) throws InterruptedException {
		try {
			TimeUnit.SECONDS.sleep(5);
			driver.findElement(By.xpath(
					"/html/body/ui-view/edc-app/div/ui-view/edc-edition/div/ui-view/ng-form/edc-editor/edc-loader/div/ng-form/div/div/div/div[2]/div/div[1]/edc-writer/div[2]/ul/li[1]/div[2]/div/div/div/iframe"))
					.sendKeys(strText);
			return true;
		} catch (WebDriverException ex) {
			return false;
		}
	}

	/**
	 * Test if the users can focus on the texts areas of the main editor
	 * 
	 * @return Return true or false if the user can edit
	 */
	public boolean editText() {
		try {
			for (WebElement we : getTextAreas()) {
				try {
					we.click();
				} catch (NoSuchElementException ex) {
					return false;
				}
			}
			return true;
		} catch (WebDriverException ex) {
			return false;
		}
	}

	/**
	 * Drag and drop an object to another
	 * 
	 * @param weObject
	 * @param weTarget
	 */
	public void moveElement(WebElement weObject, WebElement weTarget) {
		Actions action = new Actions(driver);
		action.dragAndDrop(weObject, weTarget).perform();
	}

	/**
	 * Move the text field
	 * 
	 * @return return true or false if the action has been executed
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public boolean moveTextField() throws AWTException, InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		List<WebElement> targetList = driver.findElements(By.xpath("//i[@class='fa fa-thumbs-o-up']"));
		List<WebElement> fromList = driver.findElements(By.xpath("//i[@class='fa fa-exclamation-circle']"));
		WebElement from = fromList.get(0);
		WebElement target = targetList.get(1);
		try {
			dragNdrop.dragAndDrop(from, target);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public boolean addGlossary(String strGlossary) throws InterruptedException {
		try {
			TimeUnit.SECONDS.sleep(3);
			driver.findElement(By.xpath(
					"/html/body/ui-view/edc-app/div/ui-view/edc-edition/div/ui-view/ng-form/edc-editor/edc-loader/div/ng-form/div/div/div/div[2]/div/div[1]/edc-writer/div[1]/div/div/div/div/span[2]/span[7]/span[3]/a[8]/span[1]"))
					.click();
			try {
				TimeUnit.SECONDS.sleep(5);
				driver.findElement(By.xpath("//input[@class='cke_dialog_ui_input_text']")).clear();
				driver.findElement(By.xpath("//input[@class='cke_dialog_ui_input_text']")).sendKeys(strGlossary);
				driver.findElement(By.xpath("//a[@class='cke_dialog_ui_button']")).click();
				TimeUnit.SECONDS.sleep(5);
				Select glossaryTerm = new Select(
						driver.findElement(By.xpath("//select[@class='cke_dialog_ui_input_select']")));
				glossaryTerm.selectByVisibleText(strGlossary);
				TimeUnit.SECONDS.sleep(2);
				driver.findElement(By.xpath("//a[@class='cke_dialog_ui_button cke_dialog_ui_button_ok']")).click();
				return true;
			} catch (WebDriverException ex) {
				return false;
			}
		} catch (WebDriverException ex) {
			return false;
		}
	}

	public boolean checkGlossary(String strValue) {
		driver.switchTo().frame(driver.findElement(By.xpath(
				"/html/body/ui-view/edc-app/div/ui-view/edc-edition/div/ui-view/ng-form/edc-editor/edc-loader/div/ng-form/div/div/div/div[2]/div/div[1]/edc-writer/div[2]/ul/li[1]/div[2]/div/div/div/iframe")));
		WebElement span = driver.findElement(By.xpath("//span[@data-glossary]"));
		System.out.println(span.getText());
		if (span.getText().equals(strValue))
			return true;
		else
			return false;
	}
}
