package org.ijarvis.EpointTest.DesignPatternsJunit;

import org.ijarvis.EpointTest.DesignPatternsJunit.ProxyPattern.Proxy;
import org.ijarvis.EpointTest.DesignPatternsJunit.ProxyPattern.RealSubject;
import org.junit.Test;

/**
 * 
 * @author ijarvis
 * 代理类的测试方法
 */
public class ProxyPatternTest {
	@Test
	public void ProxyClient(){
		RealSubject work=new RealSubject();
		Proxy proxy=new Proxy(work);
		proxy.request();
	}
}
