package org.okarmus.game.configuration;

import java.util.concurrent.atomic.AtomicInteger;

import org.okarmus.game.manager.distribution.builder.DistributionBuilder;
import org.okarmus.game.manager.game.builder.GameBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
	
	@Bean
	public AtomicInteger gameSequence() {
		return new AtomicInteger(1);
	}
	
	@Bean
	public GameBuilder gameBuilder() {
		return new GameBuilder();
	}

	@Bean
	public DistributionBuilder distributionBuilder() {
		return new DistributionBuilder();
	}	
}
