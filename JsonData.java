package com.basha;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class JsonData {
	public static void main(String[] args) throws IOException, ParseException {
		// create jsonparser object
		JSONParser jsonparse = new JSONParser();
		FileReader reader = new FileReader(
				"D:\\basha\\Spring Boot Projects\\json\\src\\main\\java\\com\\basha\\json\\data.json");
		// jsonparser class contains a parse method it return json object and json array
		JSONObject jsonobj=(JSONObject) jsonparse.parse(reader);
		// call the printJson method
		printJSON((JSONObject) jsonobj);
	}
	public static void printJSON(JSONObject jsonObj) {
		List<String> jsonValues = new ArrayList<>();
		for (Object keyObj : jsonObj.keySet()) {
			// get a key values from json object
			String key = (String) keyObj;
			// get a values from json object
			Object valObj = jsonObj.get(key);
			//check the value are object are not
			if (valObj instanceof JSONObject) {
				// if it is a object again call to printJson method
				printJSON((JSONObject) valObj);
			} else {
				// if it is not a object write your required login 
				// pattern in used to create a pattern 
				Pattern pattern = Pattern.compile("\\{\\{([\\w_]+)\\}\\}");
				// matcher class is match the out pattern to the input
				Matcher matcher = pattern.matcher(valObj.toString());
				while(matcher.find())
				{
					String var1 = matcher.group(1);
					jsonValues.add(var1);
				}
			}
		}
		for (String values : jsonValues) {
			System.out.println(values);
		}
	}
}

