package fr.techad.edc.pages.config.products;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductUsersComp {
	private WebDriver driver;
	private static final int PRODUCT_NAME = 4; // INDEX OF PRODUCT NAME

	By addUserField = By.xpath("//div[@class='ui-select-match ng-scope']");//
	By btnAddUser = By.xpath("//button[@class='btn btn-success']");// BUTTON ADD TO PRODUCT
	By SearchFieldUser = By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-valid ng-empty']");// SEARCH
																												// FIELD

	public ProductUsersComp(WebDriver webdriver) {
		this.driver = webdriver;
	}

	/**
	 * Retrieve a list of WebElement
	 * 
	 * @return
	 */

	private List<WebElement> getValueProductUsers() {
		List<WebElement> findElements = driver.findElements(By.xpath("//span[@class='ng-binding ng-scope']"));
		for (WebElement we : findElements) {
			System.out.println(we.toString());
		}
		return findElements;
	}

	/**
	 * Retrieve a List of WebElements to get the button
	 * 
	 * @return Return a List of webElements
	 */

	private List<WebElement> ListBtnAddUserToProduct() {
		List<WebElement> findElements = driver.findElements(addUserField);
		for (WebElement we : findElements) {
			System.out.println(we.toString());
		}
		return findElements;
	}

	/**
	 * Search First Name in the search field
	 * 
	 * @param strFirstName
	 */

	public void searchFirstName(String strFirstName) {
		driver.findElement(SearchFieldUser).sendKeys(strFirstName);
	}

	/**
	 * retreive the string of the list
	 * 
	 * @param index
	 * @return The String of the list to get the name
	 */

	public String getName(int index) {
		return getValueProductUsers().get(index).getText();
	}

	/**
	 * retrieve the Name of the product
	 * 
	 * @return The Name of the product
	 */

	public String getProductName() {
		return getName(PRODUCT_NAME);
	}

	/**
	 * Click to ADD TO THE PRODUCT to add
	 */

	public void addUser() {
		ListBtnAddUserToProduct().get(1).click();
	}
}
