package fr.techad.edc.pages.config.strategies;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class StrategyTopologiesComp {

	private WebDriver driver;

	public StrategyTopologiesComp(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Search a Topology
	 * 
	 * @param strTopologyName
	 */
	private void searchTopology(String strTopologyName) {
		driver.findElement(By.xpath("//div[@class='ui-select-container dropdown open']")).sendKeys(strTopologyName);
		driver.findElement(By.xpath("//input[@class='form-control ui-select-search']")).sendKeys(Keys.RETURN);
	}

	/**
	 * click on Add the topology
	 */
	private void clickOnAdd() {
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	}

	/**
	 * add the pology to strategy
	 * 
	 * @param strTopologyName
	 * @param strStrategyName
	 * @return
	 * @throws InterruptedException
	 */
	public boolean addTopologyToStrategy(String strTopologyName, String strStrategyName) throws InterruptedException {
		try {
			TimeUnit.SECONDS.sleep(5);
			// strategies.getStrategy(strStrategyName).click();
			searchTopology(strTopologyName);
			clickOnAdd();
			return true;
		} catch (WebDriverException ex) {
			return false;
		}
	}
}
