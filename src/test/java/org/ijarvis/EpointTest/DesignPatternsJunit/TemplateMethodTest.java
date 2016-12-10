package org.ijarvis.EpointTest.DesignPatternsJunit;

import org.ijarvis.EpointTest.DesignPatternsJunit.TemplateMethodPattern.HummerH1Model;
import org.ijarvis.EpointTest.DesignPatternsJunit.TemplateMethodPattern.HummerModel;
import org.junit.Test;

/**
 * Created by ijarvis on 12/10/16.
 */
public class TemplateMethodTest {
    @Test
    public void test1(){
        HummerModel hummerH1Model=new HummerH1Model();
        hummerH1Model.run();
    }
}
