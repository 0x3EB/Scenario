package fr.techad.edc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMenu {
	private WebDriver driver;
	By documentationBtn = By.xpath("//i[@class='icon glyphicon glyphicon-edit']");
	public MainMenu(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnDocumentation() {
		driver.findElement(documentationBtn).click();
	}
	
}
