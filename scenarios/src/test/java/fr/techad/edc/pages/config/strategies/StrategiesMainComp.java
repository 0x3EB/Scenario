package fr.techad.edc.pages.config.strategies;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StrategiesMainComp {
	private WebDriver driver;

	public StrategiesMainComp(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Get the list of the strategies in the tab
	 * 
	 * @return
	 */
	private List<WebElement> getStrategies() {
		List<WebElement> strategies = driver.findElements(By.xpath("//div[@class='datatable-body-cell-label']/span"));
		return strategies;
	}

	/**
	 * get a strategy with the name
	 * 
	 * @param strStrategy
	 * @return
	 */
	public WebElement getStrategy(String strStrategy) {
		for (WebElement we : getStrategies()) {
			if (we.getText().equals(strStrategy))
				return we;
		}
		return null;
	}
}
