package org.ijarvis.EpointTest.JDKStudy;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

import org.apache.log4j.Logger;

/**
 * 
 * @author ijarvis
 * 该处重点讲解一些一下在JDK中时间的处理方法
 */
public class DateTest {
	private static Logger logger=Logger.getLogger(DateTest.class);
	public static void mainq(String[] args){
		Instant start=Instant.now();
		
		logger.debug(start);
		Instant addInstant= start.plusSeconds(10);
		Instant delInstant= start.minusSeconds(10);
		logger.debug(addInstant);
		logger.debug(delInstant);
		LocalDate today=LocalDate.now();
		
		logger.debug(today);
		
		LocalDate nextdate= today.plusWeeks(1);
		logger.debug(nextdate);
		
		logger.debug(LocalDate.of(2017, 1, 30).plusDays(2));
	}
	
	

}
