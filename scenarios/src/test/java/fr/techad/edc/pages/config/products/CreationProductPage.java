package fr.techad.edc.pages.config.products;

import org.openqa.selenium.WebDriver;

import fr.techad.edc.pages.config.ConfigMenuComp;
import fr.techad.edc.pages.config.users.CreationContactPage;

public class CreationProductPage {

	WebDriver driver;
	CreationContactPage contact;
	ConfigMenuComp configMenu;
	ProductParametersComp productParameters;
	ProductsComp product;

	public CreationProductPage(WebDriver driver) {
		this.driver = driver;
		this.contact = new CreationContactPage(driver);
		this.configMenu = new ConfigMenuComp(driver);
		this.productParameters = new ProductParametersComp(driver);
		this.product = new ProductsComp(driver);
	}

	/**
	 * Click on the menu Product Management
	 */
	public void clickOnProductManagement() {
		configMenu.clickOnProductManagement();
	}

	/**
	 * fill the field of the Product parameters
	 * 
	 * @param strName
	 * @param strVersion
	 * @param strTitle
	 * @param strVendor
	 * @param strType
	 */
	public void fillProductParameters(String strName, String strVersion, String strTitle, String strVendor,
			String strType) {
		productParameters.setName(strName).setVersion(strVersion).setDocTitle(strTitle).setVendor(strVendor)
				.setProductType(strType);
	}

	/**
	 * Click on crate the product
	 */

	public void createProduct() {
		productParameters.ClickCreate();
	}

	/**
	 * Add the user to the product and verify
	 * 
	 * @param strProduct
	 * @param strUser
	 * @throws InterruptedException 
	 */

	public void addUserToProduct(String strProduct, String strUser) throws InterruptedException {
		product.addUsertoProduct(strProduct, strUser);
	}
}