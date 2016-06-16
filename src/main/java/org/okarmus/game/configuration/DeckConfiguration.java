package org.okarmus.game.configuration;

import org.okarmus.game.model.card.Card;
import org.okarmus.game.model.card.CardDeck;
import org.okarmus.game.model.card.Color;
import org.okarmus.game.model.card.Figure;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeckConfiguration {
	
	@Bean
	public Card nineOfClubs() {
		return new Card(Color.CLUBS, Figure.NINE);
	}
	
	@Bean
	public Card nineOfDiamonds() {
		return new Card(Color.DIAMONDS, Figure.NINE);
	}
	
	@Bean
	public Card nineOfHearts() {
		return new Card(Color.HEARTS, Figure.NINE);
	}
	
	@Bean
	public Card nineOfSpades() {
		return new Card(Color.SPADES, Figure.NINE);
	}
	
	@Bean
	public Card tenOfClubs() {
		return new Card(Color.CLUBS, Figure.TEN);
	}
	
	@Bean
	public Card tenOfDiamonds() {
		return new Card(Color.DIAMONDS, Figure.TEN);
	}
	
	@Bean
	public Card tenOfHearts() {
		return new Card(Color.HEARTS, Figure.TEN);
	}
	
	@Bean
	public Card tenOfSpades() {
		return new Card(Color.SPADES, Figure.TEN);
	}
	
	@Bean
	public Card jackOfClubs() {
		return new Card(Color.CLUBS, Figure.JACK);
	}
	
	@Bean
	public Card jackOfDiamonds() {
		return new Card(Color.DIAMONDS, Figure.JACK);
	}
	
	@Bean
	public Card jackOfHearts() {
		return new Card(Color.HEARTS, Figure.JACK);
	}
	
	@Bean
	public Card jackOfSpades() {
		return new Card(Color.SPADES, Figure.JACK);
	}
	
	@Bean
	public Card queenOfClubs() {
		return new Card(Color.CLUBS, Figure.QUEEN);
	}
	
	@Bean
	public Card queenOfDiamonds() {
		return new Card(Color.DIAMONDS, Figure.QUEEN);
	}
	
	@Bean
	public Card queenOfHearts() {
		return new Card(Color.HEARTS, Figure.QUEEN);
	}
	
	@Bean
	public Card queenOfSpades() {
		return new Card(Color.SPADES, Figure.QUEEN);
	}
	
	@Bean
	public Card kingOfClubs() {
		return new Card(Color.CLUBS, Figure.KING);
	}
	
	@Bean
	public Card kingOfDiamonds() {
		return new Card(Color.DIAMONDS, Figure.KING);
	}
	
	@Bean
	public Card kingOfHearts() {
		return new Card(Color.HEARTS, Figure.KING);
	}
	
	@Bean
	public Card kingOfSpades() {
		return new Card(Color.SPADES, Figure.KING);
	}
	
	@Bean
	public Card aceOfClubs() {
		return new Card(Color.CLUBS, Figure.ACE);
	}
	
	@Bean
	public Card aceOfDiamonds() {
		return new Card(Color.DIAMONDS, Figure.ACE);
	}
	
	@Bean
	public Card aceOfHearts() {
		return new Card(Color.HEARTS, Figure.ACE);
	}
	
	@Bean
	public Card aceOfSpades() {
		return new Card(Color.SPADES, Figure.ACE);
	}
	
	@Bean
	public CardDeck cardDeck() {
		return new CardDeck();
	}
}
