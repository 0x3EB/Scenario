package fr.techad.edc.pages.config.users;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;

import org.openqa.selenium.WebDriver;

import fr.techad.edc.pages.config.ConfigMenuComp;
import fr.techad.edc.utils.ServerService;

public class CreationContactPage {
	WebDriver driver;
	UsersParametersComp userParameters;
	ConfigMenuComp configMenu;
	UsersComp user;
	ServerService server = new ServerService();

	public CreationContactPage(WebDriver driver) {
		this.driver = driver;
		this.userParameters = new UsersParametersComp(driver);
		this.configMenu = new ConfigMenuComp(driver);
		this.user = new UsersComp(driver);
	}

	/**
	 * Click on the User management
	 */
	public void clickOnUserManagement() {
		configMenu.clickOnUserManagement();
	}

	/**
	 * Fill all the field in the user Parameters
	 * 
	 * @param strEmail
	 * @param strFirstName
	 * @param strLastName
	 * @param strUsername
	 */

	public void fillContact(String strEmail, String strFirstName, String strLastName, String strUsername) {
		userParameters.setEmail(strEmail).setFirstName(strFirstName).setLastName(strLastName).setUsername(strUsername);
	}

	/**
	 * click to create a user
	 * 
	 * @throws InterruptedException
	 * @throws MessagingException
	 * @throws IOException
	 */

	public void CreateUser() throws InterruptedException, MessagingException, IOException {
		server.setMode("local");
		server.setServer();
		System.out.println(server.getWiser().getServer().getPort()+" "+server.getWiser().getServer().getHostName()+" "+server.getWiser().getServer().isRunning());
		userParameters.clickOnCreate();
		TimeUnit.SECONDS.sleep(5);
		System.out.println(server.getLocalMessage());
	}

	/**
	 * Verify the content of the field in
	 * 
	 * the User Parameters Area
	 * 
	 * @param strUser
	 * @param strEmail
	 * @param strLastName
	 * @param strFirstName
	 */
	public void VerifyUser(String strUser, String strEmail, String strLastName, String strFirstName) {
		System.out.println(driver);
		user.VerifyUser(strUser, strEmail, strLastName, strFirstName);
	}

}
