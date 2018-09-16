package fr.techad.edc.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

/*
 * Factory to instantiate a WebDriver object. It returns an instance of the driver (local invocation) or an instance of RemoteWebDriver
 */
public class WebDriverFactory {

	private static WebDriver driver;
	private static Configuration configuration = new Configuration();

	public WebDriverFactory() {
	}

	/**
	 * Reset the driver to Null
	 */
	public static void reset() {
		driver.close();
		driver = null;
	}

	/**
	 * Return the current configuration
	 * 
	 * @return
	 */
	public static Configuration getConfiguration() {
		return configuration;
	}

	/**
	 * If the driver is null then it will be CHROME or it will be the browser of the
	 * system
	 * 
	 * @return
	 */
	public static WebDriver getDriver() {
		if (driver != null)
			return driver;
		String browser = configuration.getBrowser();
		return getDriver(browser);
	}

	/**
	 * Setup the driver with the correct url
	 * 
	 * @param driver
	 */
	public static void setup(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(configuration.getUrl());
	}

	/**
	 * Create a driver with the browser in the parameter
	 * 
	 * @param browser
	 * @return
	 */
	public static WebDriver getDriver(String browser) {
		if (driver != null)
			return driver;
		else if (Browser.CHROME.equals(browser)) {
			setChromeDriver();
			driver = new ChromeDriver();
		} else if (Browser.FIREFOX.equals(browser)) {
			setFireFoxDriver();
			driver = new FirefoxDriver();
		} else if (Browser.INTERNET_EXPLORER.equals(browser)) {
			isSupportedPlatform(browser);
			setIeDriver();
			driver = new InternetExplorerDriver();
		} else if (Browser.SAFARI.equals(browser)) {
			isSupportedPlatform(browser);
			driver = new SafariDriver();
		} else if (Browser.PHANTOMJS.equals(browser)) {
			isSupportedPlatform(browser);
			driver = new PhantomJSDriver();
		} else if (Browser.OPERA.equals(browser)) {
			System.setProperty("webdriver.chrome.driver", "/operadriver_win32/operadriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\Opera\\53.0.2907.99\\opera.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
		} else if (Browser.HTMLUNIT.equals(browser)) {
			isSupportedPlatform(browser);
			driver = new RemoteWebDriver(DesiredCapabilities.htmlUnit());
		} else
			return null;
		return driver;
	}

	/**
	 * Setup the Chrome WebDriver
	 */
	private static void setChromeDriver() {
		String chromeBinary = "/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeBinary);
	}

	/**
	 * Setup the Internet Explorer WebDriver
	 */
	private static void setIeDriver() {
		String IeBinary = "/iexploredriver.exe";
		System.setProperty("webdriver.ie.driver", IeBinary);
	}

	/**
	 * Setup the fireFox WebDriver
	 */
	private static void setFireFoxDriver() {
		String FireFoxBinary = "/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", FireFoxBinary);
	}

	/**
	 * Chech if the browser is supported by the version and the Operating System
	 * 
	 * @param browser
	 */
	private static void isSupportedPlatform(String browser) {
		boolean is_supported = true;
		Platform current = Platform.getCurrent();
		if (Browser.SAFARI.equals(browser))
			is_supported = Platform.MAC.is(current);
		if (Browser.INTERNET_EXPLORER.equals(browser))
			is_supported = Platform.WINDOWS.is(current);
		assert is_supported : "Platform is not supported by " + browser.toUpperCase() + " browser";
	}

}
