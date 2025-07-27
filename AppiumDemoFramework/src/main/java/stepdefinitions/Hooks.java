package stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.base.BaseClass;

public class Hooks extends BaseClass {

    @Before
    public void cucumberBefore(Scenario scenario) {
        System.out.println(" Starting Scenario: " + scenario.getName());
    }

    @After
    public void cucumberAfter(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario Failed: " + scenario.getName());
        } else {
            System.out.println(" Scenario Passed: " + scenario.getName());
        }

        // Cleanup driver
        if (driver.get() != null) {
            System.out.println(" Closing driver for scenario: " + scenario.getName());
            driver.get().quit();
            driver.remove();
        }
    }
}
