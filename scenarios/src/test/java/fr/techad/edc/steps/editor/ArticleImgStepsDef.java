package fr.techad.edc.steps.editor;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import fr.techad.edc.pages.editor.contributors.ImagesComp;
import fr.techad.edc.utils.ServerService;
import fr.techad.edc.utils.WebDriverFactory;

public class ArticleImgStepsDef {
	ImagesComp img = new ImagesComp(WebDriverFactory.getDriver());
	ServerService server = new ServerService();

	@Then("can not go to Images")
	public void can_not_go_to_images() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertFalse("CAN GO TO IMAGES", img.clickOnImages());
	}

	@Then("I can go to Images")
	public void i_can_go_to_images() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue("CAN NOT GO TO IMAGES", img.clickOnImages());
	}

	@Then("I upload an img with the path \"([^\\\"]*)\"")
	public void i_upload_an_img_with_the_path(String strPath) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue("CAN NOT UPLOAD IMAGE(S)", img.uploadImg(strPath));
	}

	@Then("add it to the content of the articles")
	public void add_it_to_the_content_of_the_articles() throws InterruptedException, AWTException {
		// Write code here that turns the phrase above into concrete actions
		TimeUnit.SECONDS.sleep(2);
		//Assert.assertTrue("CAN NOT ADD IMAGES TO THE EDIT AREA", img.addImgToTextarea());
		img.addImgToTextarea();
	}

	@Then("I replace by an img with the path \"([^\\\"]*)\"")
	public void i_replace_by_an_img_with_the_path(String strPath) throws InterruptedException, IOException {
		// Write code here that turns the phrase above into concrete actions
		TimeUnit.SECONDS.sleep(5);
		Assert.assertTrue("CAN NOT REPLACE IMAGE", img.replaceImg(strPath));
	}

	@Then("I delete it")
	public void i_delete_it() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		TimeUnit.SECONDS.sleep(5);
		Assert.assertTrue("CAN NOT DELETE IMAGE", img.deleteImg());
	}

	@And("^I can not go to Images$")
	public void iCanNotGoToImages() throws Throwable {
		Assert.assertFalse("CAN GO TO IMAGES", img.clickOnImages());
	}
}
