package fr.techad.edc.pages.config.topologies;

import org.openqa.selenium.WebDriver;

import fr.techad.edc.pages.config.ConfigMenuComp;
import fr.techad.edc.pages.config.strategies.VersionComp;

public class TopologiesPage {
	private WebDriver driver;
	private ConfigMenuComp configMenu;
	private VersionComp versionStrat;
	private TopologyParametersComp topologyParameters;
	private TopologyStrategiesComp ToploStrat;

	public TopologiesPage(WebDriver webdriver) {
		this.driver = webdriver;
		this.configMenu = new ConfigMenuComp(driver);
		this.topologyParameters = new TopologyParametersComp(driver);
		this.ToploStrat = new TopologyStrategiesComp(driver);
	}

	/**
	 * Click on topologies of the menu
	 */
	public void clickOnTopologies() {
		configMenu.clickOnTopologies();
	}

	/**
	 * Select the version of the product before edit or create new topologies
	 * 
	 * @param strVersion
	 */
	public void selectVersion(String strVersion) {
		versionStrat.selectVersion(strVersion);
	}

	/**
	 * Set the parameters of the topology and create the topology
	 * 
	 * @param strShortName
	 * @param strCF
	 * @param strColor
	 * @param strIcon
	 * @param strLabel
	 * @return true or false if the topology has been created
	 */
	public boolean setTopologyParameters(String strShortName, String strCF, String strColor, String strIcon,
			String strLabel) {
		return topologyParameters.setTopologyParameters(strShortName, strCF, strColor, strIcon, strLabel);
	}

	/**
	 * add the strategy to the topology
	 * 
	 * @param strStrategy
	 * @return
	 * @throws InterruptedException
	 */
	public boolean addStrategy(String strStrategy) throws InterruptedException {
		return ToploStrat.addTopologyToStrategy(strStrategy);
	}

	/**
	 * return the name of the topology
	 * 
	 * @return
	 */
	public String getName() {
		return topologyParameters.getName();
	}
}
