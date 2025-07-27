package requestForGoogleMap;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoClass.Location;
import pojoClass.Pojoclass_Request_addplace;
import pojoClass.Pojoclass_Response_addplace;

public class AddPlace_PayLoad_pojoclass_Requestpojoclass_ReqAndResSpecBuilder {

	@Test
	public void addPlace() throws Throwable{
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
		PrintStream log=new PrintStream(new FileOutputStream("Logging.txt"));
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		                                 .setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(log))
		                                 .addFilter(ResponseLoggingFilter.logResponseTo(log)).build();		                                		                                 		
		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		//RestAssured.baseURI="https://rahulshettyacademy.com";
		RequestSpecification requestspec_given = RestAssured.given().log().all().spec(req).body(prequest);
		
		Response response_when = requestspec_given.when().post("/maps/api/place/add/json");
		
		Pojoclass_Response_addplace pojoresponse = response_when.then().log().all().spec(res).extract().response().as(Pojoclass_Response_addplace.class);
		
		
		
		RequestSpecification body = RestAssured.given().log().all().spec(req).body(prequest);
		Response post = requestspec_given.when().post("");
		Pojoclass_Response_addplace as = post.then().log().all().spec(res).extract().response().as(Pojoclass_Response_addplace.class);
		as.getStatus();
		
		
		
		
	/*	Pojoclass_Response_addplace pojoresponse = RestAssured.given().log().all().queryP
	 * aram("key", "qaclick123")
		                    .headers("Content-Type", "application/json")
		                    .body(prequest)
		                    
		                    .when().post("/maps/api/place/add/json")
		                    .then().log().all().assertThat().statusCode(200).header("server", "Apache/2.4.41 (Ubuntu)")
		                    .body("status",Matchers.equalTo("OK")).extract().body().as(Pojoclass_Response_addplace.class);*/
		
		System.out.println("--------------------------json resonse------------------------------------");
		System.out.println("status="+pojoresponse.getStatus());
		String place_id = pojoresponse.getPlace_id();
		System.out.println("place_id="+place_id);
		
		
}
}