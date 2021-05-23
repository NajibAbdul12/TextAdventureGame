package bcu.s17123860.adventure.test;

import org.junit.Test;



import bcu.s17123860.adventure.model.Item;
import bcu.s17123860.adventure.model.Location;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocationTest {
	private final Location house = new Location("house", "You are in a small village house.");
	private final Location street = new Location("street", "You are on the main street of the village.");
	private final List<Item> items = new ArrayList<Item>();
	@Test
	public void testGetName() {
		assertEquals("house", house.getName());
	}
	
	@Test
	public void testGetDescription() {
		assertEquals("You are in a small village house.", house.getDescription());
	}
	
	@Test
	public void noItems() {
		assertEquals(Collections.emptyList(), house.getItems());
	}
	
	@Test
	public void testGetNeighbourName() {
		assertEquals("street",street.getName());
	}
	
	@Test
	public void testGetNeighbourDescription() {
		assertEquals("You are on the main street of the village.",street.getDescription());
	}
	
	@Test
	public void testAddNeighbour() {
		Location house = new Location("house","its a brand new house");
		Location shop = new Location("shop","the best shop in town");
		house.addNeighbour("next door", shop);
		shop.addNeighbour("next door", house);
		List<Location> neighbour = new ArrayList<>();
		neighbour.add(shop);
		neighbour.add(house);
		assertTrue(neighbour.contains(shop));
		assertTrue(neighbour.contains(house));
	}
	
	@Test
	public void testAddItem() {
		Item hammer = new Item("hammer","its a brand new hammer");
		items.add(hammer);
		assertTrue(items.contains(hammer));
	}
	
	@Test
	public void testRemoveItem() {
		Item hammer = new Item("hammer","its a brand new hammer");
		items.add(hammer);
		items.remove(hammer);
		assertTrue(items.isEmpty());
	}
	
	@Test
	public void testAllDirections() {
		Location hotel = new Location("hotel","5 star hotel");
		Location shop = new Location("shop","welcome to the best shop");
		hotel.addNeighbour("up the steet", shop);
		shop.addNeighbour("down the street", hotel);
		List<Location> allDirections = new ArrayList<>();
		allDirections.add(hotel);
		allDirections.add(shop);
		assertTrue(allDirections.contains(shop));
		assertTrue(allDirections.contains(hotel));
		
	}
}
