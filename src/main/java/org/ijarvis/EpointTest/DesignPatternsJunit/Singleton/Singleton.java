package org.ijarvis.EpointTest.DesignPatternsJunit.Singleton;

/**
 * Created by ijarvis on 11/30/16.
 * 
 * 单例模式
 * 
 * 说白了就是让程序在运行过程中能够始终获取到一个对象
 */
public class Singleton {
	private static Singleton singleton = new Singleton();
	private Singleton(){
	}
	public static Singleton getSingleton(){
		if (singleton==null) {
			singleton=new Singleton();
			return singleton;
		}
		return singleton;
	}
	public static void doSomething(){
		//TODO 实现一些单例模式下需要做的事情
		System.out.println("我是单例模式做的事情................");
	}
}
