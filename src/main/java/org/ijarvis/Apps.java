package org.ijarvis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuwenru on 2017/2/20.
 */
//@Controller
//
public class Apps {
    public Apps(String name)
    {
        this.name=name;
    }
    private String name;
    public static void main(String[] args) {
        Map<Apps,String> map = new HashMap<Apps,String>();
        map.put(new Apps("Shamik"), "Shamik Mitra");
        String val = map.get(new Apps("Shamik"));
        System.out.println("Missing equals and hascode so value is not accessible from Map " + val);
    }
}
