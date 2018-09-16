package fr.techad.edc.pages.editor.contributors;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;
import fr.techad.edc.pages.editor.editorArea.ArticlesComp;
import fr.techad.edc.utils.DragNDropImg;

public class ImagesComp {

	private WebDriver driver;
	ConfigMenuContributorsComp configContributors;
	DragNDropImg img;
	By dropZone = By.xpath("//div[@class='dropzone ng-isolate-scope dz-clickable dz-started']");
	By replaceImg = By.xpath("//i[@class='fa fa-exchange']");
	By deleteImg = By.xpath("//i[@class='glyphicon glyphicon-remove']");
	ArticlesComp articlesEditorArea;
	DragNDropImg dragNdrop;

	public ImagesComp(WebDriver driver) {
		this.driver = driver;
		configContributors = new ConfigMenuContributorsComp(driver);
		this.img = new DragNDropImg(driver);
		this.articlesEditorArea = new ArticlesComp(driver);
		this.dragNdrop = new DragNDropImg(driver);
	}

	/**
	 * Get all the images on the left side
	 * 
	 * @return Return a list of WebElement
	 */
	private List<WebElement> getImagesDiv() {
		List<WebElement> findElements = driver
				.findElements(By.xpath("//div[@class='dz-preview dz-processing dz-complete dz-image-preview']"));
		return findElements;
	}

	/**
	 * Get all the button replace of the images
	 * 
	 * @return Return a list of WebElement
	 */
	private List<WebElement> getReplaceImg() {
		List<WebElement> findElements = driver.findElements(replaceImg);
		return findElements;
	}

	private void setupAutoItX() {
		File file = new File(".\\libs\\jacob-1.19-x64.dll");
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
	}

	/**
	 * Get all the button delete of the images
	 * 
	 * @return Return a list of WebElement
	 */
	private List<WebElement> getDeleteImg() {
		List<WebElement> findElements = driver.findElements(deleteImg);
		return findElements;
	}

	/**
	 * Test if you can click on the menu Images
	 * 
	 * @return True or False if you have the permission to click
	 */
	public boolean clickOnImages() {
		try {
			configContributors.clickOnImages();
			return true;
		} catch (WebDriverException ex) {
			return false;

		}
	}

	/**
	 * Test if you can upload Images
	 * 
	 * @param strPath
	 * @return Return true or false if you can upload
	 * @throws InterruptedException 
	 */
	public boolean uploadImg(String strPath) throws InterruptedException {
		try {
			TimeUnit.SECONDS.sleep(3);
			// img.DropFile(new File(strPath), 0, 0, dropZone);
			driver.findElement(By.xpath("//button[@class='btn btn-success dz-clickable']")).click();
			setupAutoItX();
			if (driver.toString().contains("firefox")) {
				AutoItX x = new AutoItX();
				x.controlFocus("Envoi du fichier", "", "Edit1");
				TimeUnit.SECONDS.sleep(3);
				x.ControlSetText("Envoi du fichier", "", "Edit1", strPath);
				TimeUnit.SECONDS.sleep(3);
				x.controlClick("Envoi du fichier", "", "Button1");
				return true;
			} else if (driver.toString().contains("chrome")) {
				AutoItX x = new AutoItX();
				x.controlFocus("Ouvrir", "", "Edit1");
				TimeUnit.SECONDS.sleep(3);
				x.ControlSetText("Ouvrir", "", "Edit1", strPath);
				TimeUnit.SECONDS.sleep(3);
				x.controlClick("Ouvrir", "", "Button1");
				return true;
			} else
				return false;
		} catch (WebDriverException ex) {
			return false;
		}
	}

	/**
	 * Test if the last images you have upload can be add in the text area
	 * 
	 * @return Return true or false if the image can be add
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public boolean addImgToTextarea() throws AWTException, InterruptedException {
		try {
			WebElement newAdd = driver.findElement(
					By.xpath("//div[@class='dz-preview dz-processing dz-image-preview dz-success dz-complete']"));
			TimeUnit.SECONDS.sleep(1);
			getImagesDiv().add(newAdd);
			for (WebElement we : articlesEditorArea.getTextAreas()) {
				we.click();
				TimeUnit.SECONDS.sleep(2);
				dragNdrop.dragAndDrop(newAdd, we);
			}
			return true;
		} catch (WebDriverException ex) {
			System.out.println("err");
			return false;
		}
	}

	/**
	 * Test if you can replace the last Image you have upload by another
	 * 
	 * @param strPath
	 * @return Return true or false if you can replace the image
	 * @throws IOException
	 */
	public boolean replaceImg(String strPath) throws IOException {
		try {
			setupAutoItX();
			getReplaceImg().get(getImagesDiv().size()).click();
			driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
			if (driver.toString().contains("firefox")) {
				AutoItX x = new AutoItX();
				x.controlFocus("Envoi du fichier", "", "Edit1");
				x.ControlSetText("Envoi du fichier", "", "Edit1", strPath);
				x.controlClick("Envoi du fichier", "", "Button1");
				return true;
			} else if (driver.toString().contains("chrome") || driver.toString().contains("opera")) {
				AutoItX x = new AutoItX();
				x.controlFocus("Ouvrir", "", "Edit1");
				x.ControlSetText("Ouvrir", "", "Edit1", strPath);
				x.controlClick("Ouvrir", "", "Button1");
				return true;
			} else
				return false;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	/**
	 * Test if the user can delete the last image uploaded
	 * 
	 * @return
	 */
	public boolean deleteImg() {
		try {
			getDeleteImg().get(getImagesDiv().size() - 1).click();
			try {
				driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
				;
			} catch (NoSuchElementException ex) {
				return false;
			}
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	
}
