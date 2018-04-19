package org.ijarvis.jvm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ijarvis on 2017/5/28.
 *
 * 测试内存溢出的错误
 */
@Controller
@RequestMapping("/jvm")
public class OOMTest {
    static class OOMObject{
        private String name="aaaaaaaaaaaaaaaaaaaaaaaaa";
    }
    @RequestMapping("/oom")
    public String oom(){
        List<OOMObject> list=new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }

}
