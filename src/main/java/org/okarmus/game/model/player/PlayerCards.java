package org.okarmus.game.model.player;

import java.util.List;

import org.okarmus.game.model.card.Card;

public class PlayerCards {
	private List<Card> playerCards;
	
	public List<Card> getPlayerCards() {
		return playerCards;
	}

	public void setPlayerCards(List<Card> playerCards) {
		this.playerCards = playerCards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((playerCards == null) ? 0 : playerCards.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerCards other = (PlayerCards) obj;
		if (playerCards == null) {
			if (other.playerCards != null)
				return false;
		} else if (!playerCards.equals(other.playerCards))
			return false;
		return true;
	}
}
