package bcu.s17123860.adventure.effects;

import bcu.s17123860.adventure.model.Item;
import bcu.s17123860.adventure.model.Player;
import bcu.s17123860.adventure.model.World;


/**
 * This Effect LookItem implements the effect when the player looks at an item.
 * @author Najib Abdulkhadir
 *
 */
public class LookItem implements Effect{

	private final String itemName;
	
	/**
	 * Creates effect to look at the description of item
	 * @param itemName the name of the item.
	 */
	public LookItem(String itemName){
		this.itemName = itemName;
		}


	/**
	 * This method implements the effect interface allowing the player to execute a command.
	 * <p>
	 * A message is shown if the items doesn't exist and if player cannot see item. 
	 * 
	 */
	@Override
	public void execute(Player player, World world) {
		// TODO Auto-generated method stub
		Item item = world.getItem(itemName);
		if(item == null ) {
			System.out.println("Item " + itemName + " does not exist" );
		}else if (!player.canSeeItem(item)) {
			System.out.println("player connont see item " + itemName);
		} else 
			System.out.println(item.getDescription());
	}
}
