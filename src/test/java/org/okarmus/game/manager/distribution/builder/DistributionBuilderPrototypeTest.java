package org.okarmus.game.manager.distribution.builder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.okarmus.ThousandApplication;
import org.okarmus.game.model.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ThousandApplication.class})
public class DistributionBuilderPrototypeTest {	//TODO this test must be removed

	@Autowired
	private DistributionBuilder underTest;
	
	@Test
	public void cardsPileShouldBePrototype() {
		underTest.build(new Game());
		
		
		underTest.build(new Game());
	}
}
