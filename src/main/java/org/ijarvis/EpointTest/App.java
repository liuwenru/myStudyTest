package org.ijarvis.EpointTest;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
@RestController
@EnableAutoConfiguration
public class App 
{
    @RequestMapping("/")
    List<String> home() {
    	List<String> arr=new ArrayList<>();
    	arr.add("aaaa");
    	arr.add("bbb");
        return arr;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }

}
