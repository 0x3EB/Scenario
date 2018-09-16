package fr.techad.edc.steps.config;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import fr.techad.edc.pages.MainMenu;
import fr.techad.edc.pages.config.topologies.TopologiesPage;
import fr.techad.edc.pages.editor.documentationTypes.DocumentationTypesMenuComp;
import fr.techad.edc.utils.WebDriverFactory;

public class CreateTopologyStepsDef {

	TopologiesPage topology = new TopologiesPage(WebDriverFactory.getDriver());
	MainMenu mainMenu = new MainMenu(WebDriverFactory.getDriver());
	DocumentationTypesMenuComp documentationTypes = new DocumentationTypesMenuComp(WebDriverFactory.getDriver());

	@Then("^I click on Topologies$")
	public void iClickOnTopologies() throws Throwable {
		topology.clickOnTopologies();
	}

	@Then("^create the Topology with name \"([^\"]*)\" the structure \"([^\"]*)\" the color \"([^\"]*)\" the icon \"([^\"]*)\" and the description \"([^\"]*)\"$")
	public void createTheTopologyWithNameTheStructureTheColorTheIconAndTheDescription(String strName,
			String strStructure, String strColor, String strIcon, String strDesc) throws Throwable {
		Assert.assertTrue(topology.setTopologyParameters(strName, strStructure, strColor, strIcon, strDesc));
	}

	@And("^add the strategy \"([^\"]*)\"$")
	public void addTheStrategy(String strStrategy) throws Throwable {
		Assert.assertTrue(topology.addStrategy(strStrategy));
	}

	@Then("^i click on documentation$")
	public void iclickOnDocumnentation() throws Throwable {
		mainMenu.clickOnDocumentation();
	}
	
}
