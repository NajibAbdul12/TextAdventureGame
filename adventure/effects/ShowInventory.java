package bcu.s17123860.adventure.effects;

import java.util.List;

import bcu.s17123860.adventure.model.Item;
import bcu.s17123860.adventure.model.Player;
import bcu.s17123860.adventure.model.World;
/**
 * This Effect ShowInventory represents the inventory the items are stored in.
 * @author Najib Abdulkhadir
 *
 */
public class ShowInventory implements Effect {

	/**
	 * shows inventory for player.
	 */
	public ShowInventory(){
	}
	/**
	 * This method implements the effect interface allowing the player to execute a command.
	 * <p>
	 * When executed it prints a list of items in the player’s inventory.
	 * <p>
	 * A message is shown if the players invenotry is empty.
	 * 
	 */
	public void execute(Player player, World world) {
		List<Item> inventory = player.getInventory();
		String inventorys = " ";
		if(inventory.isEmpty()) {
			System.out.println("You are not carrying anything.");
		} else {
			
			for(Item item : inventory) {
				inventorys += item.getName() + ". ";
			}
			System.out.println("Inventory Items: " + inventorys);
		}
		
	}
}
