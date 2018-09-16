package fr.techad.edc.pages.editor.documentationTypes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class GlossaryComp {
	private WebDriver driver;

	public GlossaryComp(WebDriver driver) {
		this.driver = driver;
	}

	public boolean createTerm() throws InterruptedException {
		Actions action = new Actions(driver);
		TimeUnit.SECONDS.sleep(2);
		try {
			try {
				action.contextClick(driver.findElement(By.xpath(
						"/html/body/ui-view/edc-app/div/ui-view/edc-edition/div/edc-left-sidebar/aside/ul/div/edc-left-sidebar-item[6]/li/div[2]/div/edc-loader/div/edc-explorer/edc-ng-tree/div/div/div/edc-ng-tree-item/div[1]/a[2]")))
						.perform();
			} catch (NoSuchElementException ex) {
				action.contextClick(driver.findElement(By.xpath(
						"//*[@id=\"NG2_UPGRADE_31_82\"]/div/edc-explorer/edc-ng-tree/div/div/div/edc-ng-tree-item/div[1]/a[2]")))
						.perform();
			}
			driver.findElement(By.linkText("Create a term")).click();
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
}
