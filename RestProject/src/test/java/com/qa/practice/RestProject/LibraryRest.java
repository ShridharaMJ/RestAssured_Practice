package com.qa.practice.RestProject;

import static io.restassured.RestAssured.given;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.practice.files.Playload;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class LibraryRest {
	String id = "";

	@Test(dataProvider = "LibraryData")
	public void testLibraryAPI(String isbn, String aisle) {

		RestAssured.baseURI = "http://216.10.245.166";
		String res = given().log().all().body(Playload.addLibraryJson(isbn, aisle)).when().post("/Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		id = new JsonPath(res).getString("ID");

	}

	@AfterMethod
	public void cleanUp() {

		given().log().all().body("{\r\n" + " \r\n" + "\"ID\" : \"" + id + "\"\r\n" + " \r\n" + "} \r\n" + "").when()
				.post("http://216.10.245.166/Library/DeleteBook.php").then().assertThat().statusCode(200);

	}

	@DataProvider
	public Object[][] LibraryData() {
		return new Object[][] { { "ghgh", "65465" }, { "jhd", "5874" }, { "hguiy", "6546" } };

	}
}
