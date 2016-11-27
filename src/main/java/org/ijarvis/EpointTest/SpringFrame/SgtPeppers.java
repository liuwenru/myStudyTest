package org.ijarvis.EpointTest.SpringFrame;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Created by ijarvis on 11/27/16.
 */
@Component
public class SgtPeppers implements  CompactDisc{
    private  static final Logger logger=Logger.getLogger(SgtPeppers.class);
    private  String title="Sgt. Pepper's Lonely Hears Club Band";
    private  String aritst="The Best";
    @Override
    public void play() {
        logger.debug(this.title+"--------------"+this.aritst);
    }
}
