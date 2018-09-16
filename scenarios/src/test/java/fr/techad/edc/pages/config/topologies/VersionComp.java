package fr.techad.edc.pages.config.topologies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class VersionComp {
	WebDriver driver;

	By versionSelector = By.xpath("//div[@class='select-version']");
	Select versionSelectorField = new Select(
			driver.findElement(By.xpath("//select[@class='ng-pristine ng-valid ng-touched']")));

	public VersionComp(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Select the version
	 * 
	 * @param strVersion
	 */
	public void selectVersion(String strVersion) {
		versionSelectorField.selectByValue(strVersion);
	}
}
