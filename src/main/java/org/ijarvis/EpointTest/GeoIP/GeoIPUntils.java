package org.ijarvis.EpointTest.GeoIP;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by ijarvis on 12/5/16.
 */
public class GeoIPUntils {
    private  static  final Map<String,String> CityMap=null;
    static {

    }

    public  static  void  mainq(String[] args) throws IOException {
        String strText = "/home/ijarvis/Documents/workspace/EpointTest/src/main/resources/province_EN2CN.txt";
        ObjectMapper objMapper = new ObjectMapper();
        JsonNode rootNode = objMapper.readTree(new File(strText));

        // 获得 json 字符串
        String strResult = rootNode.toString();
        System.out.println(strResult);
        System.out.println(rootNode.get(12).get(0));


    }

}
