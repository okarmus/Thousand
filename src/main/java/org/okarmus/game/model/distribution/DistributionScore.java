package org.okarmus.game.model.distribution;

public class DistributionScore {

	private boolean negotiationWinner;
	private int requiredPoints;
	private int gainedPoints;
	
	public boolean isNegotiationWinner() {
		return negotiationWinner;
	}
	public void setNegotiationWinner(boolean negotiationWinner) {
		this.negotiationWinner = negotiationWinner;
	}
	public int getRequiredPoints() {
		return requiredPoints;
	}
	public void setRequiredPoints(int requiredPoints) {
		this.requiredPoints = requiredPoints;
	}
	public int getGainedPoints() {
		return gainedPoints;
	}
	public void setGainedPoints(int gainedPoints) {
		this.gainedPoints = gainedPoints;
	}
}
