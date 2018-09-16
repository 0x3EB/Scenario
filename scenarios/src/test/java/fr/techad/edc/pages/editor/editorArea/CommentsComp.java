package fr.techad.edc.pages.editor.editorArea;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommentsComp {
	private WebDriver driver;

	public CommentsComp(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Find the comments already sent
	 * 
	 * @return
	 */
	private List<WebElement> listComments() {
		List<WebElement> findElements = driver.findElements(By.xpath("//span[@class='comment']"));
		return findElements;
	}

	/**
	 * Add the comment to the textarea
	 * 
	 * @param strComment
	 * @throws InterruptedException
	 */
	private void setComment(String strComment) throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		try {
			driver.findElement(By.xpath("//*[@id=\"NG2_UPGRADE_16_0\"]/div[1]/div[2]/div/textarea"))
					.sendKeys(strComment);
		} catch (NoSuchElementException ex) {
			driver.findElement(By.xpath("//*[@id=\"NG2_UPGRADE_16_0\"]/div[1]/div/div/textarea")).sendKeys(strComment);
		}
	}

	/**
	 * Send the comment written
	 * 
	 * @throws InterruptedException
	 */
	private void clickSave() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='flex-button btn btn-primary btn-s ng-binding']")).click();
		TimeUnit.SECONDS.sleep(2);
	}

	/**
	 * Add the comment and verify
	 * 
	 * @param strComment
	 * @return
	 * @throws InterruptedException
	 */
	public boolean addComment(String strComment) throws InterruptedException {
		try {
			setComment(strComment);
			clickSave();
			if (checkAddComment(strComment) == true)
				return true;
			else
				return false;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	/**
	 * Verify if the comment has been send or not
	 * 
	 * @param strComment
	 * @return
	 */
	public boolean checkAddComment(String strComment) {
		return listComments().get(listComments().size() - 1).getText().equals(strComment);
	}
}
