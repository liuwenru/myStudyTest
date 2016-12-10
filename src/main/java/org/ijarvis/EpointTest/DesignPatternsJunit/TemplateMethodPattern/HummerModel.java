package org.ijarvis.EpointTest.DesignPatternsJunit.TemplateMethodPattern;

import org.apache.log4j.Logger;

/**
 * Created by ijarvis on 12/10/16.
 * 悍马车型的抽象类，所有的新的悍马都需要继承至该类的
 */
public abstract class HummerModel {
    /**
     * 在这个类中去定义一些悍马车型的特征，至于每一个悍马系列的特性则在具体类中去实现
     */
    private static final Logger logger=Logger.getLogger(HummerModel.class);
    //启动汽车
    protected abstract void start();
    //停止汽车
    protected abstract void stop();
    //汽车按喇叭
    protected abstract void alarm();
    //引擎轰隆隆的作响
    protected abstract void engineBoom();
    //启动起步跑起来
    public void run(){
        this.start();
        this.engineBoom();
        if (this.isAlarm()==true){
            this.alarm();
        }
        logger.info("........HummerModel.....running.........");
        this.stop();
    };
    public boolean isAlarm(){
        return false;
    };
}
