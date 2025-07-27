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
        plugin   = {"pretty"},
        monochrome = true
)
public class TestRunnerIos extends AbstractTestNGCucumberTests {

    BaseClass base = new BaseClass();

    @Parameters({"platform", "deviceName", "appFileName"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(
            String platform,
            String deviceName,
            String appFileName
    ) throws MalformedURLException {
        base.platform        = platform;
        base.iosDeviceName   = deviceName;
        base.iosAppFileName  = appFileName;
        System.out.println("Platform:    " + platform);
        System.out.println("Device Name: " + deviceName);
        System.out.println("App File:    " + appFileName);

        if ("ios".equalsIgnoreCase(platform)) {
            base.iosLocalVirtualDevice();
        } else {
            throw new RuntimeException("Unsupported platform for iOS runner: " + platform);
        }
    }

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
