package fr.techad.edc.pages.publishing;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PublishingComp {
	private WebDriver driver;
	private String product; // Var name product
	private String nowFormatHHMMSS; // Var Date hours, minutes, secondes
	private String nowFormatYYYYMMDD; // Var Date year, month, day

	public PublishingComp(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * CLick on the menu to acces to the Publishement
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean clickOnPublishing() throws InterruptedException {
		try {
			TimeUnit.SECONDS.sleep(2);
			driver.findElement(
					By.xpath("/html/body/ui-view/edc-app/div/edc-header/header/div/div/div[2]/ul[1]/li[3]/a")).click();
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	/**
	 * selec the version and the product to extract
	 * 
	 * @param strProduct
	 * @param strVersion
	 * @return
	 * @throws InterruptedException
	 */
	public boolean selectVersionProduct(String strProduct, String strVersion) throws InterruptedException {
		try {
			TimeUnit.SECONDS.sleep(2);
			try {
				List<WebElement> listMenu = driver.findElements(By.xpath(
						"//select[@class='databox-drop-list edc-placeholder ng-untouched ng-pristine ng-invalid']"));
				Select listProducts = new Select(listMenu.get(0));
				listProducts.selectByVisibleText(strProduct);
				setProduct(strProduct);
				Select listVersion = new Select(listMenu.get(1));
				listVersion.selectByVisibleText(strVersion);
			} catch (IndexOutOfBoundsException ex) {
				List<WebElement> listMenu = driver.findElements(
						By.xpath("//select[@class='databox-drop-list ng-untouched ng-pristine ng-valid']"));
				Select listProducts = new Select(listMenu.get(0));
				listProducts.selectByVisibleText(strProduct);
				setProduct(strProduct);
				Select listVersion = new Select(listMenu.get(1));
				listVersion.selectByVisibleText(strVersion);
			}
			TimeUnit.SECONDS.sleep(2);
			clickNextOrPublish();
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	/**
	 * Create the HTML package of the wizard
	 */
	public void createHTMLPackage() {
		driver.findElement(By.xpath(
				"/html/body/ui-view/edc-app/div/ui-view/edc-publishing/div/div/div[3]/form/div[2]/edc-step-2/div/div/label/div/div"))
				.click();
		clickNextOrPublish();
	}

	/**
	 * Set the name of the product choosen
	 * 
	 * @param product
	 */
	private void setProduct(String product) {
		this.product = product;
	}

	/**
	 * Get the product name
	 * 
	 * @return
	 */
	private String getProduct() {
		return this.product;
	}

	/**
	 * Tick all the status
	 * 
	 * @return
	 */
	public boolean selectAllStatus() {
		try {
			driver.findElement(By.xpath(
					"/html/body/ui-view/edc-app/div/ui-view/edc-publishing/div/div/div[3]/form/div[3]/edc-step-3/div/div[2]/div[1]/label/span"))
					.click();
			clickNextOrPublish();
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	/**
	 * Click on the button next or publish at the end
	 */
	public void clickNextOrPublish() {
		driver.findElement(
				By.xpath("/html/body/ui-view/edc-app/div/ui-view/edc-publishing/div/div/div[4]/div/button[2]")).click();
	}

	/**
	 * Download the ZIP file
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean clickOnDownload() throws InterruptedException {
		try {
			TimeUnit.SECONDS.sleep(10);
			driver.findElement(By.xpath("/html/body/ui-view/edc-app/div/ui-view/edc-publishing/div/div/div[4]/div/a"))
					.click();
			setDateYearMonthDay();
			setDateHoursMinutesSeconds();
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	/**
	 * set the date with the hours, minutes, secondes for the zip name
	 */
	private void setDateHoursMinutesSeconds() {
		Date now = new Date();
		nowFormatHHMMSS = new SimpleDateFormat("HHmmss", Locale.ENGLISH).format(now);
		int correctHour = Integer.parseInt(nowFormatHHMMSS);
		correctHour = correctHour - 20000;
		if (String.valueOf(correctHour).length() == 5)
			nowFormatHHMMSS = "0" + Integer.toString(correctHour);
		else
			nowFormatHHMMSS = Integer.toString(correctHour);
	}

	/**
	 * Get the hours, Minutes, Secondes
	 * 
	 * @return
	 */
	private String getDateHoursMinutesSeconds() {
		return this.nowFormatHHMMSS;
	}

	/**
	 * Set the date with Year month day for the zip name
	 */
	private void setDateYearMonthDay() {
		Date now = new Date();
		nowFormatYYYYMMDD = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(now);
	}

	/**
	 * Get the Year, month, day
	 * 
	 * @return
	 */
	private String getDateYearMonthDay() {
		return this.nowFormatYYYYMMDD;
	}

	/**
	 * Check if the zip has been dowload to the Downloads directory
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean verifyDownloadedZIP() throws InterruptedException {
		String home = System.getProperty("user.home");
		TimeUnit.SECONDS.sleep(3);
		File dir = new File(home + "/Downloads");
		File[] files = dir.listFiles(zipFilter);
		System.out.println(getDateYearMonthDay() + getDateHoursMinutesSeconds());
		if (files.length == 0) {
			return false;
		} else {
			for (File f : files) {
				System.out.println(f.getName());
			}
			return true;
		}
	}

	/**
	 * Filter the name of files
	 */
	FilenameFilter zipFilter = new FilenameFilter() {
		public boolean accept(File file, String name) {
			if (name.endsWith(getDateYearMonthDay() + "-" + getDateHoursMinutesSeconds() + ".zip")
					&& (name.startsWith(getProduct()))) {
				return true;
			} else {
				return false;
			}
		}
	};
}
