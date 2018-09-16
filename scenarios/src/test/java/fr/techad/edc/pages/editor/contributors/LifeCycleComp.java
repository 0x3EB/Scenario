package fr.techad.edc.pages.editor.contributors;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import fr.techad.edc.pages.editor.ConfigEditorMenuComp;
import fr.techad.edc.pages.editor.editorArea.ArticlesComp;
import fr.techad.edc.pages.editor.editorArea.CommentsComp;
import fr.techad.edc.pages.editor.editorArea.ParametersComp;

public class LifeCycleComp {

	WebDriver driver;
	ParametersComp parameter;
	ConfigEditorMenuComp editorMenu;
	CommentsComp comment;
	ArticlesComp article;
	ConfigMenuContributorsComp menuContributor;

	public LifeCycleComp(WebDriver driver) {
		this.driver = driver;
		this.parameter = new ParametersComp(driver);
		this.editorMenu = new ConfigEditorMenuComp(driver);
		this.comment = new CommentsComp(driver);
		this.article = new ArticlesComp(driver);
		this.menuContributor = new ConfigMenuContributorsComp(driver);
	}

	private List<WebElement> lifeCycleList() {
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='timeline-badge']"));
		return findElements;
	}

	/**
	 * Click on the third step of the life cylcle (Finish)
	 * 
	 * @return true or false if the status has been change (finished)
	 * @throws InterruptedException
	 */
	public boolean clickFinish() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		String textBeforeClick = driver.findElement(By.xpath(
				"/html/body/ui-view/edc-app/div/ui-view/edc-edition/div/ui-view/ng-form/edc-editor/edc-loader/div/edc-right-sidebar/aside/ul/div/edc-right-sidebar-item[4]/li/div[2]/div/edc-life-cycle/ul/li[3]/div[1]/em"))
				.getText();
		try {
			lifeCycleList().get(2).click();
			TimeUnit.SECONDS.sleep(2);
			String textAfterClick = driver.findElement(By.xpath(
					"/html/body/ui-view/edc-app/div/ui-view/edc-edition/div/ui-view/ng-form/edc-editor/edc-loader/div/edc-right-sidebar/aside/ul/div/edc-right-sidebar-item[4]/li/div[2]/div/edc-life-cycle/ul/li[3]/div[1]/em"))
					.getText();
			return (textBeforeClick.equals(textAfterClick));
		} catch (WebDriverException ex) {
			return false;
		}
	}

	/**
	 * Check if the menu above LifeCycle are clickable
	 * 
	 * @return True or false if all the menu are clickable
	 * @throws InterruptedException 
	 */
	public boolean clickOnContributors() throws InterruptedException {
		try {
			menuContributor.clickOnArticlesTypes();
			menuContributor.clickOnImages();
			menuContributor.clickOnLinks();
			menuContributor.clickOnLifeCycle();
			return true;
		} catch (WebDriverException ex) {
			return false;
		}
	}

	/**
	 * Click on the fourth step of the life cycle (Validate)
	 * 
	 * @return true or false if the status has been change (validated)
	 * @throws InterruptedException
	 */
	public boolean clickValid() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		String textBeforeClick = driver.findElement(By.xpath(
				"/html/body/ui-view/edc-app/div/ui-view/edc-edition/div/ui-view/ng-form/edc-editor/edc-loader/div/edc-right-sidebar/aside/ul/div/edc-right-sidebar-item[4]/li/div[2]/div/edc-life-cycle/ul/li[4]/div[1]/em"))
				.getText();
		try {
			lifeCycleList().get(3).click();
			TimeUnit.SECONDS.sleep(2);
			String textAfterClick = driver.findElement(By.xpath(
					"/html/body/ui-view/edc-app/div/ui-view/edc-edition/div/ui-view/ng-form/edc-editor/edc-loader/div/edc-right-sidebar/aside/ul/div/edc-right-sidebar-item[4]/li/div[2]/div/edc-life-cycle/ul/li[4]/div[1]/em"))
					.getText();
			return (textBeforeClick.equals(textAfterClick));
		} catch (WebDriverException ex) {
			return false;
		}
	}

	/**
	 * try Edit the parameters
	 * 
	 * @return True or false if the parameters are editable
	 * @throws InterruptedException
	 */
	public boolean editParameters() throws InterruptedException {
		editorMenu.clickOnParameters();
		try {
			parameter.setTitle("aaa");
			parameter.setBrickType("Window");
			parameter.editBrick("AA", "BB", "AZERTYUIOP");
			return true;
		} catch (WebDriverException ex) {
			return false;
		}
	}

	public boolean editTextArea() {
		article.editText();
		try {
			driver.findElement(By.xpath("//*[@id=\"cke_826_top\"]"));
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	/**
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean addComment() throws InterruptedException {
		editorMenu.clickOnComments();
		try {
			comment.addComment("aaaaaaaaaaaaaaaa");
			return true;
		} catch (WebDriverException ex) {
			return false;
		}
	}
}
