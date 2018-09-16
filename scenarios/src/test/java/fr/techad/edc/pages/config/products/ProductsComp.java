package fr.techad.edc.pages.config.products;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fr.techad.edc.pages.config.ConfigMenuComp;

public class ProductsComp {
	private WebDriver driver;

	ConfigMenuComp configMenu;
	ProductUsersComp productUsers;

	By btnDelProduct = By.xpath("//button[@class='btn btn-label']");// BUTTON DELETE
	By searchField = By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-valid ng-empty']");// SEARCH
																											// AREA
	By btnCopyProduct = By.xpath("//button[@class='btn btn-primary']");// BUTTON COPY PRODUCT
	By btnAddUser = By.xpath("/html/body/ui-view/edc-app/div/ui-view/edc-configuration/div[2]/div[2]/ui-view/edc-products/div/edc-products-edit/edc-product-users/div/div[2]/div[3]/div[2]/button");// BUTTON ADD USER
	By addUserField = By.xpath("//div[@class='ui-select-match ng-scope']");
	By addUserSendKeys = By
			.xpath("//input[@class='form-control ui-select-search ng-pristine ng-valid ng-empty ng-touched']");

	public ProductsComp(WebDriver webdriver) {
		this.driver = webdriver;
		this.configMenu = new ConfigMenuComp(driver);
		this.productUsers = new ProductUsersComp(driver);
	}

	/**
	 * Retrieve all the squarres of products to Tick or not
	 * 
	 * @return Return a list of WebElements
	 */

	private List<WebElement> getProducts() {
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='ng-scope']"));
		for (WebElement we : findElements) {
			System.out.println(we.toString());
		}
		return findElements;
	}

	/**
	 * Retrieve the status of all the products
	 * 
	 * @return Return the status
	 */

	private List<WebElement> getProductStatus() {
		List<WebElement> findElements = driver.findElements(By.xpath("//i[@class='fa ng-scope fa-check active-icon']"));
		for (WebElement we : findElements) {
			System.out.println(we.toString());
		}
		return findElements;
	}

	/**
	 * Retrieve All the rows from Products and productUsers
	 * 
	 * @return return the rows
	 */

	private List<WebElement> getLineOfProductsAndProductUsers() {
		List<WebElement> findElements = driver.findElements(By.xpath("//td[@class='ng-scope']"));
		for (WebElement we : findElements) {
			System.out.println(we.toString());
		}
		return findElements;
	}

	/**
	 * 
	 * @return
	 */

	private List<WebElement> getSearchFieldOfProductAndProductUsers() {
		List<WebElement> findElements = driver
				.findElements(By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-valid ng-empty']"));
		for (WebElement we : findElements) {
			System.out.println(we.toString());
		}
		return findElements;
	}

	/**
	 * Check if it is check or not
	 * 
	 * @return Return true or false
	 */

	private boolean isCheck() {
		return !(getProductStatus().get(0).equals(null));
	}

	/**
	 * Search into the search field a String
	 * 
	 * @param strSearch
	 */

	private void search(String strSearch) {
		driver.findElement(searchField).sendKeys(strSearch);
	}

	/**
	 * Tick all the products and del them all
	 */

	public void delAllProducts() {
		selectAllProducts();
		isCheck();
		driver.findElement(btnDelProduct).click();
	}

	/**
	 * add a User to the product and verify if it has been correctly added
	 * 
	 * @param strProduct
	 * @param strUser
	 * @throws InterruptedException 
	 */

	public void addUsertoProduct(String strProduct, String strUser) throws InterruptedException {

		search(strProduct);
		getLineOfProductsAndProductUsers().get(1).click();
		productUsers.addUser();

		/**
		 * List<WebElement> findElements =
		 * driver.findElements(By.xpath("//span[@class='ng-binding ng-scope']")); for
		 * (WebElement we : findElements) { if (we.getText().equals(strUser)) {
		 * System.out.println(we.getText()); we.click(); }
		 *  }
		 **/

		// driver.findElement(By.xpath("/html/body/ui-view/edc-app/div/ui-view/edc-configuration/div[2]/div[2]/ui-view/edc-products/div/edc-products-edit/edc-product-users/div/div[2]/div[3]/div[1]/div/div[1]")).click();
		driver.findElement(By.xpath(
				"/html/body/ui-view/edc-app/div/ui-view/edc-configuration/div[2]/div[2]/ui-view/edc-products/div/edc-products-edit/edc-product-users/div/div[2]/div[3]/div[1]/div/input[1]"))
				.sendKeys(strUser);
		driver.findElement(By.xpath(
				"/html/body/ui-view/edc-app/div/ui-view/edc-configuration/div[2]/div[2]/ui-view/edc-products/div/edc-products-edit/edc-product-users/div/div[2]/div[3]/div[1]/div/input[1]"))
				.sendKeys(Keys.RETURN);
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(btnAddUser).click();
		verifyUserAdd(strUser, strProduct);
	}

	/**
	 * Verify if the user added is stored into the rigth place
	 * 
	 * @param strUser
	 * @param strProduct
	 */

	private void verifyUserAdd(String strUser, String strProduct) {
		String[] strFirstName = strUser.split(" ");// SPLIT THE FIRST NAME TO THE NAME
		configMenu.clickOnUserManagement();
		productUsers.searchFirstName(strFirstName[0]);
		getLineOfProductsAndProductUsers().get(1).click();
		getSearchFieldOfProductAndProductUsers().get(1).sendKeys(strProduct);
		if (productUsers.getProductName().equals(strProduct))
			System.out.println("add!");
		else
			System.out.println("Smthing goes wrong");
	}

	/**
	 * Copy all the products permit to the Tick bar section
	 */

	public void copyAllProducts() {
		getProducts();
		isCheck();
		driver.findElement(btnCopyProduct).click();
	}

	/**
	 * Select all the product permit to the little squarre
	 */

	private void selectAllProducts() {
		getProducts().get(0).click();
	}

}
