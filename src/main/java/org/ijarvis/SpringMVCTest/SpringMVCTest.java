package org.ijarvis.SpringMVCTest;


import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Controller
public class SpringMVCTest {
    @RequestMapping("/test")
    @ResponseBody
    public void saveTest(HttpServletRequest req, HttpServletResponse resp) throws IOException, InterruptedException, LifecycleException {
        System.out.println(req.getParameter("requestid"));
        if("null".equals(req.getParameter("requestid"))|| req.getParameter("requestid")==null){
            throw new NullPointerException();
        }
        //Thread.sleep(10000);
        for(int i=0;i<10;i++){
            //new MemleakThread(i).start();
            Thread t=new Thread(new MemleakThread(i));
            t.setDaemon(true);
            t.start();
        }
        resp.getWriter().println("Ep1111oint..*****..................");
    }
}
class MemleakThread  implements Runnable,org.apache.catalina.Executor {
    private int threadname=0;
    public MemleakThread(int name){
        this.threadname=name;
    }
    @Override
    public void run() {
        while (true){
            System.out.println("Thread-----"+this.threadname);
            try {
                Thread.sleep(3*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void execute(Runnable command, long timeout, TimeUnit unit) {

    }

    @Override
    public void execute(Runnable command) {

    }

    @Override
    public void addLifecycleListener(LifecycleListener listener) {

    }

    @Override
    public LifecycleListener[] findLifecycleListeners() {
        return new LifecycleListener[0];
    }

    @Override
    public void removeLifecycleListener(LifecycleListener listener) {

    }

    @Override
    public void init() throws LifecycleException {

    }

    @Override
    public void start() throws LifecycleException {
        System.out.println("Thread start()");
    }

    @Override
    public void stop() throws LifecycleException {
        System.out.println("Thread stop()");
    }

    @Override
    public void destroy() throws LifecycleException {
        System.out.println("Thread destroy()");
    }

    @Override
    public LifecycleState getState() {
        return null;
    }

    @Override
    public String getStateName() {
        return null;
    }
}
