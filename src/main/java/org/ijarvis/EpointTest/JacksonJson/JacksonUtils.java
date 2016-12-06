package org.ijarvis.EpointTest.JacksonJson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by ijarvis on 12/6/16.
 */
public class JacksonUtils {

    private  static String jsonFile="";
    private  static File file=null;
    private  static JsonNode jsonNode=null;
    private static final ObjectMapper objMapper = new ObjectMapper();;
    public  JacksonUtils(String filepath) throws IOException {
        file=new File(jsonFile);
        jsonNode=objMapper.readTree(file);
    }
}
