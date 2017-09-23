package com.jsonpath.examples;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class JSONPathBookExample {

	public static void main(String[] args) throws IOException {
		String json = "C:\\devenv\\gitrepos\\jasdhali\\javamisc\\JsonPath-examples\\src\\main\\resources\\books.json";
		//String json = "../resources/books.json";
		File jsonFile = new File(json);
		List<String> authors = JsonPath.read( jsonFile , "$.store.book[*].author");
		System.out.println("$.store.book[*].author");
		authors.forEach( System.out::println );
		
		List<String> allAuthors = JsonPath.read( jsonFile , "$..author");
		System.out.println("$..author");
		allAuthors.forEach( System.out::println );
		
		//$.store.*	All things, both books and bicycles
		
		List<Object> allThings = JsonPath.read( jsonFile , "$.store.*");
		System.out.println("$.store.*");
		allThings.forEach( System.out::println );
		String  jsonCust = "{\"firstName\": \"Jack\",\"lastName\": \"Smith\"}";
		String firstName = JsonPath.read( jsonCust , "$.firstName");
		System.out.println( " firstName====>>>> " + firstName );
		
	}

}
