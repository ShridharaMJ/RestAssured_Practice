package com.qa.practice.RestProject;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import com.qa.practice.pojo.Api;
import com.qa.practice.pojo.Courses;
import com.qa.practice.pojo.MainObject;
import com.qa.practice.pojo.WebAutomation;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class Oauth2Demo {

	@Test
	public void testOauth() {

		String code = "4%2F0AY0e-g5UEy8VQ4go-0xfya9NbNdt28Ak1ai8MNLvlqjDb1FcFqzi2JSCpc-4b49-iL68RA";

		// To Get access token

		String token_response = given().urlEncodingEnabled(false).log().all().queryParams("code", code)
				.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParams("grant_type", "authorization_code").when()
				.post("https://www.googleapis.com/oauth2/v4/token").then().assertThat().statusCode(200).extract()
				.asString();
		String token_vale = new JsonPath(token_response).getString("access_token");

		// Actual request

		MainObject actual_respoasnse = given().queryParam("access_token", token_vale).expect()
				.defaultParser(Parser.JSON).log().all().when().get("https://rahulshettyacademy.com/getCourse.php")
				.then().log().all().assertThat().statusCode(200).extract().as(MainObject.class);

		System.out.println(actual_respoasnse.getLinkedIn());
		
		Courses courses = actual_respoasnse.getCourses();
		List<Api> api = courses.getApi();
		
		for (Api api2 : api) {
			System.out.println(api2.getCourseTitle()+" : "+api2.getPrice());
		}
		
		 List<WebAutomation> webAutomation = actual_respoasnse.getCourses().getWebAutomation();
		for (WebAutomation webAutomation2 : webAutomation) {
			System.out.println("Courses: "+webAutomation2.getCourseTitle());
		}
	}
}
