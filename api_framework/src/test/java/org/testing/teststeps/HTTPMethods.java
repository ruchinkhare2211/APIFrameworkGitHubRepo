package org.testing.teststeps;

import java.util.Properties;
import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class HTTPMethods {

	Properties pr;
	public HTTPMethods(Properties pr) {
		this.pr = pr;
	}

	public Response postRequest(String bodyData, String URI) {
		Response res = given().contentType(ContentType.JSON).when().body(bodyData).post(pr.getProperty(URI));
		return res;
	}
	
	public Response getRequest(String URI) {
		Response res = given().contentType(ContentType.JSON).when().get(pr.getProperty(URI));
		return res;
	}
	
	public Response getRequestWithEndpointURI(String URIKey, String endPoint) {
		String URI=pr.getProperty(URIKey)+"/"+endPoint;
		Response res = given().contentType(ContentType.JSON).when().get(URI);
		return res;
	}
}
