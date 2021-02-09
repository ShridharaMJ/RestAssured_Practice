package com.qa.practice.RestProject;

import org.testng.annotations.Test;

import com.qa.practice.pojo.AddMap;
import com.qa.practice.pojo.Location;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.nio.file.Files;
import java.nio.file.Paths;

public class AddMapUsingJsonPojo {

	@Test
	public void testCase1() {

		// Serialization Demo

		AddMap am = new AddMap();
		am.setAccuracy(65);
		am.setName("This testing store1");
		am.setPhone_number("16 5498749846");
		am.setAddress("#156, test layout,test cross,near test,test-521656");
		am.setWebsite("www.testingrestapi.com");
		am.setLanguage("Kannada_test");
		Location location = new Location();
		location.setLat(-45.169494);
		location.setLng(56.1489185);

		am.setLocation(location);
		String[] st = { "test1", "test2" };
		am.setTypes(st);

		String response = given().log().all().queryParam("key", "qaclick").headers("Content-Type", "application/json")
				.body(am).when().post("https://rahulshettyacademy.com/maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract().response()
				.asString();

		System.out.println(response);

	}
}
