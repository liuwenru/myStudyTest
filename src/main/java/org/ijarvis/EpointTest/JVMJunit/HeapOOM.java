package org.ijarvis.EpointTest.JVMJunit;

import java.util.ArrayList;
import java.util.List;

/*
 * 测试JVM的OOM
 * 设置对内存的大小，阻止其动态拓展
 * 
 * Args= -Xms20m -Xmx20m -XX:+HeapDumpOnOutofMemoryError
 */
public class HeapOOM {
	static class OOMObject{
	}
	public static void main(String[] args) {
		List<OOMObject> list=new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}
}
