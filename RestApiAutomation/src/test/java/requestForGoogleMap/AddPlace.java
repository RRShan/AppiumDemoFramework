package requestForGoogleMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

@Test
public class AddPlace {
	public void addPlace(){
		//given()---> queryparameter,header, body(payload)
		//when()---> httprequest and Resource
		//Then()--> validation code
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response =RestAssured.given().log().all().queryParam("key", "qaclick123")
		                    .headers("Content-Type", "application/json")
		                    .body("{\r\n" + 
		                    		"  \"location\": {\r\n" + 
		                    		"    \"lat\": -38.383494,\r\n" + 
		                    		"    \"lng\": 33.427362\r\n" + 
		                    		"  },\r\n" + 
		                    		"  \"accuracy\": 50,\r\n" + 
		                    		"  \"name\": \"Frontline house\",\r\n" + 
		                    		"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
		                    		"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
		                    		"  \"types\": [\r\n" + 
		                    		"    \"shoe park\",\r\n" + 
		                    		"    \"shop\"\r\n" + 
		                    		"  ],\r\n" + 
		                    		"  \"website\": \"http://google.com\",\r\n" + 
		                    		"  \"language\": \"French-IN\"\r\n" + 
		                    		"}\r\n" + 
		                    		"")
		                    
		                    .when().post("/maps/api/place/add/json")
		                    .then().log().all().assertThat().statusCode(200).header("server", "Apache/2.4.41 (Ubuntu)")
		                    .body("status",Matchers.equalTo("OK")).extract().body().asString();
		
		System.out.println("--------------------------json resonse------------------------------------");
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		System.out.println("status="+js.getString("status"));
		System.out.println("place id ="+js.getString("place_id"));
		
		
		String placeid = js.getString("place_id");
		
		System.out.println("---------------------------------------Getplaceinfo------------------------------------------------");
		
		RestAssured.given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
		.when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200);
		
		System.out.println("-------------------UpdateLocation-----------------------------------");
		RestAssured.given().log().all().queryParam("key", "qaclick123")
		                    .body("{\r\n" + 
		                    		"\"place_id\":\""+placeid+"\",\r\n" + 
		                    		"\"address\":\"70 Jayanagar, Bangalore\",\r\n" + 
		                    		"\"key\":\"qaclick123\"\r\n" + 
		                    		"}\r\n" + 
		                    		"")
		                    .when().put("/maps/api/place/update/json")
		                    .then().log().all().assertThat().statusCode(200);
System.out.println("---------------------------------------Getplaceinfo-updatedplace------------------------------------------------");
		
		RestAssured.given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
		.when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200);
		
		
		System.out.println("--------------------------------------Delete place-----------------------------------------------------------------");
		RestAssured.given().log().all().queryParam("key", "qaclick123")
							.body("{\r\n" + 
									"    \"place_id\":\""+placeid+"\"\r\n" + 
									"}\r\n" + 
									"")
		                    .when().delete("/maps/api/place/delete/json")
		                    .then().log().all().assertThat().statusCode(200);
		
System.out.println("---------------------------------------Getplaceinfo-afterDelete------------------------------------------------");
		
		RestAssured.given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
		.when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(404);
		
	}
}
