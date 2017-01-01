package org.ijarvis.EpointTest.DesignPatternsJunit.ProxyPattern;
import org.apache.log4j.Logger;
public class Proxy implements Subject{
	private static Logger logger=Logger.getLogger(Proxy.class);
	private Subject subject=null;//定义需要代理的对象
	public Proxy() {
		// TODO 设置默认的代理类
		this.subject=new Proxy();
	}
	public Proxy(Subject RealSubject){
		this.subject=RealSubject;
	}
	//定义干活的套路
	@Override
	public void request() {
		// TODO Auto-generated method stub
		this.before();
		this.subject.request();
		this.after();
	}
	//预处理
	public void before(){
		logger.debug("代理类正在预处理一些事情............Start.......");
		logger.debug("代理类正在预处理一些事情............End.......");
	}
	public void after(){
		logger.debug("代理类正在善后一些事情..............Start......");
		logger.debug("代理类正在善后一些事情..............End......");
	}
}
