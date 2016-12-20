package org.ijarvis.EpointTest.Jredis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liuwenru on 2016/12/19.
 * 测试Redis的集群测试效果
 *
 *
 */
public class JredisClusterUtils {
    public static void ClusterTest(){
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        //Jedis Cluster will attempt to discover cluster nodes automatically
        jedisClusterNodes.add(new HostAndPort("192.168.149.152", 6379));
        jedisClusterNodes.add(new HostAndPort("192.168.149.153", 6379));
        jedisClusterNodes.add(new HostAndPort("192.168.149.154", 6379));
        JedisCluster jc = new JedisCluster(jedisClusterNodes);
        jc.set("foo", "bar");
        String value = jc.get("foo");
    }
}
