package requestForGoogleMap;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojoClass.Location;
import pojoClass.Pojoclass_Request_addplace;
import pojoClass.Pojoclass_Response_addplace;

public class AddPlace_PayLoad_pojoclass_Requestpojoclass {

	@Test
	public void addPlace(){
		//given()---> queryparameter,header, body(payload)
		//when()---> httprequest and Resource
		//Then()--> validation code
		Pojoclass_Request_addplace prequest=new Pojoclass_Request_addplace();
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		prequest.setLocation(l);
		prequest.setAccuracy(50);
		prequest.setName("SKN Techsolutions");
		prequest.setPhone_number("9973383838");
		prequest.setAddress("70,Jayanagar");
		ArrayList<String> ar=new ArrayList<String>();
		ar.add("Service");
		ar.add("office");
		prequest.setTypes(ar);
		prequest.setWebsite("www.skntechsolution.org");
		prequest.setLanguage("English");
		
		System.out.println("---------------------------------------AddLocation------------------------------------------------");
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Pojoclass_Response_addplace pojoresponse = RestAssured.given().log().all().queryParam("key", "qaclick123")
		                    .headers("Content-Type", "application/json")
		                    .body(prequest)
		                    
		                    .when().post("/maps/api/place/add/json")
		                    .then().log().all().assertThat().statusCode(200).header("server", "Apache/2.4.41 (Ubuntu)")
		                    .body("status",Matchers.equalTo("OK")).extract().body().as(Pojoclass_Response_addplace.class);
		
		System.out.println("--------------------------json resonse------------------------------------");
		System.out.println("status="+pojoresponse.getStatus());
		String place_id = pojoresponse.getPlace_id();
		System.out.println("place_id="+place_id);
		
		
}
}