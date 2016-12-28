package org.ijarvis.EpointTest.Jredis;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by liuwenru on 2016/12/20.
 */
public class JredisJunitTest {
    @Ignore
    @Test
    public void  Test(){
        JredisClusterUtils.ClusterTest();
    }
    @Test
    public void  TestCluster()
    {
        JedisUntils.TestRedisCluster();
    }
}
