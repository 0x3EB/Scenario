package fr.techad.edc.steps.config;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.techad.edc.pages.MainMenu;
import fr.techad.edc.pages.config.strategies.StrategiesPage;
import fr.techad.edc.pages.editor.contributors.ArticlesTypesComp;
import fr.techad.edc.pages.editor.documentationTypes.DocumentationTypesMenuComp;
import fr.techad.edc.utils.WebDriverFactory;

public class CreateStrategy {

	StrategiesPage strategy = new StrategiesPage(WebDriverFactory.getDriver());
	DocumentationTypesMenuComp documentationTypes = new DocumentationTypesMenuComp(WebDriverFactory.getDriver());
	MainMenu mainMenu = new MainMenu(WebDriverFactory.getDriver());
	ArticlesTypesComp articleTypes = new ArticlesTypesComp(WebDriverFactory.getDriver());
	

	@Then("^I click on strategies$")
	public void iClickOnStrategies() throws Throwable {
		strategy.clickOnStrategies();
	}

	@And("^Select the version \"([^\"]*)\"$")
	public void selectTheVersion(String strVerion) throws Throwable {
		strategy.selectVersion(strVerion);
	}

	@Then("^create the strategy with name \"([^\"]*)\" the structure \"([^\"]*)\" the color \"([^\"]*)\" the icon \"([^\"]*)\" and the description \"([^\"]*)\"$")
	public void createTheStrategyWithNameTheStructureTheColorTheIconAndTheDescription(String arg1, String arg2,
			String arg3, String arg4, String arg5) throws Throwable {
		strategy.setStrategyParameters(arg1, arg2, arg3, arg4, arg5);
	}

	@And("^add the topology \"([^\"]*)\"$")
	public void addTheTopology(String arg1) throws Throwable {
		Assert.assertTrue(strategy.addTopologyToStrategy(arg1, ""));
	}

	@Then("^check if the strategy has been add to the documentation menu of \"([^\"]*)\" version \"([^\"]*)\"$")
	public void checkIfTheStrategyHasBeenAddToTheDocumentationMenuOfVersion(String arg1, String arg2) throws Throwable {
		mainMenu.clickOnDocumentation();
		System.out.println(strategy.getName());
		Assert.assertTrue(documentationTypes.checkDocumentationTypes(strategy.getName()));
	}


	@When("^i click on strategy just created$")
	public void iClickOnStrategyJustCreated() throws Throwable {
		documentationTypes.clickOnTESTSTRATEGY(strategy.getName());
	}

	@Then("^Check if i got the article types \"([^\"]*)\"$")
	public void checkIfIGotTheArticleTypes(String strArticles) throws Throwable {
		Assert.assertTrue(articleTypes.findArticleType(strArticles));
	}
}
