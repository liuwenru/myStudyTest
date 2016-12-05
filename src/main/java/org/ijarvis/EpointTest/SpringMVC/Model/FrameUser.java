package org.ijarvis.EpointTest.SpringMVC.Model;

/**
 * Created by ijarvis on 12/4/16.
 */
public class FrameUser {
    private  String userguid;
    private  String loginid;
    private  String password;

    public String getUserguid() {
        return userguid;
    }

    public void setUserguid(String userguid) {
        this.userguid = userguid;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
