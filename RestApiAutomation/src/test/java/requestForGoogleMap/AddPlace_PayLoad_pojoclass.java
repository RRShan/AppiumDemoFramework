package requestForGoogleMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import pojoClass.Pojoclass_Response_addplace;

public class AddPlace_PayLoad_pojoclass {

	@Test
	public void addPlace(){
		//given()---> queryparameter,header, body(payload)
		//when()---> httprequest and Resource
		//Then()--> validation code
		System.out.println("---------------------------------------AddLocation------------------------------------------------");
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Pojoclass_Response_addplace pojoresponse = RestAssured.given().log().all().queryParam("key", "qaclick123")
		                    .headers("Content-Type", "application/json")
		                    .body(PayLoadForAddplace.payLoad())
		                    
		                    .when().post("/maps/api/place/add/json")
		                    .then().log().all().assertThat().statusCode(200).header("server", "Apache/2.4.41 (Ubuntu)")
		                    .body("status",Matchers.equalTo("OK")).extract().body().as(Pojoclass_Response_addplace.class);
		
		System.out.println("--------------------------json resonse------------------------------------");
		System.out.println("status="+pojoresponse.getStatus());
		String place_id = pojoresponse.getPlace_id();
		System.out.println("place_id="+place_id);
		
		
}
}