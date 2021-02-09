package com.qa.practice.RestProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.practice.files.Playload;

import io.restassured.path.json.JsonPath;

/**
 * @author Shridhara Jayaram
 *
 */
public class ComplexJsonPractice {
	JsonPath jsref = new JsonPath(Playload.responseJson());

	@Test
	public void testCase1() {

		// Find no. of courses

		int size = jsref.get("courses.size");
		System.out.println("no. of courses" + size);

	}

	@Test
	public void testCase2() {

		// Print purchase amount

		String amt = jsref.getString("dashboard.purchaseAmount");
		System.out.println("puchase amount is " + amt);

	}

	@Test
	public void testCase3() {

		// Print Title of the first course
		String title = jsref.getString("courses[0].title");
		System.out.println("Title of the first course " + title);
	}

	@Test
	public void testCase4() {

		// Print All course titles and their respective Prices

		for (int i = 0; i < jsref.getInt("courses.size()"); i++) {

			System.out.println("title : " + jsref.getString("courses[" + i + "].title") + " & " + "price : "
					+ jsref.getInt("courses[" + i + "].price"));
		}

	}

	@Test
	public void testCase5() {

		// Print no of copies sold by RPA Course

		for (int i = 0; i < jsref.getInt("courses.size()"); i++) {

			if (jsref.getString("courses[" + i + "].title").equals("RPA")) {
				System.out.println(" no of copies sold by RPA Course " + jsref.getInt("courses[" + i + "].copies"));
				break;
			}
		}

	}

	@Test
	public void testCase6() {
		// Verify if Sum of all Course prices matches with Purchase Amount

		int sum_of_sold = 0;
		for (int i = 0; i < jsref.getInt("courses.size()"); i++) {

			int price = jsref.getInt("courses[" + i + "].price");
			int no_of_copies = jsref.getInt("courses[" + i + "].copies");
			sum_of_sold = sum_of_sold + (price * no_of_copies);
		}
		int purchased_amount = jsref.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum_of_sold, purchased_amount,"Purchase amount & Sum of each course are not equal");

	}

}
