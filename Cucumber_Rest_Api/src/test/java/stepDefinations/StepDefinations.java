package stepDefinations;

import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import testBase.TestBase;



public class StepDefinations extends TestBase {
	@Before
	public void beforeEachScanario() throws Throwable{
		setUp();
		tearDown();
	}
	 @Given("^Add place payLoad$")
	    public void add_place_payload() throws Throwable {
	         request_given = RestAssured.given().log().all().spec(req).body(prequest);
	    }

	    @When("^user calls AddplaceAPI with POST http request$")
	    public void user_calls_addplaceapi_with_post_http_request() throws Throwable {
	    	 request_when = request_given.when().post(prop.getProperty("resourceForPostRequest"));
	    }

	    @Then("^the API call got sucessful with status code 200$")
	    public void the_api_call_got_sucessful_with_status_code_200() throws Throwable {
	    	 response_then = request_when.then().log().all().assertThat().spec(res);
	    }
	    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	    public void something_in_response_body_is_something(String key, String value) throws Throwable {
	    	String response = response_then.extract().response().body().asString();
	    	JsonPath js=new JsonPath(response);
	    	Assert.assertEquals(js.getString(key), value);
	    }
	
}
