package org.ijarvis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by liuwenru on 2017/2/20.
 */
//@Controller
//
public class Apps {
   public static void main(String args[]) throws IOException {
       URL url = new URL(args[0]);
       HttpURLConnection urlcon = (HttpURLConnection)url.openConnection();
       urlcon.connect();         //获取连接
       InputStream is = urlcon.getInputStream();
       BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
       StringBuffer bs = new StringBuffer();
       String l = null;
       while((l=buffer.readLine())!=null){
           bs.append(l).append("/n");
       }
       System.out.println(bs.toString());
   }
}
