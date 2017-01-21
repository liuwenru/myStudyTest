package org.ijarvis.EpointTest.DesignPatternsJunit.Singleton;
/**
 * @author ijarvis
 *	如何使用单例模式
 */
public class Client {
	public static void mainq(String[] args) {
		Singleton singleton=Singleton.getSingleton();
		singleton.doSomething();
	}
}
