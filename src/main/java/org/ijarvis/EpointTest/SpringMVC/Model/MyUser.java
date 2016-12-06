package org.ijarvis.EpointTest.SpringMVC.Model;


/**
 * Created by ijarvis on 12/6/16.
 */
public class MyUser {
    private int userid;
    private String name;
    private String pass;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
