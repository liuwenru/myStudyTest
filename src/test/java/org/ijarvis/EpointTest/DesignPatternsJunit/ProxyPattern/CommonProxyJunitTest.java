package org.ijarvis.EpointTest.DesignPatternsJunit.ProxyPattern;
//普通代理类的客户端

import org.junit.Test;

public class CommonProxyJunitTest {
	@Test
	public void CommonProxyClientTest(){
		Subject CommonProxy=new CommProxy("ijarvis");
		CommonProxy.request();
	}
}
