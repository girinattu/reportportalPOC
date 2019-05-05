package testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.epam.reportportal.cucumber.ScenarioReporter;

/**
 * Created by giridharvasudevan on 05/05/2019.
 */

	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "/Users/giridharvasudevan/IdeaProjects/aws/iospringsapidata/src/test/resources",//path to the features
			plugin = {"pretty","com.epam.reportportal.cucumber.ScenarioReporter","html:target/cucumber-html-report"},
			glue = { "io.springs.api.data.functionaltests" }
	)
	public class TestRunner {
		@Test
		public void startTest(){
			System.out.println("Starting Tests....");
		}

	}

