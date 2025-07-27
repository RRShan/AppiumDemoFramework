package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.base.BaseClass;
import pagefactory.LoginScreen;
import org.testng.Assert;

public class LoginSteps extends BaseClass {

    private LoginScreen loginScreen;

    @Given("^The user is on the HomeScreen$")
    public void the_user_is_on_the_HomeScreen() {
        loginScreen = new LoginScreen(getdriver());
        boolean isDisplayed = loginScreen.isLoginScreenDisplayed();
        System.out.println(" Home screen displayed: " + isDisplayed);
        Assert.assertTrue(isDisplayed, "Home screen is not displayed.");
    }

    @When("^Click the view menu option$")
    public void click_the_view_menu_option() {
        loginScreen.clickOnViewMenuOption();
        System.out.println("Clicked on the View menu option.");
    }

    @When("^Click the login button$")
    public void click_the_login_button() {
        loginScreen.clickOnLoginButton();
        System.out.println("Clicked on the Login button.");
    }

    @Then("^Verify the presence of LoginScreen$")
    public void verify_the_presence_of_LoginScreen() {
        loginScreen.verifyThePresenceOfLoginScreen();
        System.out.println("Login screen is displayed.");
    }
}
