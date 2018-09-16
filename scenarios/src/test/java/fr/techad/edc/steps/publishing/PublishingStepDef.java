package fr.techad.edc.steps.publishing;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.techad.edc.pages.publishing.PublishingComp;
import fr.techad.edc.utils.WebDriverFactory;

public class PublishingStepDef {

	PublishingComp publish = new PublishingComp(WebDriverFactory.getDriver());

	@Then("^I go to publishing and select the product \"([^\"]*)\" and the version \"([^\"]*)\"$")
	public void iGoToPublishingAndSelectTheProductAndTheVersion(String strProduct, String strVersion) throws Throwable {
		Assert.assertTrue("CAN NOT CLICK ON PUBLISHING", publish.clickOnPublishing());
		Assert.assertTrue("CAN NOT SELECET THE VERSION OR/AND THE PRODUCT",
				publish.selectVersionProduct(strProduct, strVersion));
	}

	@Then("^Create a web html Package$")
	public void createAWebHtmlPackage() throws Throwable {
		publish.createHTMLPackage();
	}

	@Then("^Select all the status$")
	public void selectAllTheStatus() throws Throwable {
		Assert.assertTrue("CAN NOT SELECT ALL THE STATUS", publish.selectAllStatus());
	}

	@And("^Publish$")
	public void publish() throws Throwable {
		publish.clickNextOrPublish();
	}

	@When("^i download the Zip$")
	public void iDownloadTheZip() throws Throwable {
		Assert.assertTrue("CAN NOT CLICK ON DOWNLOAD", publish.clickOnDownload());
	}

	@And("^check if the Zip has been download$")
	public void checkIfTheZipHasBeenDownload() throws Throwable {
		Assert.assertTrue("THE FILE HAS NOT BEEN DOWNLOAD", publish.verifyDownloadedZIP());
	}

	@Then("^I can not go to publishing$")
	public void iCanNotGoToPublishing() throws Throwable {
		Assert.assertFalse("CAN NOT CLICK ON PUBLISHING", publish.clickOnPublishing());
	}

}
