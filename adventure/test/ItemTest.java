package bcu.s17123860.adventure.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bcu.s17123860.adventure.model.Item;
import bcu.s17123860.adventure.model.Location;

public class ItemTest {
	private final Item clock = new Item("clock", "It is an old grandfather clock.");
	private final Location hawaii = new Location("hawaii", "its hot in hawaii");
	
	@Test
	public void testGetName() {
		assertEquals("clock", clock.getName());
	}
	
	@Test
	public void testGetDescription() {
		assertEquals("It is an old grandfather clock.", clock.getDescription());
	}
	@Test
	public void testGetLocationName() {
		assertEquals("hawaii", hawaii.getName());
	}
	@Test
	public void testGetLocationDescription() {
		assertEquals("its hot in hawaii", hawaii.getDescription());
	}
	
	@Test
	public void testSetPortable() {
		clock.setPortable(true);
		assertTrue(clock.isPortable());
	}
	@Test
	public void testNotPortable() {
		clock.setPortable(false);
		assertFalse(clock.isPortable());
	}
	
	@Test
	public void testLocation() {
		Location house = new Location("house", "You are in a small village house.");
		clock.setLocation(house);
		assertSame(house, clock.getLocation());
	}
}
