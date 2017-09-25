package com.spring.rest.emprofile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.spring.rest.domain.Position;

public class JsonUtil {
	
	
	public static String convertPositionAsJson(Position position ) throws JsonProcessingException{
		String result=null;
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure( SerializationFeature.WRAP_ROOT_VALUE , false);
		ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
		
		return objectWriter.writeValueAsString(position );
	}
}
