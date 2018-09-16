package fr.techad.edc.pages.config.products;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductParametersComp {
	private WebDriver driver;

	By nameTextField = By.name("name"); // FIND NAME FIELD
	By versionTextField = By.name("version");// FIND VERSION NAME FIELD
	By titleTextField = By.name("title");// FIND DOCUMENTATION TITLE FIELD
	By vendorTextField = By.name("vendor");// FIND VENDOR FIELD
	By selectorProductType = By.xpath("//span[@class='ui-select-match-text pull-left']");// FIND PRODUCT TYPE DROP-DOWN
	By productTypeTextField = By.xpath("//input[@type='search']");// FIND PRODUCT TYPE FIELD
	By btnCreateProduct = By.xpath("//button[@class='btn btn-primary pull-right ng-binding']");// FIND THE BUTTON TO CREATE A PRODUT

	public ProductParametersComp(WebDriver webdriver) {
		this.driver = webdriver;
	}
	
	/**
	 * Retreive the button SAVE CHANGES and CREATE A PRODUCT in a list
	 * @return Return the List of WebElements (Buttons)
	 */
	
	public List<WebElement> getButtonCreateAndSave() {
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='footer']"));
		for (WebElement we : findElements) {
			System.out.println(we.toString());
		}
		return findElements;
	}
	
	/**
	 * fill the name to the field Name
	 * @param strName
	 * @return 
	 */
	public ProductParametersComp setName(String strName) {
		driver.findElement(nameTextField).sendKeys(strName);
		return this;
	}

	/**
	 * fill the Version to the field Version Name
	 * @param strVersion
	 * @return 
	 */
	public ProductParametersComp setVersion(String strVersion) {
		driver.findElement(versionTextField).sendKeys(strVersion);
		return this;
	}

	/**
	 * fill the title to the field Documentation title
	 * @param strTitle
	 * @return 
	 */
	public ProductParametersComp setDocTitle(String strTitle) {
		driver.findElement(titleTextField).sendKeys(strTitle);
		return this;
	}

	/**
	 * fill the vendor to the field vendor
	 * @param strVendor
	 * @return 
	 */
	public ProductParametersComp setVendor(String strVendor) {
		driver.findElement(vendorTextField).sendKeys(strVendor);
		return this;
	}
	
	/**
	 * choose the product type
	 * @param strType
	 * @return 
	 */

	public ProductParametersComp setProductType(String strType) {
		driver.findElement(selectorProductType).click();
		driver.findElement(productTypeTextField).sendKeys(strType);
		return this;
	}
	
	/**
	 * Create a product
	 */
	
	public void ClickCreate() {
		driver.findElement(btnCreateProduct).click();
	}
}
