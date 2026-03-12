package demo;
import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class ResQres {
public static void main(String[] args) {
	baseURI="https://fakerestapi.azurewebsites.net";

	Response response = given()
			.header("Content-Type","application/json")
			.body ("{\r\n"
					+ "  \"id\": 0,\r\n"
					+ "  \"idBook\": 7,\r\n"
					+ "  \"firstName\": \"Happy\",\r\n"
					+ "  \"lastName\": \"singh\"\r\n"
					+ "}").log().all()
			.when().post("/api/v1/Authors").then()

			.log().all()
			
			.extract().response();
	
	String responseData = response.asPrettyString();

	System.out.println("Response data is " + responseData);

	String statusLine = response.getStatusLine();
	System.out.println(statusLine);

	int statusCode = response.getStatusCode();
	System.out.println(statusCode);
	
	
}


}
