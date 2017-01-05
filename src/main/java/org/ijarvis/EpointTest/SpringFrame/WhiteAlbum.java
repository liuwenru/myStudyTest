package org.ijarvis.EpointTest.SpringFrame;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class WhiteAlbum implements CompactDisc {
	
	private static final Logger logger=Logger.getLogger(WhiteAlbum.class);
	private String title="this is WhiteAlbm";
	private  String aritst="The Best";
	@Override
	public void play() {
		logger.debug(this.title+"----------"+this.aritst);
	}
	
}
