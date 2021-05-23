package bcu.s17123860.adventure.test;


import org.junit.Test;


import bcu.s17123860.adventure.model.Item;
import bcu.s17123860.adventure.model.Location;
import bcu.s17123860.adventure.model.Player;
import bcu.s17123860.adventure.model.World;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerTest {
	private final World world = new World();
	private final Location house = new Location("house", "You are in a small village house.");
	private final Location street = new Location("street", "You are on the main street of the village.");
	private final Player player = new Player(street);
	
	@Test
	public void testGetLocation() {
		assertSame(street, player.getLocation());
	}
	
	@Test
	public void testSetLocation() {
		player.setLocation(house);
		assertSame(house, player.getLocation());
	}
	
	@Test
	public void testInventory() {
		assertEquals(Collections.emptyList(), player.getInventory());
	}
	
	@Test
	public void testGetInventory() {
		List<Item> inventory = new ArrayList<Item>();
		Item Hammer = new Item("hammer","its a brand new hammer");
		Hammer.setPortable(true);
		inventory.add(Hammer);
		assertFalse(player.getInventory().contains(Hammer));
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testDropItem() {
		Item hammer = new Item("hammer","it is a brand new hammer");
		player.dropItem(hammer);
		
	}
	
	
	
	
	
	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testItemNotportable() {
		Item clock = new Item("clock","it is an old gradfather clock");
		player.takeItem(clock);
	}
	
	@Test
	public void testHasItem() {
		world.addLocation("house", "its a brand new house");
		Item Hammer = new Item("hammer","its a brand new hammer");
		Hammer.setPortable(true);
		player.setLocation(world.getLocation("house"));
		world.getLocation("house").addItem(Hammer);
		player.takeItem(Hammer);
		assertTrue(player.hasItem(Hammer));
	}
	@Test
	public void testHasNoItem() {
		Item hammer = new Item("hammer","this is a brand new hammer");
		hammer.setLocation(street);
		assertFalse(player.hasItem(hammer));
	}
	
	@Test
	public void testCanSeeItem() {
		Item hammer = new Item("hammer", "it is a brand new hammer");
		assertFalse(player.canSeeItem(hammer));
	}
}
