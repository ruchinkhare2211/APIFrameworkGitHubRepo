package org.testing.testscripts;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Properties;

import org.testing.teststeps.HTTPMethods;
import org.testing.utilities.PropertiesFileReader;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class GetRequest {

	@Test
	public static void tc002() throws Exception {
		
		Properties pr = PropertiesFileReader.propertiesFileReader();
		HTTPMethods httpMethod=new HTTPMethods(pr);
		System.out.println("****Get Request****");
		Response res=httpMethod.getRequestWithEndpointURI("friendsListURI", PostRequest.id);
		System.out.println(res.asString());
	}

}
