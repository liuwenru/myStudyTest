package org.ijarvis.EpointTest.Weblogic;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by ijarvis on 11/29/16.
 */
public class MyException extends  Exception {

    public  void  printStackTrace(){

        try {
            System.out.println("------------------------");
            super.printStackTrace(new PrintStream(System.out,true,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            //e.printStackTrace();
        }
    }
}
