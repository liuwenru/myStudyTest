package org.ijarvis.EpointTest.Jredis;
import redis.clients.jedis.Jedis;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * Created by ijarvis on 12/5/16.
 */
public class JedisUntils {

    private  static  final  String host="192.168.149.234";
    private  static  final  int port=6379;
    private static  final  HashMap<String,Integer> AccCount=new HashMap<String,Integer>();
    private  static  final  String hashmap_keys="TEST_MAP1";
    public  static  void  main(String[] args){
        Long start=System.currentTimeMillis();
        Jedis jedis = new Jedis(host,port);
        jedis.select(0);
        System.out.println(jedis.hgetAll(hashmap_keys).keySet());
        Map<String,String> AccessMap=jedis.hgetAll(hashmap_keys);
        Set<String>  urlSet= AccessMap.keySet();
        for ( String tmp : urlSet) {
            if (tmp.contains("City")){
                    String[] urlarray=tmp.split("_");
                    String City=urlarray[urlarray.length-1];
                    //System.out.println(City);
                    if (AccCount.keySet().contains(City)){
                        AccCount.put(City,AccCount.get(City)+Integer.parseInt(AccessMap.get(tmp)));
                    }else {
                        AccCount.put(City,Integer.parseInt(AccessMap.get(tmp)));
                    }
            }
        }
        System.out.println(AccCount);
        Long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
