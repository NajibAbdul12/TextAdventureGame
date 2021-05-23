package bcu.s17123860.adventure.test;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bcu.s17123860.adventure.model.Action;
import bcu.s17123860.adventure.model.Item;
import bcu.s17123860.adventure.model.Location;
import bcu.s17123860.adventure.model.World;

public class WorldTest {
	private final World world = new World();
	private final List<Item> items = new ArrayList<Item>();

	@Test
	public void testGetStartingLocation() {
		Location hotel = new Location("hotel","a very good hotel");
		world.setStartingLocation(hotel);
		assertEquals(hotel,world.getStartingLocation());
	}
	
	@Test
	public void testgetItem() {
		Item hammer = new Item("hammer","its a brand new hammer");
		assertEquals("hammer", hammer.getName());
	}
	
	@Test
	public void testaddItem() {
		Item hammer = new Item("hammer","its a brand new hammer");
		items.add(hammer);
		assertTrue(items.contains(hammer));
	}
	
	
	@Test
	public void testgetAction() {
		Action action = new Action("use");
		assertEquals("use", action.getName());
	}
	
	@Test
	public void testaddAction() {
		assertSame(world.addAction("use"),world.getAction("use"));
		
		
	}
}
