package org.testing.utilities;

import java.util.regex.Pattern;

public class VariableReplacement {
	
	public static String variableReplacement(String body, String variableName, String value) {
		body=body.replaceAll(Pattern.quote("{{"+variableName+"}}"), value);
		return body;
	}

}
