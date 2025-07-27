package payload;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Properties;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoClass.Location;
import pojoClass.Pojoclass_Addplace_Request;



public class PayLoadForAddplace  {

	public static Pojoclass_Addplace_Request prequest;
	public static RequestSpecification req;
	public static PrintStream log;
	public static ResponseSpecification res;
	public static Properties prop;
	public static RequestSpecification request_given ;
	public static Response request_when;
	public static ValidatableResponse response_then;
	
	
	public static void payLoadForAddplace(){
		 prequest=new Pojoclass_Addplace_Request();
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
	}
}
