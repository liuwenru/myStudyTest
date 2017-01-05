package org.ijarvis.EpointTest.DesignPatternsJunit.ProxyPattern;

import org.apache.log4j.Logger;


//普通代理模式的具体干活类

public class CommRealSubject implements  Subject {
	private static Logger logger=Logger.getLogger(CommRealSubject.class);
	private String name="";
	@Override
	public void request() {
		logger.debug("我是具体干活的，，，，很苦逼.............----------"+this.name);
	}
	
	public CommRealSubject(Subject _proxyObject,String name) {
		if (_proxyObject == null) {
			// TODO 可以在这里设计设计一些代理类的限制信息,例如至能够由类名为proxy的类此才能够代理
			logger.error("对不起，不能够对该类进行代理...........");
		}else{
			logger.debug("正在构造对象进行处理...................");
			this.name=name;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
