package com.jsonpath.examples;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JSONPathBaeldungExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JSONPathBaeldungExample baeldungExample = 
				new JSONPathBaeldungExample();
		baeldungExample.run();
	}
	private String jsonpathCreatorNamePath = "$['tool']['jsonpath']['creator']['name']";
	private String jsonpathCreatorLocationPath = "$['tool']['jsonpath']['creator']['location'][*]";
	public void run() throws IOException{
		if( getInputStreamFromJsonResource()!=null){
			System.out.println("Got resource...");
		}
		else {
			System.out.println("Exception or error");
		}
		List<String> authors = JsonPath.read( getInputStreamFromJsonResource() , "$.book[*].title");
		authors.forEach( System.out::println );
		
		DocumentContext jsonContext = JsonPath.parse( getInputStreamFromJsonResource() );
		String creatorName = jsonContext.read( "$['tool']['jsonpath']['creator']['name']");
		if( creatorName!=null){
			System.out.println(creatorName);
		}
	}
	
	private InputStream getInputStreamFromJsonResource(){
		return this.getClass().getClassLoader().getResourceAsStream("baeldung.json");
	}
}
