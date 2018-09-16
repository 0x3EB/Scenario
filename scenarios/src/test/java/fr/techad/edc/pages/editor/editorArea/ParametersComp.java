package fr.techad.edc.pages.editor.editorArea;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.Select;

import fr.techad.edc.pages.editor.BrickInfos;
import fr.techad.edc.utils.DragNDropImg;

public class ParametersComp {

	private WebDriver driver;
	DragNDropImg img;
	By titlefield = By.name("title");
	By subKeyfield = By.name("subKey");
	By mainKeyfield = By.name("mainKey");
	By desciptionField = By.xpath("//textarea[@class='ng-pristine ng-untouched ng-valid ng-empty']");
	By DropZone = By.xpath("//div[@class='dz-default dz-message']");
	BrickInfos data = new BrickInfos();

	public ParametersComp(WebDriver driver) {
		this.driver = driver;
		this.img = new DragNDropImg(driver);
	}

	/**
	 * Set the title of the Brick
	 * 
	 * @param strTitle
	 */
	public ParametersComp setTitle(String strTitle) {
		driver.findElement(titlefield).sendKeys(strTitle);
		return this;
	}


	/**
	 * Set keys of the brick
	 * 
	 * @param strMainKey
	 * @param strSubKey
	 * @return
	 */
	public ParametersComp setBrickKeys(String strMainKey, String strSubKey) {
		driver.findElement(mainKeyfield).sendKeys(strMainKey);
		driver.findElement(subKeyfield).sendKeys(strSubKey);
		return this;
	}

	/**
	 * Set the description of the brick
	 * 
	 * @param strDescription
	 * @return
	 */
	public ParametersComp setDescription(String strDescription) {
		data.setDesc(strDescription);
		driver.findElement(desciptionField).sendKeys(strDescription);
		return this;
	}


	/**
	 * Test if the parameters are editable
	 * 
	 * @param strMainKey
	 * @param strSubKey
	 * @param strDescription
	 * @return true or false if values are editable
	 */
	public boolean editBrick(String strMainKey, String strSubKey, String strDescription) {
		try {
			setBrickKeys(strMainKey, strSubKey).setDescription(strDescription);
			return true;
		} catch (WebDriverException ex) {
			return false;
		}
	}

	/**
	 * Choose the Brick type
	 * 
	 * @param strType
	 * @return
	 */

	public ParametersComp setBrickType(String strType) {
		Select brickType = new Select(driver.findElement(By.xpath(
				"//select[@class='form-control ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required edc-placeholder']")));
		brickType.selectByVisibleText(strType);
		return this;
	}

	/**
	 * Delete IMG uploaded
	 * 
	 * @throws InterruptedException
	 */
	public void removeImg() throws InterruptedException {
		driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-remove']")).click();
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

	}

	/**
	 * Exchange the IMG uploaded
	 * 
	 * @param strPath
	 * @throws InterruptedException
	 */
	public void exchangeImg(String strPath) throws InterruptedException {
		img.DropFile(new File(strPath), 0, 0, DropZone);
		TimeUnit.SECONDS.sleep(1);
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
	}

	/**
	 * Click on create to create the brick
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnCreate() throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.xpath("//button[@class='flex-button btn btn-primary btn-s ng-binding']")).click();
		TimeUnit.SECONDS.sleep(5);
	}

}
