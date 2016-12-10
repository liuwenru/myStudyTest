package org.ijarvis.EpointTest.DesignPatternsJunit.TemplateMethodPattern;

import org.apache.log4j.Logger;

/**
 * Created by ijarvis on 12/10/16.
 */
public class HummerH1Model extends HummerModel {
    private static final Logger logger=Logger.getLogger(HummerH1Model.class);
    @Override
    public void start() {
        logger.info("HummerH1Model1.......Start...........");
    }

    @Override
    public void stop() {
        logger.info("HummerH1Model1.......Stop...........");
    }

    @Override
    public void alarm() {
        logger.info("HummerH1Model1.......alarm..bibibibibi....");
    }

    @Override
    public void engineBoom() {
        logger.info("HummerH1Model1.......engineBoom..boom1....");
    }

    @Override
    public boolean isAlarm() {
        return true;
    }
}
