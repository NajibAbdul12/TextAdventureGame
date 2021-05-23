package bcu.s17123860.adventure.effects;

import bcu.s17123860.adventure.game.QuitException;
import bcu.s17123860.adventure.model.Player;
import bcu.s17123860.adventure.model.World;

/**
 * This Effect quit represents the effect when player quits the game.
 * @author Najib Abdulkhadir
 *
 */
public class Quit implements Effect{
	
	/**
	 * Quit effect when player quits the game.
	 */
	public Quit() {

	}
	
	/**
	 * This method implements the effect interface allowing the player to execute a command.
	 * @throws QuitException when executed.
	 */
	@Override
	public void execute(Player player, World world) throws QuitException {
		// TODO Auto-generated method stub
		throw new QuitException();
	}
}
