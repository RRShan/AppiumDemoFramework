package stepDefinition;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.SkipException;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.Add2cartpage;
import pageFactory.Departmentpage;
import pageFactory.HomePage;
import pageFactory.Itemspage;
import pageFactory.Itemssublistpage;
import pageFactory.Sucessmsgpage;
import testBase.TestBase;

public class StepDefinations extends TestBase{
	@BeforeAll
	public static void beforeAllfeatures() throws Throwable{
		openBrowser();
	}
	@AfterAll
	public static void afterAllfeatures(){
		closeBrwoser();
	}
	
	
	@Before
	public void beforeEachScenario(){
		 Object[] paramNames = Reporter.getCurrentTestResult().getParameters();          
		    String featureName = paramNames[1].toString().replaceAll("^\"+|\"+$", "");
		    System.out.println("Feature file name: " + featureName);
		    if((map.get(featureName)==null) || (!map.get(featureName).equalsIgnoreCase("yes"))){
		    	throw new SkipException("This feature is not set for execution in the moduledriver");
		    }
	}
	@Given("^user is in the department page$")
    public void user_is_in_the_department_page() throws Throwable {
		//Homepage hp=new Homepage();
		//HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.clickondontchange();
		hp.clickontodaysdeal();
    }

	@When("^user select (.+) checkbox and select an item$")
    public void user_select_checkbox_and_select_an_item(String checkbox) throws Throwable {
//	@When("^user select \"([^\"]*)\" checkbox and select an item$")
//    public void user_select_something_checkbox_and_select_an_item(String checkbox) throws Throwable {
     /* Departmentpage dp = PageFactory.initElements(driver, Departmentpage.class);
      Itemspage ip = PageFactory.initElements(driver, Itemspage.class);
      Itemssublistpage isp = PageFactory.initElements(driver, Itemssublistpage.class);*/
      dp.selectcheckbox(checkbox);
      Thread.sleep(3000);
      ip.clickonfirstitem();
      Thread.sleep(3000);
      isp.clickonfirstiteminsublist();
    }

	@Then("^an should be sucessfully added to cart$")
    public void an_should_be_sucessfully_added_to_cart() throws Throwable {
//       Sucessmsgpage sp = PageFactory.initElements(driver, Sucessmsgpage.class);
       sp.verifysuccessmsg();
    }

    @And("^click on add2cart button$")
    public void click_on_add2cart_button() throws Throwable {
      //Add2cartpage acp = PageFactory.initElements(driver, Add2cartpage.class);
       acp.clickonadd2cart();
    }
}
