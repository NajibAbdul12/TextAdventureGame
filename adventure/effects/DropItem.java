package bcu.s17123860.adventure.effects;

import bcu.s17123860.adventure.model.Item;
import bcu.s17123860.adventure.model.Player;
import bcu.s17123860.adventure.model.World;


/**
 * DropItem class effect represents the action performed by the player
 * <p>
 * when the player drops the item
 * @author Najib Abdulkhadir
 *
 */
public class DropItem implements Effect {
	
	private String itemName;
	
	/**
	 * Creates effect drop item to be performed by player
	 * @param itemName the name of the item.
	 */
	public DropItem(String itemName) {
		this.itemName = itemName;
	}
	
	
	/**
	 * This method implements the effect interface allowing the player to execute a command.
	 * <p>
	 * A message is shown if there are no items to be dropped in a location.
	 */
	public void execute(Player player, World world) {
		Item item = world.getItem(itemName);
		player.getLocation();
		if(player.hasItem(item)) {
			player.dropItem(item);
			System.out.println(item.getName() +" Dropped");
			} else {
				System.out.println("you do not have " + item.getName() + " to drop it");
			}
		
		}

}
