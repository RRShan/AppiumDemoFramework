package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.base.BaseClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

@CucumberOptions(
        features = "src/main/java/features/Login.feature",
        glue     = {"stepdefinitions"},
        tags     = {"@login"},
        plugin   = {
                "pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)
public class TestRunnerAndroid extends AbstractTestNGCucumberTests {

    BaseClass base = new BaseClass();

    @Parameters({"platform", "deviceName", "appFileName"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(
            String platform,
            String deviceName,
            String appFileName
    ) throws MalformedURLException {

        base.platform    = platform;
        base.androidDeviceName = deviceName;
        base.androidAppFileName = appFileName;

        System.out.println("Platform:    " + platform);
        System.out.println("Device Name: " + deviceName);
        System.out.println("App File:    " + appFileName);

        if ("android".equalsIgnoreCase(platform)) {
            base.androidLocalVirtualDevice();
        } else {
            throw new RuntimeException("Unsupported platform: " + platform);
        }
    }

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
