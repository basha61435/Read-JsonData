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
		JSONParser jsonparse = new JSONParser();
		FileReader reader = new FileReader(
				"D:\\basha\\Spring Boot Projects\\json\\src\\main\\java\\com\\basha\\json\\data.json");
		JSONObject jsonobj=(JSONObject) jsonparse.parse(reader);
		printJSON((JSONObject) jsonobj);
	}
	public static void printJSON(JSONObject jsonObj) {
		List<String> jsonValues = new ArrayList<>();
		for (Object keyObj : jsonObj.keySet()) {
			String key = (String) keyObj;
			Object valObj = jsonObj.get(key);
			if (valObj instanceof JSONObject) {
				printJSON((JSONObject) valObj);
			} else {
				Pattern pattern = Pattern.compile("\\{\\{([\\w_]+)\\}\\}");
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

