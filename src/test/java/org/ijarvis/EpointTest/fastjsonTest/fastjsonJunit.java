package org.ijarvis.EpointTest.fastjsonTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by ijarvis on 12/30/16.
 */
public class fastjsonJunit {
    private  static Logger logger=Logger.getLogger(fastjsonJunit.class);
    class pojo{
        private String a;
        private int b;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }

    @Test
    public void ObjectToJSON(){


        // Encode
        pojo tmp1=new pojo();
        tmp1.setA("a");
        tmp1.setB(1);
        pojo tmp2=new pojo();
        tmp2.setA("b");
        tmp2.setB(2);
        List<pojo> tmplist=new ArrayList<pojo>();
        tmplist.add(tmp1);
        tmplist.add(tmp2);
        //logger.debug(JSON.toJSON(tmp1));
//        logger.debug(JSON.toJSON(tmplist));
        //Decode

        String arry="[\"aa\",\"bb\"]";
        List<String> arrys=new ArrayList<>();
        JSON.parse(arry);
        List<String> list = JSON.parseObject(arry, new TypeReference<List<String>>() {});
        for(int i=0;i<list.size();i++){
            logger.debug(list.get(i));

        }
    }
}
