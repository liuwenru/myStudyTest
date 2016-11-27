package org.ijarvis.EpointTest.SpringFrame;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {

	private String title="this is a music title............";
	private String arites="The Beatles!!!!!!";
	private static final Logger logger=Logger.getLogger(SgtPeppers.class);
	@Override
	public void play() {
		logger.debug(title+"-------------------"+arites);
	}
	
	
}
