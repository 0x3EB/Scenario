package fr.techad.edc.pages.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import fr.techad.edc.utils.Configuration;

public class AccesConfigMenuComp {
	private WebDriver driver;
	private Configuration configuration = new Configuration();

	public AccesConfigMenuComp(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Check if the user has the permission to click on the config button
	 * 
	 * @return return true or false if the user can click on the config menu button
	 */
	public boolean clickOnConfig() {
		try {
			driver.findElement(By.xpath("//i[@class='fa fa-cog']")).click();
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	/**
	 * Check with url the acces of the config page
	 * 
	 * @return true or false if the url is the config url
	 * @throws InterruptedException
	 */
	public boolean isConfigPage() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		String currentPage = driver.getCurrentUrl();
		return currentPage.equals(this.configuration.getUrl() + "/configuration");
	}
}
