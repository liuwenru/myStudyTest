package org.ijarvis.EpointTest.JVMJunit;

/**
 * Created by ijarvis on 12/25/16.
 * 测试JVM的虚拟机栈和本地方法栈溢出
 *
 */
public class JavaVMStackSOF {
    private int stackLength=1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args){
        JavaVMStackSOF oom=new JavaVMStackSOF();
        try{
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:"+oom.stackLength);
            throw e;
        }
    }


}
