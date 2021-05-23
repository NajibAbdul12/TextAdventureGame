package bcu.s17123860.adventure.model;

/**
 * Item class represents the item within the game.
 * <p>
 * An Item Has a name and a description. It can also be portable or not.
 *
 * @author Najib Abdulkhadir
 *
 */
public class Item {
	private final String name;
	private final String description;
	private Location location = new Location("street", "You are on the main street of the village.");
	private boolean portable;
	/**
	 * Creates an item.
	 * @param name the name of item.
	 * @param description the description of item.
	 */
	public Item(String name, String description) {
		this.name = name;
		this.description = description;
		this.portable = false;
		
	}
	/**
	 * Returns the name of the item.
	 * @return the name of the item
	 */
	public String getName() {
		return name;
	}
	/**
	 * Returns the description of the item.
	 * @return the description of the item
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Returns the location of the item within the game
	 * @return the location within the game
	 */
	public Location getLocation() {
		return this.location;
	}
	/**
	 * This method sets the location of the item.
	 * @param location of the item.
	 */
	public void setLocation(Location location){
		this.location = location;
	}
	/**
	 * This method returns portable if the item is portable.
	 * @return true if the item is portable false if the item is not portable.
	 */
	public boolean isPortable() {
		return portable;
	}
	/**
	 * This method sets the item to portable.
	 * @param portable the item is portable.
	 */
	public void setPortable(boolean portable) {
		this.portable = portable;
	}
}
