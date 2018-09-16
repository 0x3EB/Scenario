package fr.techad.edc.pages.editor;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PreviewPage {
	private WebDriver driver;

	public PreviewPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnPreview() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.xpath("//i[@class='fa fa-eye']")).click();
	}

	public boolean checkTitle() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		WebElement title = driver.findElement(By.xpath("//h3[@class='popover-title popover-header']"));
		if (title.getText().equals(BrickInfos.getTitle()))
			return true;
		return false;
	}

	public boolean checkDesc() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		WebElement desc = driver.findElement(By.xpath("//article[@class='popover-article']"));
		if (desc.getText().equals(BrickInfos.getDesc()))
			return true;
		return false;
	}

	public boolean checkLink() throws InterruptedException {
		boolean val = false;
		TimeUnit.SECONDS.sleep(3);
		List<WebElement> listArticleLinks = driver.findElements(By.xpath("//div[@class='article-link']"));
		for (WebElement we : listArticleLinks) {
			if (we.getText().contains(BrickInfos.getLink()))
				val = true;
		}
		return val;
	}
}
