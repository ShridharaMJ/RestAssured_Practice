package com.qa.practice.files;

public class Playload {
	public static String addMapPostJsonRequest() {
		return "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -56.455665,\r\n" + "    \"lng\": 45.152568\r\n"
				+ "  },\r\n" + "  \"accuracy\": 88,\r\n" + "  \"name\": \"Pump House\",\r\n"
				+ "  \"phone_number\": \"987946451\",\r\n" + "  \"address\": \"77, Test Layout, Test City 09\",\r\n"
				+ "  \"types\": [\r\n" + "    \"Test park\",\r\n" + "    \"Test\"\r\n" + "  ],\r\n"
				+ "  \"website\": \"http://testpumphouse.com\",\r\n" + "  \"language\": \"English-IN\"\r\n" + "}\r\n"
				+ "";
	}

	public static String addMapPutJsonRequest(String placeid) {

		return "{\r\n" + "\"place_id\":\"" + placeid + "\",\r\n" + "\"address\":\"100, HM  temple, Test City\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n" + "}\r\n" + "";

	}

	public static String responseJson() {

		return "{\r\n" + "\"dashboard\": {\r\n" + "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n" + "},\r\n" + "\"courses\": [\r\n" + "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n" + "\"price\": 50,\r\n" + "\"copies\": 6\r\n" + "},\r\n"
				+ "{\r\n" + "\"title\": \"Cypress\",\r\n" + "\"price\": 40,\r\n" + "\"copies\": 4\r\n" + "},\r\n"
				+ "{\r\n" + "\"title\": \"RPA\",\r\n" + "\"price\": 45,\r\n" + "\"copies\": 10\r\n" + "}\r\n" + "]\r\n"
				+ "}";

	}

	public static String addLibraryJson(String isbn, String aisle) {
		return "{\r\n" + "\r\n" + "\"name\":\"Adding book just to delete\",\r\n" + "\"isbn\":\"" + isbn + "\",\r\n"
				+ "\"aisle\":\"" + aisle + "\",\r\n" + "\"author\":\"Test Author\"\r\n" + "}";
	}

}
