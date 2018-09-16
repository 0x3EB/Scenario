package fr.techad.edc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import fr.techad.edc.utils.Configuration;

public class LoginPage {
	private WebDriver driver;
	private Configuration configuration;

	public LoginPage(WebDriver driver, Configuration configuration) {
		this.driver = driver;
		this.configuration = configuration;
	}

	By usernameTextField = By.name("username");
	By passwordTextField = By.name("password");

	/**
	 * Set the username of the login page
	 * 
	 * @param strUsername
	 * @return Return an LoginPage object
	 */
	public LoginPage setUsername(String strUsername) {
		driver.findElement(usernameTextField).sendKeys(strUsername);
		return this;
	}

	/**
	 * Set the password of the login page
	 * 
	 * @param strPassword
	 * @return Return an LoginPage oject
	 */
	public LoginPage setPassword(String strPassword) {
		driver.findElement(passwordTextField).sendKeys(strPassword);
		return this;
	}

	/**
	 * Click on login
	 */
	public void clickLogin() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	/**
	 * Check if the page is still the login page
	 * 
	 * @return Return true or false if the login page is the current url
	 */
	public boolean isLoginPage() {
		String currentPage = driver.getCurrentUrl();
		return currentPage.equals(this.configuration.getUrl() + "/login");
	}
}
