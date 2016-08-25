package org.okarmus.game.negotiation.model;

import java.util.List;

public class NegotiationResource {

	private int userBet;
	private List<Integer> cpusBet;
	private boolean finished;
	
	public NegotiationResource() { }

	public NegotiationResource(int userBet, List<Integer> cpusBet, boolean finished) {
		this.userBet = userBet;
		this.cpusBet = cpusBet;
		this.finished = finished;
	}

	public int getUserBet() {
		return userBet;
	}

	public void setUserBet(int userBet) {
		this.userBet = userBet;
	}

	public List<Integer> getCpusBet() {
		return cpusBet;
	}

	public void setCpusBet(List<Integer> cpusBet) {
		this.cpusBet = cpusBet;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	} 
}
