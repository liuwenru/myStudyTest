package org.ijarvis.EpointTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.bson.Document;

public class MainClassTest {
	public static void main(String[] args) throws UnknownHostException {
		String IP= InetAddress.getLocalHost().getHostAddress();
		System.out.println(IP);
		
		String queryStr=" {aggregate:\"05b6e44d-11ce-4efe-ab42-f01b2708dd58.access.log.json\",pipeline: [{$group: {id:\"$value.geoip2_data_subdivisions_name\",count:{$sum:1}}}],}";
		Document document=Document.parse(queryStr);
		System.out.println(document);
		
		
		
		
	}
}
