package bcu.s17123860.adventure.effects;

import bcu.s17123860.adventure.model.Action;
import bcu.s17123860.adventure.model.Player;
import bcu.s17123860.adventure.model.World;

/**
 * DoAction class represents the action which is performed
 * @author Najib Abdulkhadir
 *
 */
public class DoAction implements Effect {

	private final String actionName;
	
	/**
	 * Creates a new action in the game.
	 * @param actionName the name of the action performed.
	 */
	public DoAction(String actionName ) {
		this.actionName = actionName;
	}
	
	
	/**
	 * This method implements the effect interface allowing the player to execute a command.
	 * <p>
	 * A message is shown if any commands that are not part of the game is inputed. 
	 * 
	 */
	@Override
	public void execute(Player player, World world) {
		Action action = world.getAction(actionName);
		 if(action != null && action.isAllowed(player)) {
			for(Effect effect : action.getEffects()) {
				effect.execute(player, world);
			}
		} else {
			System.out.println("i do not know how to perform the action: " + actionName);
		}
	}

}
