package fr.techad.edc.pages.config.users;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UsersComp {
	WebDriver driver;
	UsersParametersComp usersParameters;
	By SearchField = By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-valid ng-empty']");// find the
																											// search
																											// Area

	private static final int USER = 1;

	public UsersComp(WebDriver driver) {
		this.driver = driver;
		this.usersParameters = new UsersParametersComp(driver);
	}

	/**
	 * Retrieve all the rows from the tab of users
	 * 
	 * @return return a list of WebElement
	 */

	public List<WebElement> ListTabUsers() {
		List<WebElement> findElements = driver.findElements(By.xpath("//td[@class='ng-scope']"));
		for (WebElement we : findElements) {
			System.out.println(we.toString());
		}
		return findElements;
	}

	/**
	 * Retrieve all the
	 * 
	 * @return Return a list of webElement
	 */

	public List<WebElement> selectAllUsers() {
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='ng-scope']"));
		for (WebElement we : findElements) {
			System.out.println(we.toString());
		}
		return findElements;
	}

	/**
	 * Check if the value of the fields are the same as the value of the tab
	 * 
	 * @param strUser
	 * @param strEmail
	 * @param strLastName
	 * @param strFirstName
	 * @return return true or false if the value is the same
	 */

	private boolean verifyInformations(String strUser, String strEmail, String strLastName, String strFirstName) {
		return (usersParameters.getUsername().equals(strUser) && usersParameters.getEmail().equals(strEmail)
				&& usersParameters.getLastName().equals(strLastName)
				&& usersParameters.getFirstName().equals(strFirstName));
	}

	/**
	 * Check if the values of a certain user is the same in the field and the tab
	 * 
	 * @param strUser
	 * @param strEmail
	 * @param strLastName
	 * @param strFirstName
	 */

	public void VerifyUser(String strUser, String strEmail, String strLastName, String strFirstName) {
		searchUser(strUser);
		selectUser();
		System.out.println(verifyInformations(strUser, strEmail, strLastName, strFirstName));
	}

	/**
	 * Select in the tab a certain row
	 * 
	 * @param index
	 */

	private void selectInRows(int index) {
		ListTabUsers().get(index).click();
	}

	/**
	 * select in the tab a User
	 */

	private void selectUser() {
		selectInRows(USER);
	}

	/**
	 * Search method
	 * 
	 * @param strUser
	 */

	private void searchUser(String strUser) {
		driver.findElement(SearchField).sendKeys(strUser);
	}

}
