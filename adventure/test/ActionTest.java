package bcu.s17123860.adventure.test;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import bcu.s17123860.adventure.effects.Effect;
import bcu.s17123860.adventure.effects.Message;
import bcu.s17123860.adventure.model.Action;
import bcu.s17123860.adventure.model.Item;
import bcu.s17123860.adventure.model.Location;
import bcu.s17123860.adventure.model.Player;

public class ActionTest {
	private final Action action = new Action("use hammer");
	@Test
	public void testgetName() {
		assertEquals("use hammer", action.getName());
	}
	
	@Test
	public void testIsAllowed() {
		Location hotel = new Location("hotel","its a very clean hotel");
		Player player = new Player(hotel);
		Item hammer = new Item("hammer","it a very old hammer");
		Item clock = new Item("clock","its a very old grandfather clock");
		hotel.addItem(hammer);
		
		action.addRequiredItem(hammer);
		action.addRequiredItem(clock);
		
		assertFalse(action.isAllowed(player));
	}
	
	@Test
	public void testaddEffect() {
		Effect effect = new Message("test");
		action.addEffect(effect);
		List<Effect> effects = new ArrayList<Effect>();
		effects.add(effect);
		assertEquals(effects, action.getEffects());
	}
	
	@Test
	public void testgetEffect() {
		assertEquals(Collections.emptyList(), action.getEffects());
		
	}
	
}
