package mytest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import singleTon.WebDriverManager;


public class AppTest {
    private WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) {
        driver = WebDriverManager.getInstance(browser).getdriver();

    }

    @Test
    public void testGoogle() {
        driver.get("https://www.google.com");
        System.out.println(Thread.currentThread().getName() + ": " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @AfterClass
    public void tearDown() {
        WebDriverManager.quitebrowser();
    }
}