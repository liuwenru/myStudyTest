package org.ijarvis.SpringQuartzApps;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.concurrent.TimeUnit;

public class SpringQuartz extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("Job 1 ..........");

    }
}