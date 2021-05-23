package bcu.s17123860.adventure.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Player class represents a player within the game.
 * 
 * @author Najib Abdulkhadir
 *
 */
public class Player {
	private Location location;
	private final List<Item> inventory = new ArrayList<Item>();

	/**
	 * Creates a player.
	 * 
	 * @param location the location within the game.
	 */
	public Player(Location location) {
		this.location = location;
	}

	/**
	 * This method returns the locations within the game.
	 * 
	 * @return the locations of the player within the game.
	 */
	public Location getLocation() {
		return this.location;
	}

	/**
	 * This methods set a new location within the game.
	 * 
	 * @param location the locations within the game.
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * This method allows the player to take an item from on location to another.
	 * 
	 * @param item the items within the game
	 */
	public void takeItem(Item item) {
		if (!item.isPortable()) {
			throw new IllegalArgumentException();
		} else if (!location.hasItem(item)) {
			throw new IllegalArgumentException();
		}
		this.inventory.add(item);
		location.removeItem(item);

	}

	/**
	 * This method checks to see if the inventory has an item.
	 * 
	 * @param item the items within the game
	 * @return true if the item is in the inventory and false if it isn't.
	 */
	public boolean hasItem(Item item) {
		return inventory.contains(item);
	}

	/**
	 * This method check to see if player has item.
	 * <p>
	 * The item is in the current location.
	 * 
	 * @param item the items within the game
	 * @return true if player can see item and false if it isn't
	 */
	public boolean canSeeItem(Item item) {
		return hasItem(item) || location.hasItem(item);
	}

	/**
	 * This method allows for the player to drop item in the current location.
	 * 
	 * @param item the items within the game
	 */
	public void dropItem(Item item) {
		if (hasItem(item)) {
			this.inventory.remove(item);
			getLocation().addItem(item);
		} else {
			throw new IllegalArgumentException();
		}

	}

	/**
	 * Returns a list of items in the inventory.
	 * 
	 * @return a list of items in the inventory
	 */
	public List<Item> getInventory() {
		return Collections.unmodifiableList(inventory);
	}
}
