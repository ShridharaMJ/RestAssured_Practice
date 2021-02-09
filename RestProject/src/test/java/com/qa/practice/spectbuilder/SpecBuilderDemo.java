package com.qa.practice.spectbuilder;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.practice.files.Playload;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilderDemo {

	RequestSpecification requestSpecBuilder;
	ResponseSpecification responseSpecification;

	@BeforeTest
	public void setUp() {
		requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();

		responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.build();

	}

	@Test
	public void addMap() {
		RequestSpecification body = given().log().all().spec(requestSpecBuilder)
				.body(Playload.addMapPutJsonRequest("165165416413"));

		body.when().post("/maps/api/place/add/json").then().log().all().spec(responseSpecification);

	}

}
