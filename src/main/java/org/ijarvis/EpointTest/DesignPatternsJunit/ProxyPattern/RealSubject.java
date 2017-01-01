package org.ijarvis.EpointTest.DesignPatternsJunit.ProxyPattern;

import org.apache.log4j.Logger;

public class RealSubject implements Subject {
	private Logger logger=Logger.getLogger(RealSubject.class);
	@Override
	public void request() {
		// TODO Auto-generated method stub
		logger.debug("我是具体干活的，，，，我是苦逼。。。。");
	}
}
