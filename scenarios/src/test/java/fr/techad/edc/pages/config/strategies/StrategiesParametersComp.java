package fr.techad.edc.pages.config.strategies;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class StrategiesParametersComp {

	private WebDriver driver;
	private By nameTextField = By.name("name"); // FIND NAME FIELD
	private By colorTextField = By.name("color");// FIND COLOR FIELD
	private By iconTextField = By.name("iconCss");// FIND ICON STRATEGY FIELD
	private By descTextField = By.xpath("//*[@id=\"NG2_UPGRADE_9_0\"]/div/edc-strategy-edit/edc-strategy-parameters/div/div[2]/edc-strategy-parameters-form/div/div[5]/textarea");// FIND DESCRITPION FIELD
	private String NameStrategy;
	public StrategiesParametersComp(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Set the name in the text field in the Strategy Parameter component
	 * 
	 * @param strName
	 * @return
	 */
	public StrategiesParametersComp setName(String strName) {
		driver.findElement(nameTextField).sendKeys(strName);
		this.NameStrategy = strName;
		return this;
	}
	
	public String getName() {
		return this.NameStrategy;
	}

	/**
	 * set the structure type of the strategy in the Strategy Parameter component
	 * 
	 * @param strStructure
	 * @return
	 */
	public StrategiesParametersComp setStructure(String strStructure) {
		Select structureSelect = new Select(driver
				.findElement(By.xpath("//select[@class='form-control placeholder ng-untouched ng-pristine ng-invalid']"))); 
		structureSelect.selectByVisibleText(strStructure);
		return this;
	}

	/**
	 * set the color of the strategy in the Strategy Parameter component
	 * 
	 * @param strColorHexa
	 * @return
	 */
	public StrategiesParametersComp setColor(String strColorHexa) {
		driver.findElement(colorTextField).sendKeys(strColorHexa);
		return this;
	}

	/**
	 * set the icon of the strategy in the Strategy Parameter component
	 * 
	 * @param strIcon
	 * @return
	 */
	public StrategiesParametersComp setIcon(String strIcon) {
		driver.findElement(iconTextField).sendKeys(strIcon);
		return this;
	}

	/**
	 * set the description in the Strategy Parameter component
	 * 
	 * @param strDesc
	 * @return
	 */
	public StrategiesParametersComp setDescription(String strDesc) {
		driver.findElement(descTextField).sendKeys(strDesc);
		return this;
	}

	/**
	 * Click on create to create the strategy
	 * 
	 * @return
	 */
	public StrategiesParametersComp clickOnCreate() {
		driver.findElement(By.xpath("//button[@class='btn btn-primary pull-right']")).click();
		return this;
	}

	/**
	 * set all the parameters of the Strategy Parameter component
	 * 
	 * @param strName
	 * @param strStructure
	 * @param strColorHexa
	 * @param strIcon
	 * @param strDesc
	 * @return True or False if the strategy has been created
	 */
	public boolean setStrategyParameters(String strName, String strStructure, String strColorHexa, String strIcon,
			String strDesc) {
		try {
			setName(strName).setStructure(strStructure).setColor(strColorHexa).setIcon(strIcon).setDescription(strDesc)
					.clickOnCreate();
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
}
