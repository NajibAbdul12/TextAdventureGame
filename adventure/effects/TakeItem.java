package bcu.s17123860.adventure.effects;

import bcu.s17123860.adventure.model.Item;
import bcu.s17123860.adventure.model.Player;
import bcu.s17123860.adventure.model.World;
/**
 * This Effect TakeItem implements the effect when the player takes item.
 * @author Najib Abdulkhadir
 *
 */
public class TakeItem implements Effect{
	
	private final String itemName;

	/**
	 * creates the effect to take item.
	 * @param itemName the name of the item.
	 */
	public TakeItem(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * This method implements the effect interface allowing the player to execute a command.
	 * <p>
	 * A message is shown if the item does not exist or player is already carring item
	 * <p>
	 * also if item is not portable or if item is not in players current location.
	 */
	@Override
	public void execute(Player player, World world) {
		
		Item item = world.getItem(itemName);
		if(item == null) { 
			System.out.println(itemName + " does not exist");
		} else if(player.hasItem(item)) {
			System.out.println("player alreday has "+ itemName + " in inventory");
		} else if(!item.isPortable()) {
			System.out.println(itemName + " is not portable");
		} else if (!player.getLocation().hasItem(item)){
			System.out.println(item.getName() + " is not in player location" );
		} else {
			player.takeItem(item);
			System.out.println(item.getName() + " is in inventory" );
		}
	}

}
