package fr.techad.edc.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardPage {

	private WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getActivityStream() {
		List<WebElement> listActivityStream = driver.findElements(By.xpath("//div[@class='notification-messages']/span"));
		return listActivityStream;
	}

	public WebElement getLastActivityStream() {
		return getActivityStream().get(0);
	}

	public int getNumberOfActivityStream() {
		return getActivityStream().size();
	}

	public boolean brickCreatedActivity(String strBrick) throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
		for (WebElement we : getActivityStream()) {
			we.getText().contains(strBrick);
			return true;
		}
		return false;
	}
}
