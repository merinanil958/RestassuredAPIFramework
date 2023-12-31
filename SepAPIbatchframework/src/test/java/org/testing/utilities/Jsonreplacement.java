package org.testing.utilities;

import java.util.regex.Pattern;

public class Jsonreplacement {
	public static String JsonVariableAssign(String requestBody,String VariableName,String variableValue)
	{
		requestBody=requestBody.replaceAll(Pattern.quote("{{"+VariableName+"}}"), variableValue);
		return requestBody;
	}
	

}
