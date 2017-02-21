package org.ijarvis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuwenru on 2017/2/20.
 */
@Controller
@RequestMapping("/index")
public class Apps {

    static  class  OOMObject{
        public  byte[] plac=new byte[64*1024];
    }
    @RequestMapping("/home")
    public String hello(@RequestParam(name = "lenth") int num) throws InterruptedException {
        List<OOMObject> list=new ArrayList<OOMObject>();
        for (int i=0;i<=num;i++){
            Thread.sleep(50);
            list.add(new OOMObject());
            System.gc();
        }
        return "hello";
    }


    @RequestMapping("/loop")
    public void loop(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(5000);
                        System.out.print("aaaaaaaaaaaaaaaaaaaaa");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
