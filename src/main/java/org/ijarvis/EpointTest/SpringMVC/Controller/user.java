package org.ijarvis.EpointTest.SpringMVC.Controller;

import org.springframework.stereotype.Component;

/**
 * Created by ijarvis on 12/4/16.
 */

class  user{

    private  String name;
    private  String pass;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public  user(){

    }
    public user(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }
}
