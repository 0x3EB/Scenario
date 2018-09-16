package fr.techad.edc.steps.editor;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import fr.techad.edc.pages.editor.ConfigEditorMenuComp;
import fr.techad.edc.pages.editor.CreateBrickPage;
import fr.techad.edc.pages.editor.contributors.ArticlesTypesComp;
import fr.techad.edc.pages.editor.documentationTypes.ContextualisedUIHelpComp;
import fr.techad.edc.pages.editor.editorArea.ArticlesComp;
import fr.techad.edc.utils.WebDriverFactory;

public class ArticlesStepsDef {
	WebDriver driver = WebDriverFactory.getDriver();
	CreateBrickPage createBrick = new CreateBrickPage(driver);
	ArticlesTypesComp articlesTypes = new ArticlesTypesComp(driver);
	ConfigEditorMenuComp configEditor = new ConfigEditorMenuComp(driver);
	ContextualisedUIHelpComp context = new ContextualisedUIHelpComp(driver);
	ArticlesComp articles = new ArticlesComp(driver);

	@Then("add all contributors on the edit page")
	public void add_all_contributors_on_the_edit_page() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		TimeUnit.SECONDS.sleep(5);
		createBrick.selectArticlesTypes();
		check_doubles();
		check_order();
	}

	@Then("check doubles")
	public void check_doubles() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		TimeUnit.SECONDS.sleep(2);
		articles.editText();
		Assert.assertFalse(articlesTypes.doubleExist());
	}

	@Then("check order")
	public void check_order() {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}

	@Then("Go to articles of the brick \"([^\\\"]*)\"")
	public void go_to_parameters_of_the_brick(String strBrick) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		context.edit(strBrick);
		configEditor.clickOnArticles();
	}

	@Then("can not add articles")
	public void can_not_add_articles() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		Assert.assertFalse("CAN ADD ARTICLES", articlesTypes.clickOnArticleTypes());
	}

	@Then("can add articles")
	public void can_add_articles() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		Assert.assertTrue("CAN NOT ADD ARTICLES", articlesTypes.clickOnArticleTypes());
	}
	
	@Then("can not edit articles")
	public void can_not_edit_articles() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		Assert.assertFalse("CAN EDIT ARTICLES", articles.editText());
	}
	
	@Then("can edit articles")
	public void can_edit_articles() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		Assert.assertTrue("CAN NOT EDIT ARTICLES", articles.editText());
	}
}
