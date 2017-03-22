package org.ijarvis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by 11255 on 2017/3/21.
 */
public class JredisTest {
    public  static  void  main(String[] args){
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        //Jedis Cluster will attempt to discover cluster nodes automatically
        jedisClusterNodes.add(new HostAndPort("192.168.208.31", 6379));
        jedisClusterNodes.add(new HostAndPort("192.168.208.31", 6380));
        jedisClusterNodes.add(new HostAndPort("192.168.208.31", 6381));
        jedisClusterNodes.add(new HostAndPort("192.168.208.32", 6382));
        jedisClusterNodes.add(new HostAndPort("192.168.208.32", 6383));
        jedisClusterNodes.add(new HostAndPort("192.168.208.32", 6384));
        JedisCluster jc = new JedisCluster(jedisClusterNodes);
        Map<String,JedisPool> clusters= jc.getClusterNodes();
        System.out.print(clusters);
        for (Map.Entry<String,JedisPool> entry: clusters.entrySet()){
            System.out.println(entry.getKey()+"--------"+entry.getValue());
        }
        System.out.println("集群节点个数为："+clusters.keySet().size());
        jc.set("foo", "bar");
        String value = jc.get("foo");
        System.out.print("------------"+value+"--------------");
    }
}
