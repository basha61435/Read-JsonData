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

public class Json_Data {
	public static void main(String[] args) throws IOException, ParseException {
		JSONParser jsonparse = new JSONParser();
		FileReader reader = new FileReader(
				"D:\\basha\\Spring Boot Projects\\json\\src\\main\\java\\com\\basha\\json\\data.json");
//		Object obj = jsonparse.parse(reader);
//		JSONObject jsonobj = (JSONObject) obj;
		JSONObject jsonobj=(JSONObject) jsonparse.parse(reader);
		printJSON((JSONObject) jsonobj);
	}
	public static void printJSON(JSONObject jsonObj) {
		List<String> jsonValues = new ArrayList<>();
		
		for (Object keyObj : jsonObj.keySet()) {
			String key = (String) keyObj;
			Object valObj = jsonObj.get(key);

			if (valObj instanceof JSONObject) {
				// call printJSON on nested object
				printJSON((JSONObject) valObj);
			} else {
				// print key-value pair

				// System.out.println("key : "+key);
				// System.out.println("value : "+valObj.toString());
				Pattern pattern = Pattern.compile("\\{\\{([\\w_]+)\\}\\}");
				Matcher matcher = pattern.matcher(valObj.toString());
				while(matcher.find())
				{
					String var1 = matcher.group(1);
//					System.out.println(String.format("group1 : %s", var1));
						String s=matcher.group();
//						String validData="";
//						validData=s.replaceAll("\\{|\\}", "");
//						for(int i=2;i<s.length()-2;i++)
//						{
//							validData=validData+s.charAt(i);
//						}
						
					jsonValues.add(var1);
				}
//				jsonValues.add(valObj.toString());
				
			}
		}
		
		for (String values : jsonValues) {
//			String jsonValuesData = values;
//			Pattern pattern = Pattern.compile("(?<=[{{]).*?(?=}})");
//			Matcher matcher = pattern.matcher(jsonValuesData);
//			while (matcher.find()) {
//				String match = matcher.group();
//				System.out.println(match);
//			}
			System.out.println(values);

		}
	}
}
