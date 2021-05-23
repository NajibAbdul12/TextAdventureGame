package bcu.s17123860.adventure.effects;
import bcu.s17123860.adventure.model.Location;
import bcu.s17123860.adventure.model.Player;
import bcu.s17123860.adventure.model.World;


/**
 * Go Direction effect class represents the action performed by the player
 * @author Najib Abdulkhadir
 *
 */
public class GoDirection implements Effect {
	
	private final String direction;
	
	
	/**
	 * Creates effect direction enabling player to go different directions
	 * @param direction the directions available.
	 */
	public GoDirection(String direction){
		this.direction = direction;
	}
	
	/**
	 * This method implements the effect interface allowing the player to execute a command.
	 * <p>
	 * A message is shown if the direction used doesn't exist.
	 */
	@Override
	public void execute(Player player, World world) {
		Location neighbour = player.getLocation().getNeighbour(direction);
		if(neighbour == null) {
			System.out.println("You cannot go " + direction + " because you are already inside");
			
		} else {
			player.setLocation(neighbour);
			System.out.println(neighbour.getDescription());
		}
	}
}

