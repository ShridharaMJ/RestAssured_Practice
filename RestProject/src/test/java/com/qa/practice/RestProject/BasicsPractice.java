package com.qa.practice.RestProject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.qa.practice.files.Playload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class BasicsPractice {

	@Test
	public void postTest() throws IOException {

		// created Post API method---POST

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick").headers("Content-Type", "application/json")
				.body(Files.readString(Paths.get("F://APITesting//RestAssured//Postman_APIContract/AddMap.json")))
				.when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract().response()
				.asString();

		JsonPath jsref = new JsonPath(response);
		String placeid = jsref.getString("place_id");

		// Using Post response updating------ PUT

		given().log().all().queryParam("key", "qaclick123").headers("Content-Type", "application/json")
				.body(Playload.addMapPutJsonRequest(placeid)).when().put("/maps/api/place/update/json").then().log()
				.all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));

		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid).when()
				.get("/maps/api/place/get/json").then().log().all().assertThat().statusCode(200)
				.body("address", startsWith("100, HM  temple, Test City"));

		Reporter.log("TestCase is passed E2E", true);

		System.out.println(Files.readString(Paths.get("F://APITesting//RestAssured//Postman_APIContract/AddMap.json")));

	}

}
