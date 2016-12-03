package org.ijarvis.EpointTest.JVM;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/*
 * 测试JVM的OOM
 * 设置对内存的大小，阻止其动态拓展
 * 
 * Args= -Xms20m -Xmx20m -XX:+HeapDumpOnOutofMemoryError
 */
public class JVMJunitTest {
	static class OOMObject{
	}
	@Test
	public void HeapOOMTest(){
		List<OOMObject> list=new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}

}