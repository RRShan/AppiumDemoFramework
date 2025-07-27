package runner;




import cucumber.api.CucumberOptions;
import cucumber.api.testng.*;
import cucumber.api.testng.TestNGCucumberRunner;

import org.testng.ITest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



@CucumberOptions(
        features = "Featurefile/Login.feature",
        glue = {"Steps"},
        tags = {"@sha"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class TestRunner_Android implements ITest {

    private TestNGCucumberRunner testNGCucumberRunner;  // 2 usages, ensure it's initialized
    // No usages, can potentially be removed if not used
    private ThreadLocal<String> testName = new ThreadLocal<>();  // 1 usage, ensure it's properly accessed


    @BeforeClass(alwaysRun = true)
    public void setup() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }


    @Override
    public String getTestName() {
        return testName.get();  // Ensure getTestName() is used somewhere
    }

    @Test(groups = "cucumber scenarios", dataProvider = "scenarios")  // Missing dataProvider annotation on method
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        // Your test logic here
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }

    @DataProvider(parallel = false)  // Missing usage references, ensure it's used in your test methods
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }
}
