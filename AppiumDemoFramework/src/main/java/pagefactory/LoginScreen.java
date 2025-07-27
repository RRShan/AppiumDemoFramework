package pagefactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginScreen extends BaseClass {

    public LoginScreen(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"App logo and name\"]")
    @iOSXCUITFindBy(accessibility = "username")
    private WebElement homeScreen;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"View menu\"]")
    @iOSXCUITFindBy(accessibility = "password")
    private WebElement viewMenu;

    @AndroidFindBy(accessibility = "Login Menu Item")
    @iOSXCUITFindBy(accessibility = "login")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/selectTextTV\"]")
    @iOSXCUITFindBy(accessibility = "login")
    private WebElement loginScreenHeader;

    public boolean isLoginScreenDisplayed() {
        WebDriverWait wait= new WebDriverWait(this.getdriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(homeScreen));
        return homeScreen.isDisplayed();
    }

    public void clickOnViewMenuOption()
    {
        WebDriverWait wait= new WebDriverWait(this.getdriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(homeScreen));
        viewMenu.click();
    }

    public void verifyThePresenceOfLoginScreen()
    {
        WebDriverWait wait= new WebDriverWait(this.getdriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(loginScreenHeader));

    }

    public void clickOnLoginButton()
    {
        WebDriverWait wait= new WebDriverWait(this.getdriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();

    }
}
