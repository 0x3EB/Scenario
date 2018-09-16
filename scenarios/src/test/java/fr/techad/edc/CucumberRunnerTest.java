package fr.techad.edc;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = { "classpath:scenario/developper/editor" }, glue = { "fr/techad/edc/steps" }, plugin = {
		"pretty", "html:target/cucumber" })
public class CucumberRunnerTest {
}
