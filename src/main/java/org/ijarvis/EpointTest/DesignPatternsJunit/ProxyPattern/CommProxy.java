package org.ijarvis.EpointTest.DesignPatternsJunit.ProxyPattern;
//普通代理模式的代理类

import org.apache.log4j.Logger;

public class CommProxy implements Subject {
	private static Logger logger=Logger.getLogger(CommProxy.class);
	private Subject proxy=null;
	public CommProxy(String name) {
		this.proxy=new CommRealSubject(this, name);
	}
	@Override
	public void request() {
		this.proxy.request();
	}
	

}
