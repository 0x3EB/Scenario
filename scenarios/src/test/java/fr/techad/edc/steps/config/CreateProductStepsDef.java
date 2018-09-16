package fr.techad.edc.steps.config;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.techad.edc.pages.config.AccesConfigMenuComp;
import fr.techad.edc.pages.config.products.CreationProductPage;
import fr.techad.edc.utils.WebDriverFactory;

public class CreateProductStepsDef {

	CreationProductPage createProduct = new CreationProductPage(WebDriverFactory.getDriver());
	AccesConfigMenuComp configMenu = new AccesConfigMenuComp(WebDriverFactory.getDriver());

	@When("I click on Product management")
	public void i_click_on_Product_management() {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		createProduct.clickOnProductManagement();
	}

	@When("I enter the name \"([^\\\"]*)\" and version name \"([^\\\"]*)\" and the title \"([^\\\"]*)\" and the vendor \"([^\\\"]*)\" and the ProductType \"([^\\\"]*)\"")
	public void i_enter_the_name_and_version_name_and_the_title_and_the_vendor_and_the_ProductType(String strName,
			String strVersion, String strTitle, String strVendor, String strProductType) {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		createProduct.fillProductParameters(strName, strVersion, strTitle, strVendor, strProductType);
	}

	@When("I Click on create Product")
	public void i_Click_on_create_Product() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		TimeUnit.SECONDS.sleep(5);
		createProduct.createProduct();
		// CreateProduct.ClickCheckBox();
	}

	@When("I add the user \"([^\\\"]*)\" to the product \"([^\\\"]*)\" and verify")
	public void i_add_the_user_to_the_product(String strUser, String strProduct) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		createProduct.addUserToProduct(strProduct, strUser);
	}

	@Then("^i can not click on the config menu$")
	public void iCanNotClickOnTheConfigMenu() throws Throwable {
		Assert.assertFalse("CAN GO TO THE EDITOR MENU", configMenu.clickOnConfig());
		Assert.assertFalse("CAN GO TO THE EDITOR MENU", configMenu.isConfigPage());
	}

	@Then("^i can click on the config menu$")
	public void iCanClickOnTheConfigMenu() throws Throwable {
		Assert.assertTrue("CAN GO TO THE EDITOR MENU", configMenu.clickOnConfig());
		Assert.assertTrue("CAN GO TO THE EDITOR MENU", configMenu.isConfigPage());
	}

}