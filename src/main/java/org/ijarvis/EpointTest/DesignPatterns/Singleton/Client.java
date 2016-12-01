package org.ijarvis.EpointTest.DesignPatterns.Singleton;
/**
 * @author ijarvis
 *	如何使用单例模式
 */
public class Client {
	public static void main(String[] args) {
		Singleton singleton=Singleton.getSingleton();
		singleton.doSomething();
	}
}
