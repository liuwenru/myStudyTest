package org.ijarvis.EpointTest.Jredis;
import redis.clients.jedis.Jedis;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * Created by ijarvis on 12/5/16.
 */
public class JedisUntils {

    private  static  final  String host="192.168.202.17";
    private  static  final  int port=6379;
    private static  final  HashMap<String,Integer> AccCount=new HashMap<String,Integer>();
    private  static  final  String hashmap_keys="985189ae-91f0-4e4a-8a2e-e2666f428deb_02be7e95-9385-4482-a993-9e6a83b7466b_URLS_INFO_DAY";
    public  static  void  main(String[] args){
        Long start=System.currentTimeMillis();
        Jedis jedis = new Jedis(host,port);
        jedis.select(0);
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        String value1=jedis.hget("985189ae-91f0-4e4a-8a2e-e2666f428deb_02be7e95-9385-4482-a993-9e6a83b7466b_URLS_INFO_DAY","/abc_City_Jinan");
        System.out.println(jedis.hgetAll(hashmap_keys).keySet());

        Map<String,String> AccessMap=jedis.hgetAll(hashmap_keys);
        Set<String>  urlSet= AccessMap.keySet();
        for ( String tmp : urlSet) {
            if (tmp.contains("Province")){
                    String[] urlarray=tmp.split("_");
                    String City=urlarray[urlarray.length-1];
                    System.out.println(City);
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
