package bcu.s17123860.adventure.effects;

import bcu.s17123860.adventure.model.Player;
import bcu.s17123860.adventure.model.World;

/**
 * This Effect message represents the effect when there is a message.
 * @author Najib Abdulkhadir
 *
 */
public class Message implements Effect {
	private String Message;
	
	/**
	 * Creates a message.
	 * @param Message the message for player to see
	 */
	public Message(String Message) {
		this.Message = Message;
		
	}

	/**
	 * This method implements the effect interface allowing the player to execute a command.
	 * <p>
	 * A message is shown when the player ends that game by using the correct command.
	 *
	 */
	@Override
	public void execute(Player player, World world) {
		// TODO Auto-generated method stub
		System.out.println(this.Message);
	}
	
}
