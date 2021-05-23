package bcu.s17123860.adventure.effects;

import bcu.s17123860.adventure.model.Player;
import bcu.s17123860.adventure.model.World;
/**
 * Effect interface represents the action performed by the player
 * @author Najib Abdulkhadir
 *
 */
public interface Effect {
	/**
	 * player to execute a command.
	 * 
	 * @param player the player to execute command
	 * @param world the world models an entire virtual game world.
	 */
	public void execute(Player player, World world);
}
