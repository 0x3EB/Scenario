package fr.techad.edc.steps.editor;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import fr.techad.edc.pages.editor.ConfigEditorMenuComp;
import fr.techad.edc.pages.editor.CreateBrickPage;
import fr.techad.edc.pages.editor.documentationTypes.ContextualisedUIHelpComp;
import fr.techad.edc.utils.WebDriverFactory;

public class ImgTestStepsDef {
	WebDriver driver = WebDriverFactory.getDriver();
	CreateBrickPage createBrick = new CreateBrickPage(driver);
	ContextualisedUIHelpComp context = new ContextualisedUIHelpComp(driver);
	ConfigEditorMenuComp configEditor = new ConfigEditorMenuComp(driver);

	@Then("replace by a photo with the path \"([^\\\"]*)\"")
	public void replace_by_a_photo_with_the_path(String strPath) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		createBrick.replaceImg(strPath);
	}

	@Then("delete it")
	public void delete_it() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		createBrick.deleteImg();
	}

	@Then("add a photo with the path \"([^\\\"]*)\"")
	public void add_a_photo_with_the_path(String strPath) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		createBrick.setImage(strPath);
	}

	@Then("Generic Test IMG with the path \"([^\\\"]*)\" and replace by \"([^\\\"]*)\"")
	public void generic_img_test(String strPath, String strPathReplace) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		add_a_photo_with_the_path(strPath);
		replace_by_a_photo_with_the_path(strPathReplace);
		delete_it();
	}

	@Then("Edit the brick \"([^\\\"]*)\"")
	public void edit_the_brick(String strBrick) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		context.edit(strBrick);
	}

	@Then("Go to parameters of the brick \"([^\\\"]*)\"")
	public void go_to_parameters_of_the_brick(String strBrick) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		edit_the_brick(strBrick);
		configEditor.clickOnParameters();
	}
	
	@Then("Go to Articles of the brick \"([^\\\"]*)\"")
	public void go_to_articles_of_the_brick(String strBrick) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		edit_the_brick(strBrick);
		configEditor.clickOnArticles();
	}
	
	
	@Then("Go to Comments of the brick \"([^\\\"]*)\"")
	public void go_to_comments_of_the_brick(String strBrick) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		edit_the_brick(strBrick);
		configEditor.clickOnComments();
	}

	@Then("can not replace by a photo with the path \"([^\\\"]*)\"")
	public void can_not_replace_by_a_photo_with_the_path(String strPath) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		Assert.assertFalse("CAN'T REPLACE A PHOTO", createBrick.replaceImg(strPath));
	}

	@Then("can not delete it")
	public void can_not_delete_it() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		Assert.assertFalse("CAN'T REMOVE A PHOTO", createBrick.deleteImg());
	}

	@Then("can not add a photo with the path \"([^\\\"]*)\"")
	public void can_not_add_a_photo_with_the_path(String strPath) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		Assert.assertFalse("CAN'T ADD A PHOTO", createBrick.setImage(strPath));
	}
	
	@Then("can replace by a photo with the path \"([^\\\"]*)\"")
	public void can_replace_by_a_photo_with_the_path(String strPath) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		Assert.assertTrue("CAN'T REPLACE A PHOTO", createBrick.replaceImg(strPath));
	}

	@Then("can delete it")
	public void can_delete_it() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		Assert.assertTrue("CAN'T REMOVE A PHOTO", createBrick.deleteImg());
	}

	@Then("can add a photo with the path \"([^\\\"]*)\"")
	public void can_add_a_photo_with_the_path(String strPath) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		Assert.assertTrue("CAN'T ADD A PHOTO", createBrick.setImage(strPath));
	}

}
