package org.ijarvis.EpointTest.DruidMonitor;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 
 * 
 * @author liuwenru
 *
 */
public class DruidMonitorTest {
	private static Logger logger=Logger.getLogger(DruidMonitorTest.class);
	private static String url_base="http://192.168.149.150:8080/EpointTest";
	private static JsonFactory jsonFactory=new JsonFactory();
	public static void GetDruidMonitorInfo() throws IOException{
		
		OkHttpClient client = new OkHttpClient();
		Request request=new Request.Builder().url(url_base+"/druid/datasource.json").build();
		Response response=client.newCall(request).execute();
		if (response.isSuccessful()) {
			String body=response.body().string();
			JSONObject datasourcejson=new JSONObject(body);
			logger.info(datasourcejson.get("Content"));
		}
	}

}
