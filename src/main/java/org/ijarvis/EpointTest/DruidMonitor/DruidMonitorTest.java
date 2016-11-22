package org.ijarvis.EpointTest.DruidMonitor;

import java.io.IOException;

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
	
	public static void GetDruidMonitorInfo() throws IOException{
		OkHttpClient client = new OkHttpClient();
		Request request=new Request.Builder().url("http://www.baidu.com").build();
		Response response=client.newCall(request).execute();
		if (response.isSuccessful()) {
			System.out.println(response.body().string());
		}
	}

}
