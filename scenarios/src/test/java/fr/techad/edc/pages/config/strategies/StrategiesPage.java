package fr.techad.edc.pages.config.strategies;

import org.openqa.selenium.WebDriver;

import fr.techad.edc.pages.config.ConfigMenuComp;

public class StrategiesPage {
	private WebDriver driver;
	private ConfigMenuComp configMenu;
	private VersionComp versionStrat;
	private StrategiesParametersComp strategiesParameters;
	private StrategyTopologiesComp strategyTopo;

	public StrategiesPage(WebDriver webdriver) {
		this.driver = webdriver;
		this.configMenu = new ConfigMenuComp(driver);
		this.versionStrat = new VersionComp(driver);
		this.strategiesParameters = new StrategiesParametersComp(driver);
		this.strategyTopo = new StrategyTopologiesComp(driver);
	}

	/**
	 * Click on topologies of the menu
	 */
	public void clickOnStrategies() {
		configMenu.clickOnStrategies();
	}

	/**
	 * Select the version of the product before edit or create new strategies
	 * 
	 * @param strVersion
	 */
	public void selectVersion(String strVersion) {
		versionStrat.selectVersion(strVersion);
	}

	/**
	 * Set the parameters of the topology and create the strategy
	 * 
	 * @param strShortName
	 * @param strCF
	 * @param strColor
	 * @param strIcon
	 * @param strLabel
	 * @return true or false if the topology has been created
	 */
	public boolean setStrategyParameters(String strShortName, String strCF, String strColor, String strIcon,
			String strLabel) {
		return strategiesParameters.setStrategyParameters(strShortName, strCF, strColor, strIcon, strLabel);
	}

	/**
	 * add the topology to the strategy
	 * 
	 * @param strTopologyName
	 * @param strStrategyName
	 * @return
	 * @throws InterruptedException
	 */
	public boolean addTopologyToStrategy(String strTopologyName, String strStrategyName) throws InterruptedException {
		return strategyTopo.addTopologyToStrategy(strTopologyName, strStrategyName);
	}

	/**
	 * return the name of the strategy
	 * 
	 * @return
	 */
	public String getName() {
		return strategiesParameters.getName();
	}

}