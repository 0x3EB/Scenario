package fr.techad.edc.pages.config.topologies;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TopologyParametersComp {
	private WebDriver driver;
	private By ShortNameTextField = By.name("shortName"); // FIND NAME FIELD
	private By colorTextField = By.name("color");// FIND COLOR FIELD
	private By iconTextField = By.name("iconCss");// FIND ICON STRATEGY FIELD
	private By descTextField = By.xpath("//textarea[@class='form-control ng-untouched ng-pristine ng-invalid']");
	private String strName;
	public TopologyParametersComp(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Set the name in the text field in the Topology Parameter component
	 * 
	 * @param strShortName
	 * @return
	 */
	public TopologyParametersComp setName(String strShortName) {
		this.strName = strShortName;
		driver.findElement(ShortNameTextField).sendKeys(strShortName);
		return this;
	}

	public String getName() {
		return strName; 
	}
	/**
	 * set the Content format of the Topology in the Topology Parameter component
	 * 
	 * @param strCF
	 * @return
	 */
	public TopologyParametersComp setContentFormat(String strCF) {
		Select structureSelect = new Select(driver
				.findElement(By.xpath("//select[@class='form-control placeholder ng-untouched ng-pristine ng-invalid']"))); 
		structureSelect.selectByVisibleText(strCF);
		return this;
	}

	/**
	 * set the color of the Topology in the Topology Parameter component
	 * 
	 * @param strColor
	 * @return
	 */
	public TopologyParametersComp setColor(String strColor) {
		driver.findElement(colorTextField).sendKeys(strColor);
		return this;
	}

	/**
	 * set the icon of the Topology in the Topology Parameter component
	 * 
	 * @param strIcon
	 * @return
	 */
	public TopologyParametersComp setIcon(String strIcon) {
		driver.findElement(iconTextField).sendKeys(strIcon);
		return this;
	}

	/**
	 * set the description in the Topology Parameter component
	 * 
	 * @param strLabel
	 * @return
	 */
	public TopologyParametersComp setPublishedLabel(String strLabel) {
		driver.findElement(descTextField).sendKeys(strLabel);
		return this;
	}

	/**
	 * Click on create to create the strategy
	 * 
	 * @return
	 */
	public TopologyParametersComp clickOnCreate() {
		driver.findElement(By.xpath("//button[@class='btn btn-primary pull-right']")).click();
		return this;
	}

	/**
	 * set all the parameters of the strategy Parameter component
	 * 
	 * @param strShortName
	 * @param strCF
	 * @param strColor
	 * @param strIcon
	 * @param strLabel
	 * @return True or False is the topology has been created
	 */
	public boolean setTopologyParameters(String strShortName, String strCF, String strColor, String strIcon,
			String strLabel) {
		try {
			setName(strShortName).setContentFormat(strCF).setColor(strColor).setIcon(strIcon)
					.setPublishedLabel(strLabel).clickOnCreate();
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
}
