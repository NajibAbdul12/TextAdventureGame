package bcu.s17123860.adventure.model;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Location class represents the locations within the game.
 * @author Najib Abdulkhadir
 *
 */
public class Location {
	private String name;
	private String description;
	boolean hasItem;
	private final List<Item> items = new ArrayList<Item>();
	private final Map<String, Location> neigbours = new HashMap<>();
	/**
	 * Creates a location.
	 * @param name the name of location.
	 * @param description the description of location.
	 */
	public Location(String name, String description) {
		this.name = name;
		this.description = description;
		this.hasItem = false;
	}
	/**
	 * Returns the names of the locations within the game.
	 * @return the name of the location. 
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Returns the descriptions of the location within the game.
	 * @return the description of the location.
	 */
	public String getDescription() {
		return this.description;
	}
	/**
	 * This method create a new direction the player can go to.
	 * @param direction the direction the player can go.
	 * @param neighbour the neighbour of the location.
	 */
	public void addNeighbour(String direction, Location neighbour) {
		neigbours.put(direction, neighbour);
	}
	/**
	 * This method returns the direction that the player can go in within the game.
	 * @param direction the player can go in
	 * @return the neighbour of the location.
	 */
	public Location getNeighbour(String direction) {
		return neigbours.get(direction);
	}
	/**
	 * This method returns the directions within the game.
	 * @return the neighbour of the location.
	 */
	public Collection<String> getAllDirections() {
		return Collections.unmodifiableCollection(neigbours.keySet());
	}
	/**
	 * This method returns the items within the game.
	 * @return Collections.unmodifiableList
	 */
	public List<Item> getItems() {
		return Collections.unmodifiableList(items);
	}
	/**
	 * This method adds an item to the players inventory.
	 * <p>
	 * if item has been in another location then it removes that item from that location.
	 * @param item within the game.
	 */
	public void addItem(Item item) {
		items.add(item);
		item.setLocation(this);
		
	}
	/**
	 * This method returns an item within the game if the player has the item.
	 * @param item the item within the game.
	 * @return true if item is in the list false if it isn't.
	 */
	public boolean hasItem(Item item) {
		return items.contains(item);
	}
	/**
	 * Removes an item within the game.
	 * @param item the item within the game.
	 * @throws IllegalArgumentException if the item is not currently in this location
	 */
	public void removeItem(Item item) {
		if(items.contains(item)) {
			items.remove(item);
			item.setLocation(null);
		} else {
			throw new IllegalArgumentException();
		}
		
		
	}
}
