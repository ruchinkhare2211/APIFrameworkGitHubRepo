package org.testing.response_validator;

import com.jayway.restassured.response.Response;

public class StatusCodeValidation {

	public static void verifyStatusCode(Response res, Integer exceptedResult) {
		if (res.getStatusCode() == exceptedResult) {
			System.out.println("Actual response code i.e.; '" + res.getStatusCode()
					+ "' is matching with Expected Response code i.e.; '" + exceptedResult+"'");
		} else {
			System.out.println("Actual response code i.e.; '" + res.getStatusCode()
			+ "' is not matching with Expected Response code i.e.; '" + exceptedResult+"'");
		}
	}
	
	public static void verifyData(Response res, String jsonPath, String expectedResult) {
		if (res.jsonPath().get(jsonPath).equals(expectedResult)) {
			System.out.println("Actual data i.e.; '" + res.jsonPath().get(jsonPath)
					+ "' is matching with Expected data i.e.; '" + expectedResult+"'");
		} else {
			System.out.println("Actual data i.e.; '" + res.jsonPath().get(jsonPath)
					+ "' is matching with Expected data i.e.; '" + expectedResult+"'");
		}
	}


}
