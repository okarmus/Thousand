package org.okarmus.game.configuration;

import org.okarmus.game.model.builder.GameBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
	
	@Bean
	public GameBuilder gameBuilder() {
		return new GameBuilder();
	}

}
