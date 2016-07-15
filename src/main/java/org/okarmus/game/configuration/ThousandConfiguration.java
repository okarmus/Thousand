package org.okarmus.game.configuration;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.okarmus.game.manager.distribution.pile.CardRandomizer;
import org.okarmus.game.manager.distribution.pile.CardsPile;
import org.okarmus.game.manager.game.builder.GameBuilder;
import org.okarmus.game.model.card.Card;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ThousandConfiguration {
	
	@Bean
	public AtomicInteger gameSequence() {
		return new AtomicInteger(1);
	}
	
	@Bean
	public GameBuilder gameBuilder() {
		return new GameBuilder();
	}
	
	@Bean
	@Scope("prototype")
	public CardsPile cardsPile(List<Card> cards) {	
		return new CardsPile(cards);
	}
	
	@Bean
	public CardRandomizer cardRandomizer() {
		return new CardRandomizer(new Random(), 24);	//TODO this value should be taken from properties(??)
	}
}
