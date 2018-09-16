package fr.techad.edc.pages.config.topologies;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class TopologyStrategiesComp {
	private WebDriver driver;

	public TopologyStrategiesComp(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Search a strategy
	 * 
	 * @param strStrategy
	 */
	private void searchStrategy(String strStrategy) {
		driver.findElement(By.xpath("//div[@class='ui-select-container dropdown open']")).sendKeys(strStrategy);
		driver.findElement(By.xpath("//input[@class='form-control ui-select-search']")).sendKeys(Keys.RETURN);
	}

	/**
	 * Click on add the strategy
	 */
	private void clickOnAdd() {
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	}

	/**
	 * add the topology to the strategy
	 * 
	 * @param strStrategyName
	 * @return
	 * @throws InterruptedException
	 */
	public boolean addTopologyToStrategy(String strStrategyName) throws InterruptedException {
		try {
			TimeUnit.SECONDS.sleep(5);
			searchStrategy(strStrategyName);
			clickOnAdd();
			return true;
		} catch (WebDriverException ex) {
			return false;
		}
	}
}
