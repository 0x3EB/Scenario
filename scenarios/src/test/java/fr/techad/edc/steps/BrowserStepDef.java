package fr.techad.edc.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import fr.techad.edc.utils.WebDriverFactory;

public class BrowserStepDef {
	@And("^Finish$")
	public void finish() throws Throwable {
		WebDriverFactory.reset();
	}

	@And("^I wait the url page change$")
	public void iWaitTheUrlPageChange() throws Throwable {
		final String currentPage = WebDriverFactory.getDriver().getCurrentUrl();
		WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return !d.getCurrentUrl().equals(currentPage);
			}
		};

		wait.until(e);
	}

	@Given("I am on the browser \"([^\\\"]*)\"")
	public void i_am_on_the_browser(String strBrowser) {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		WebDriverFactory.getDriver(strBrowser.toLowerCase());
	}
}
