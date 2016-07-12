package org.okarmus.game.manager.game;

import org.okarmus.game.context.GameContext;
import org.okarmus.game.manager.game.builder.GameBuilder;
import org.okarmus.game.model.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class GameManagerTest {

	@Autowired
	GameManager underTest;
	
	@Autowired
	GameContext context;
	
	@Autowired
	GameBuilder gameBuilder;
	
	int expectedId = 12;
	String playerName = "Jedrej";
	Game game = new Game();
	
	@Before
	public void setUp() {
		when(context.addGame(game)).thenReturn(expectedId);
		when(gameBuilder.build(playerName)).thenReturn(game);
	}
	
	@Test
	public void shouldCreateModel() {
		//when
		int actualId = underTest.createGame(playerName);
		
		//then
		verify(context).addGame(game);
		assertEquals(expectedId, actualId);
	}
	
	@Configuration
	public static class ContextConfig {
		
		@Bean
		public GameManager gameManager() {
			return new GameManager();
		}
		
		@Bean
		public GameBuilder gameBuilder() {
			return mock(GameBuilder.class);
		}
		
		@Bean
		public GameContext gameContext() {
			return mock(GameContext.class);
		}
		
		@Bean
		public AtomicInteger atomicInteger() {
			return mock(AtomicInteger.class);
		}
	}
}
