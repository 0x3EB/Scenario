package fr.techad.edc.pages.config;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author lejeune
 *
 */
public class ConfigMenuComp {

	private WebDriver driver;
	private static final int PRODUCT_MANAGEMENT = 0;
	private static final int USER_MANAGEMENT = 1;
	private static final int CONTENT_MANAGEMENT = 2;
	private static final int STRATEGIES = 0;
	private static final int TOPOLOGIES = 1;

	public ConfigMenuComp(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Retrieve all the menu of the homepage
	 * 
	 * @return Return a List of WebElements that contains All menus
	 */
	private List<WebElement> getMenuItems() {
		System.out.println(driver);

		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='congif-heading ng-scope']"));
		for (WebElement m : findElements) {
			System.out.println(m.toString());
		}
		return findElements;
	}

	/**
	 * Retrieve all the sub-menu of the homepage
	 * 
	 * @return Return a List of WebElements that contains All sub-menus
	 */

	private List<WebElement> getSubMenuItems() {
		List<WebElement> subMenu = driver.findElements(By.xpath("//a[contains(@class, 'config-sublink')]"));
		for (WebElement sb : subMenu) {
			System.out.println(sb.toString());
		}
		return subMenu;
	}

	/**
	 * Click on the menu depends on the index
	 * 
	 * @param index
	 */
	private void clickOnMenu(int index) {
		getMenuItems().get(index).click();
	}

	/**
	 * Click on the sub-menu depends on the index
	 * 
	 * @param index
	 */

	private void clickOnSubMenu(int index) {
		getSubMenuItems().get(index).click();
	}

	/**
	 * Click on the PRODUCT MANAGEMENT menu
	 * 
	 * @return Return an object ConfigMenuComp
	 */

	public ConfigMenuComp clickOnProductManagement() {
		clickOnMenu(PRODUCT_MANAGEMENT);
		return this;
	}

	/**
	 * Click on the USER MANAGEMENT menu
	 * 
	 * @return Return an object ConfigMenuComp
	 */

	public ConfigMenuComp clickOnUserManagement() {
		clickOnMenu(USER_MANAGEMENT);
		return this;
	}

	/**
	 * Click on the CONTENT MANAGEMENT menu
	 * 
	 * @return Return an object ConfigMenuComp
	 */

	private ConfigMenuComp clickOnContentManagement() {
		clickOnMenu(CONTENT_MANAGEMENT);
		return this;
	}

	/**
	 * Click on the STRATEGIES sub-menu
	 * 
	 * @return Return an object ConfigMenuComp
	 */

	public ConfigMenuComp clickOnStrategies() {
		clickOnContentManagement();
		clickOnSubMenu(STRATEGIES);
		return this;
	}

	/**
	 * Click on the TOPOLOGIES sub-menu
	 * 
	 * @return Return an object ConfigMenuComp
	 */

	public ConfigMenuComp clickOnTopologies() {
		clickOnContentManagement();
		clickOnSubMenu(TOPOLOGIES);
		return this;
	}

}
