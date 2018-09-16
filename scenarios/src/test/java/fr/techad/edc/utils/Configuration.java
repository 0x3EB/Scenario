package fr.techad.edc.utils;

public class Configuration {

	private static final String BROWSER = "BROWSER";
	private static final String URL = "URL";

	private static String URL_DEFAULT = "https://demo.easydoccontents.com"; // URL

	/**
	 * Return the browser which will be used to test the AUT
	 * 
	 * @return the browser name
	 */
	public String getBrowser() {
		String browser = getValue(BROWSER);
		if (browser == null) {
			browser = Browser.CHROME;
		}
		return browser;
	}

	/**
	 * Get the AUT url
	 * 
	 * @return the url
	 */
	public String getUrl() {
		String url = getValue(URL);
		if (url == null) {
			url = URL_DEFAULT;
		}
		return url;
	}

	private String getValue(String key) {
		String value = System.getenv(key);
		if (value == null) {
			value = System.getProperty(key);
		}
		return value;
	}
}
