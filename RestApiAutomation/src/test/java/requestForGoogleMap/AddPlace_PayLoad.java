package requestForGoogleMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class AddPlace_PayLoad {

	@Test
	public void addPlace(){
		//given()---> queryparameter,header, body(payload)
		//when()---> httprequest and Resource
		//Then()--> validation code
		System.out.println("---------------------------------------AddLocation------------------------------------------------");
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = RestAssured.given().log().all().queryParam("key", "qaclick123")
		                    .headers("Content-Type", "application/json")
		                    .body(PayLoadForAddplace.payLoad())
		                    
		                    .when().post("/maps/api/place/add/json")
		                    .then().log().all().assertThat().statusCode(200).header("server", "Apache/2.4.41 (Ubuntu)")
		                    .body("status",Matchers.equalTo("OK")).extract().body().asString();
		
		System.out.println("--------------------------json resonse------------------------------------");
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		JsonPath jqs=new JsonPath(response);
		System.out.println("status="+js.getString("status"));
		System.out.println("place id ="+js.getString("place_id"));
		String placeid = js.getString("place_id");
		
}
}