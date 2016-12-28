package org.ijarvis.EpointTest;

import org.apache.log4j.lf5.viewer.TrackingAdjustmentListener;
import org.bson.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DBObject;

public class MyTest {
	public static void main(String[] args) throws JsonProcessingException {
		Document temp= new Document();
		temp.put("id", "11111");
		temp.put("name", "11111");
		ObjectMapper mapper = new ObjectMapper();  
		String Json =  mapper.writeValueAsString(temp);
		System.out.println(Json);
		
	}

}
