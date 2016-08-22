 package org.okarmus.game.negotiation.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Negotiation {
	
	private NegotiationPlayer user;
	private List<NegotiationPlayer> cpus;
	
	public Negotiation(NegotiationPlayer user, List<NegotiationPlayer> cpus) {
		this.user = user;
		this.cpus = cpus;
	}

	public List<NegotiationPlayer> findNegotiatingCpus() {
		return cpus.stream()
				.filter(NegotiationPlayer::isNegotiating)
				.collect(Collectors.toList());
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
