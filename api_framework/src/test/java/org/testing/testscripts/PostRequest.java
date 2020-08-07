package org.testing.testscripts;

import org.testng.annotations.Test;
import java.util.Properties;
import java.util.Random;

import org.testing.response_validator.StatusCodeValidation;
import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.JsonFileReader;
import org.testing.utilities.PropertiesFileReader;
import org.testing.utilities.VariableReplacement;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class PostRequest {
	public static String id=null;
	
	@Test
	public void tc001() throws Exception {
		String body = JsonFileReader.jsonFileReader("../api_framework/src/test/java/org/testing/payloaddata/body.json");
		Random random = new Random();
		Integer idValue = random.nextInt();
		body = VariableReplacement.variableReplacement(body, "id", idValue.toString());
		Properties pr = PropertiesFileReader.propertiesFileReader();
		HTTPMethods httpMethod = new HTTPMethods(pr);
		Response res = httpMethod.postRequest(body, "friendsListURI");
		id=idValue.toString();
		System.out.println("****Post Request****");
		StatusCodeValidation.verifyData(res, "id", id);
	}
}
