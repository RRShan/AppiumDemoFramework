package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class RunTest {

	@CucumberOptions(features = "src/test/java", glue = "stepDefinations",

			plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
	public class TestRunner extends AbstractTestNGCucumberTests {

	}
}
