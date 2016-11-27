package org.ijarvis.EpointTest.SpringFrame;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayJavaConfig {

	@Bean
	public CompactDisc sgtPeppers(){
		
		return new SgtPeppers();
	}
}
