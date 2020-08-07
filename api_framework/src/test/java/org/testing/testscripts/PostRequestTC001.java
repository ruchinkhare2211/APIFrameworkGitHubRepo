package org.testing.testscripts;

import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.testing.response_validator.StatusCodeValidation;
import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.JsonFileReader;
import org.testing.utilities.PropertiesFileReader;
import org.testing.utilities.VariableReplacement;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class PostRequestTC001 {
	
	@Test
	public static void tc002() throws Exception {
		
		String body = JsonFileReader.jsonFileReader("../api_framework/src/test/java/org/testing/payloaddata/body.json");
		Random r = new Random();
		Integer value = r.nextInt();
		body = VariableReplacement.variableReplacement(body, "id", value.toString());
		Properties pr = PropertiesFileReader.propertiesFileReader();
		HTTPMethods http = new HTTPMethods(pr);
		Response res = http.postRequest(body, "friendsListURI");
		System.out.println("BODY DATA");
		System.out.println(res.asString());
		StatusCodeValidation.verifyStatusCode(res, 201);
		StatusCodeValidation.verifyData(res, "id", value.toString());
	}
}
