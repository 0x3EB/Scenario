package fr.techad.edc.pages.config.users;

import java.io.IOException;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class UsersParametersComp {
	private WebDriver driver;

	private static final int CREATE = 1;
	private static final int SAVE = 0;

	By emailTextField = By.name("email");// FIND THE FIELD E-MAIL
	By firstnameTextField = By.name("firstName");// FIND THE FIELD FIRST NAME
	By lastnameTextField = By.name("lastName");// FIND THE FIELD LAST NAME
	By username2TextField = By.name("username");// FIND THE FIELD USERNAME

	public UsersParametersComp(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Retrieve the BUTTON SAVE CHANGES AND CREATE USER BY INDEX
	 * 
	 * @return return a list of WebElements
	 */
	private List<WebElement> getButtonItems() {
		List<WebElement> findElements = driver.findElements(By.xpath("//button[@class='btn btn-primary ng-binding']"));
		return findElements;
	}

	/**
	 * Find the EmailField WebElement
	 * 
	 * @return return a WebElement
	 */

	private WebElement EmailField() {
		return driver.findElement(emailTextField);
	}

	/**
	 * Find the FirstNamField WebElement
	 * 
	 * @return return a webElement
	 */

	private WebElement firstNameField() {
		return driver.findElement(firstnameTextField);
	}

	/**
	 * Find the LastNameField WebElement
	 * 
	 * @return return a webElement
	 */

	private WebElement lastNameField() {
		return driver.findElement(lastnameTextField);
	}

	/**
	 * Find the UserNameField WebElement
	 * 
	 * @return return the a WebElement
	 */

	private WebElement usernameField() {
		return driver.findElement(username2TextField);
	}

	/**
	 * fill the email field
	 * 
	 * @param strEmail
	 * @return return UsersParameters Object
	 */

	public UsersParametersComp setEmail(String strEmail) {
		EmailField().sendKeys(strEmail);
		return this;
	}

	/**
	 * fill the First Name field
	 * 
	 * @param strFirstName
	 * @return return UsersParameters Object
	 */

	public UsersParametersComp setFirstName(String strFirstName) {
		firstNameField().sendKeys(strFirstName);
		return this;
	}

	/**
	 * fill the Last Name field
	 * 
	 * @param strLastName
	 * @return return UsersParameters Object
	 */

	public UsersParametersComp setLastName(String strLastName) {
		lastNameField().sendKeys(strLastName);
		return this;
	}

	/**
	 * fill the Username field
	 * 
	 * @param strUsername
	 * @return return UsersParameters Object
	 */

	public UsersParametersComp setUsername(String strUsername) {
		usernameField().sendKeys(strUsername);
		return this;
	}

	/**
	 * get the value of the email field
	 * 
	 * @return return a String of the value
	 */

	public String getEmail() {
		return EmailField().getAttribute("value");
	}

	/**
	 * get the value of the First Name field
	 * 
	 * @return return a String of the value
	 */
	public String getFirstName() {
		return firstNameField().getAttribute("value");
	}

	/**
	 * get the value of the Last Name Field
	 * 
	 * @return return a String of the value
	 */

	public String getLastName() {
		return lastNameField().getAttribute("value");
	}

	/**
	 * get the value of the Username Field
	 * 
	 * @return return a String of the value
	 */

	public String getUsername() {
		return usernameField().getAttribute("value");
	}

	/**
	 * Click on with an index
	 * 
	 * @param index
	 */

	private void clickOn(int index) {
		getButtonItems().get(index).click();
	}

	/**
	 * Click on create
	 * 
	 * @throws InterruptedException
	 * @throws MessagingException
	 * @throws IOException
	 */

	public void clickOnCreate() throws InterruptedException, MessagingException, IOException {
		clickOn(CREATE);
		TimeUnit.SECONDS.sleep(2);
	}

	/**
	 * Click on save
	 */

	public void clickOnSave() {
		clickOn(SAVE);
	}

}
