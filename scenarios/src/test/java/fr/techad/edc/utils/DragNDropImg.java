package fr.techad.edc.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragNDropImg {
	private WebDriver driver;

	public DragNDropImg(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used for droping a image (path) in a location
	 * 
	 * @param filePath
	 * @param offsetX
	 * @param offsetY
	 * @param bylocaltion
	 */
	public void DropFile(File filePath, int offsetX, int offsetY, By bylocaltion) {
		if (!filePath.exists())
			throw new WebDriverException("File not found: " + filePath.toString());
		WebElement target = driver.findElement(bylocaltion);
		WebDriver driver = ((RemoteWebElement) target).getWrappedDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);

		String JS_DROP_FILE = "var target = arguments[0]," + "    offsetX = arguments[1],"
				+ "    offsetY = arguments[2]," + "    document = target.ownerDocument || document,"
				+ "    window = document.defaultView || window;" + "" + "var input = document.createElement('INPUT');"
				+ "input.type = 'file';" + "input.style.display = 'none';" + "input.onchange = function () {"
				+ "  var rect = target.getBoundingClientRect(),"
				+ "      x = rect.left + (offsetX || (rect.width >> 1)),"
				+ "      y = rect.top + (offsetY || (rect.height >> 1)),"
				+ "      dataTransfer = { files: this.files };" + ""
				+ "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {"
				+ "    var evt = document.createEvent('MouseEvent');"
				+ "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);"
				+ "    evt.dataTransfer = dataTransfer;" + "    target.dispatchEvent(evt);" + "  });" + ""
				+ "  setTimeout(function () { document.body.removeChild(input); }, 25);" + "};"
				+ "document.body.appendChild(input);" + "return input;";

		WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
		input.sendKeys(filePath.getAbsoluteFile().toString());
		wait.until(ExpectedConditions.stalenessOf(input));
	}
	
	/**
	 * drag and drop method
	 * 
	 * @param dragFrom
	 * @param dragTo
	 * @throws AWTException
	 */
	public void dragAndDrop(WebElement dragFrom, WebElement dragTo) throws AWTException {
		Robot robot = new Robot();
		robot.setAutoDelay(500);
		// Get size of elements
		Dimension fromSize = dragFrom.getSize();
		Dimension toSize = dragTo.getSize();
		Point toLocation = dragTo.getLocation();
		Point fromLocation = dragFrom.getLocation();
		// Make Mouse coordinate center of element
		toLocation.x += toSize.width / 2;
		toLocation.y += toSize.height / 2 + 50;
		fromLocation.x += fromSize.width / 2;
		fromLocation.y += fromSize.height / 2 + 50;

		// Move mouse to drag from location
		robot.mouseMove(fromLocation.x, fromLocation.y + 50);
		// Click and drag
		robot.mousePress(InputEvent.BUTTON1_MASK);

		// Drag events require more than one movement to register
		// Just appearing at destination doesn't work so move halfway first
		robot.mouseMove(((toLocation.x - fromLocation.x) / 2) + fromLocation.x,
				((toLocation.y - fromLocation.y) / 2) + fromLocation.y);

		// Move to final position
		robot.mouseMove(toLocation.x, toLocation.y);
		// Drop
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
}
