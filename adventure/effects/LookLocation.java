package bcu.s17123860.adventure.effects;

import bcu.s17123860.adventure.model.Item;
import bcu.s17123860.adventure.model.Location;
import bcu.s17123860.adventure.model.Player;
import bcu.s17123860.adventure.model.World;


/**
 * This Effect LookLocation implements the effect when the player looks at the location.
 * @author Najib Abdulkhadir
 *
 */
public class LookLocation implements Effect {

	/**
	 * creates the effect look location.
	 */
	public LookLocation() {
		
	}
	
	/**
	 * This method implements the effect interface allowing the player to execute a command.
	 * <p>
	 * A message is shown of the names of the items and directions within the game.
	 */
	@Override
	public void execute(Player player, World world) {
		//Location location = world.getStartingLocation();
		Location location = player.getLocation();
		System.out.println(location.getDescription());
		if(!location.getItems().isEmpty()) {
			for(Item item : location.getItems()) {
				System.out.print("There is: " + item.getName() + "\n" );
			}
		} 
		System.out.println("You can go: " + location.getAllDirections());
		
	}

}
