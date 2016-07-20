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
		return new Card(Color.CLUBS, Figure.NINE, 0);
	}
	
	@Bean
	public Card nineOfDiamonds() {
		return new Card(Color.DIAMONDS, Figure.NINE, 0);
	}
	
	@Bean
	public Card nineOfHearts() {
		return new Card(Color.HEARTS, Figure.NINE, 0);
	}
	
	@Bean
	public Card nineOfSpades() {
		return new Card(Color.SPADES, Figure.NINE, 0);
	}
	
	@Bean
	public Card tenOfClubs() {
		return new Card(Color.CLUBS, Figure.TEN, 10);
	}
	
	@Bean
	public Card tenOfDiamonds() {
		return new Card(Color.DIAMONDS, Figure.TEN, 10);
	}
	
	@Bean
	public Card tenOfHearts() {
		return new Card(Color.HEARTS, Figure.TEN, 10);
	}
	
	@Bean
	public Card tenOfSpades() {
		return new Card(Color.SPADES, Figure.TEN, 10);
	}
	
	@Bean
	public Card jackOfClubs() {
		return new Card(Color.CLUBS, Figure.JACK, 2);
	}
	
	@Bean
	public Card jackOfDiamonds() {
		return new Card(Color.DIAMONDS, Figure.JACK, 2);
	}
	
	@Bean
	public Card jackOfHearts() {
		return new Card(Color.HEARTS, Figure.JACK, 2);
	}
	
	@Bean
	public Card jackOfSpades() {
		return new Card(Color.SPADES, Figure.JACK, 2);
	}
	
	@Bean
	public Card queenOfClubs() {
		return new Card(Color.CLUBS, Figure.QUEEN, 3);
	}
	
	@Bean
	public Card queenOfDiamonds() {
		return new Card(Color.DIAMONDS, Figure.QUEEN, 3);
	}
	
	@Bean
	public Card queenOfHearts() {
		return new Card(Color.HEARTS, Figure.QUEEN, 3);
	}
	
	@Bean
	public Card queenOfSpades() {
		return new Card(Color.SPADES, Figure.QUEEN, 3);
	}
	
	@Bean
	public Card kingOfClubs() {
		return new Card(Color.CLUBS, Figure.KING, 4);
	}
	
	@Bean
	public Card kingOfDiamonds() {
		return new Card(Color.DIAMONDS, Figure.KING, 4);
	}
	
	@Bean
	public Card kingOfHearts() {
		return new Card(Color.HEARTS, Figure.KING, 4);
	}
	
	@Bean
	public Card kingOfSpades() {
		return new Card(Color.SPADES, Figure.KING, 4);
	}
	
	@Bean
	public Card aceOfClubs() {
		return new Card(Color.CLUBS, Figure.ACE, 11);
	}
	
	@Bean
	public Card aceOfDiamonds() {
		return new Card(Color.DIAMONDS, Figure.ACE, 11);
	}
	
	@Bean
	public Card aceOfHearts() {
		return new Card(Color.HEARTS, Figure.ACE, 11);
	}
	
	@Bean
	public Card aceOfSpades() {
		return new Card(Color.SPADES, Figure.ACE, 11);
	}
	
	@Bean
	public CardDeck cardDeck() {
		return new CardDeck();
	}
}
