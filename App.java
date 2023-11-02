package com.basha;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App 
{
    public static void main( String[] args ) throws IOException, ParseException
    {
    	JSONParser jsonparse=new JSONParser();
    	FileReader reader=new FileReader("D:\\basha\\Spring Boot Projects\\json\\src\\main\\java\\com\\basha\\json\\data.json");
    	Object obj=jsonparse.parse(reader);
    	JSONObject jsonobj=(JSONObject)obj;
    	printJSON((JSONObject) jsonobj);
    	
//    	JSONObject idpet=(JSONObject)jsonobj.get("ipdet");
//    	String p1=(String)idpet.get("p1");
//    	System.out.println(p1);
//    	Pattern pattern = Pattern.compile("(?<=[{{]).*?(?=}})");
//    	Matcher matcher = pattern.matcher(p1);
//    	while (matcher.find()) {
//    	    String match = matcher.group();
//    	    System.out.println(match);
//    	}
//    	String arr[]=p1.split(" ");
//    	List<String> mainContent=new ArrayList<>();
//    	for(String a:arr)
//    	{
//   		String content=a;
//   		if(content.startsWith("{{")&& content.endsWith("}}"))
//   		{
//   			String s="";
//   			for(int i=2;i<content.length()-2;i++)
//   			{
//   				
//   				char b=content.charAt(i);
//   				s=s+b;
//   			}
//   			mainContent.add(s);
//   			
//   		}
//    		
//    	}
//    	for(String main:mainContent)
//    	{
//    	System.out.println("main data "+main);	
//    	}
//    	
    	
    }
    

public static Set<String> printJSON(JSONObject jsonObj) {
	Set<String> jsonKeys=new HashSet<>();
for (Object keyObj : jsonObj.keySet()) {
String key = (String)keyObj;
Object valObj = jsonObj.get(key);

if (valObj instanceof JSONObject) {
// call printJSON on nested object
printJSON((JSONObject) valObj);
} else {
// print key-value pair
//	return key;
//System.out.println("key : "+key);
//System.out.println("value : "+valObj.toString());
	jsonKeys.add(valObj.toString());
}


}
for(String keys:jsonKeys)
{
	String jsonValues=keys;
	Pattern pattern = Pattern.compile("(?<=[{]).*?(?=}})");
	Matcher matcher = pattern.matcher(jsonValues);
	while (matcher.find()) {
	    String match = matcher.group();
	    System.out.println(match);
	}
	
}

return jsonKeys;

}
}

