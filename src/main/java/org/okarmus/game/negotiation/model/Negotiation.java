 package org.okarmus.game.negotiation.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.okarmus.game.negotiation.NegotiationDecider;

public class Negotiation {
	
	private NegotiationPlayer user;
	private List<NegotiationPlayer> cpus;
	
	public Negotiation(NegotiationPlayer user, List<NegotiationPlayer> cpus) {
		this.user = user;
		this.cpus = cpus;
	}

	public void userRaise(int score) {
		user.raise(score);
	}
	
	public void cpusNegotiations(NegotiationDecider decider) {
		cpus.stream()
			.filter(NegotiationPlayer::isNegotiating)
			.forEach((player) -> player.decideOnNegotiation(this, decider));
	}
	
	public void userPass() {
		user.pass();
	}
	
	public boolean checkFinished() {
		return playersStream().filter(NegotiationPlayer::isNegotiating).count() < 2;
	}
	
	public Stream<NegotiationPlayer> playersStream() {
		return Stream.concat(cpus.stream(), Stream.of(user));
	}
	
	public int findMax() {
		return playersStream()
				.collect(Collectors.maxBy((p1, p2) -> p1.getPoints() - p2.getPoints()))
				.get()
				.getPoints();
	}
	
	public NegotiationPlayer getUser() {
		return user;
	}

	public List<NegotiationPlayer> getCpus() {
		return cpus;
	}
}
