package org.testing.testscripts;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Properties;

import org.testing.response_validator.StatusCodeValidation;
import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.PropertiesFileReader;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class GetRequestTC002 {

	@Test
	public static void tc003() throws Exception { 
		Properties pr = PropertiesFileReader.propertiesFileReader();
		HTTPMethods httpMethods = new HTTPMethods(pr);
		Response res = httpMethods.getRequest("friendsListURI");
		StatusCodeValidation.verifyStatusCode(res, 200);
		StatusCodeValidation.verifyData(res, "[5].firstname", "Ruchin");
	}
}
