package bcu.s17123860.adventure.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bcu.s17123860.adventure.effects.Effect;
/**
 * World class represents the world within the game.
 * @author Najib Abdulkhadir
 *
 */
public class World {
	private Location location;
	private final Map<String, Item> items = new HashMap<String, Item>();
	private final Map<String, Location> locations = new HashMap<String, Location>();
	private final Map<String, Action> actions = new HashMap<String, Action>();
	private final List<Effect> effects = new ArrayList<Effect>();
	/**
	 * Creates a world
	 */
	public World() {
		this.location = null;
	}
	/**
	 * Returns a location in the game.
	 * @return a location in the game.
	 */
	public Location getStartingLocation() {
		return this.location;
	}
	/**
	 * Sets up a location within the game.
	 * @param location the location within the game.
	 */
	public void setStartingLocation(Location location) {
		this.location = location;
	}
	/**
	 * 
	 * @param name the name of the item.
	 * @return name of item.
	 */
	public Item getItem(String name) {
		return items.get(name);
	}
	/**
	 * This method adds an item to the game.
	 * @param name the name of the item
	 * @param description the description of the item
	 * @return a item within the game
	 */
	public Item addItem(String name, String description) {
		if(items.containsKey(name)) {
			String message= "Item already exists " + name;
			throw new IllegalArgumentException(message);
		}
		Item item = new Item(name, description);
		items.put(name, item);
		return item;
		
	}
	/**
	 * Returns location in the game.
	 * @param name the name of the location
	 * @return locations in the game
	 */
	public Location getLocation(String name) {
		return locations.get(name);
	}
	/**
	 * Returns a new location within the game.
	 * @param name the name of the location
	 * @param description of the location
	 * @return a location within the game
	 */
	public Location addLocation(String name, String description) {
		if(locations.containsKey(name)) {
			String message= "Location already exists " + name;
			throw new IllegalArgumentException(message);
		}
		Location locationNew = new Location(name, description);
		locations.put(name, locationNew);
		return locationNew;
	}
	/**
	 * This method returns the action within the game
	 * @param name the name of the action.
	 * @return the action used within the game
	 */
	public Action getAction(String name) {
		return actions.get(name);
	}
	/**
	 * Returns the action used within the game
	 * @param name the name of the effect
	 * @return the action used within the game
	 */
	public Action addAction(String name) {
		if(actions.containsKey(name)) {
			String message= "Action already exists " + name;
			throw new IllegalArgumentException(message);
		}
		Action action = new Action(name);
		actions.put(name, action);
		return action;
	}
	/**
	 * This method adds a effect to the game.
	 * @param effect object within the game.
	 */
	public void onStart(Effect effect) {
		effects.add(effect);
	}
	/**
	 * returns a list of effects.
	 * @return a List of effects
	 */
	public List<Effect> getStartEffects() {
		return Collections.unmodifiableList(effects);
	}
}
