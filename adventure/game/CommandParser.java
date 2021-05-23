package bcu.s17123860.adventure.game;

import bcu.s17123860.adventure.effects.DoAction;
import bcu.s17123860.adventure.effects.DropItem;
import bcu.s17123860.adventure.effects.Effect;
import bcu.s17123860.adventure.effects.GoDirection;
import bcu.s17123860.adventure.effects.LookItem;
import bcu.s17123860.adventure.effects.LookLocation;
import bcu.s17123860.adventure.effects.Message;
import bcu.s17123860.adventure.effects.Quit;
import bcu.s17123860.adventure.effects.ShowInventory;
import bcu.s17123860.adventure.effects.TakeItem;
/**
 * Command parser class represents the commands which will be inputed by the player.
 * @author Najib Abdulkhadir
 *
 */
public class CommandParser {
	/**
	 * This represents the help message the player might need during the game.
	 */
	public static final String HELP_MESSAGE =
		"Commands:\n" +
		"    look              Look around you.\n" +
		"    look [item]       Look at an item.\n" +
		"    inventory         Look at your inventory.\n" +
		"    go [direction]    Walk in a direction.\n" +
		"    take [item]       Take an item.\n" +
		"    drop [item]       Drop an item.\n" +
		"    help              Show this help message.\n" +
		"    quit              Exit the game.";
	
	/**
	 * Player types in command and returns an effect representing a command.
	 * @param command the command inputed by the player
	 * @return the action performed by player
	 */
	public static Effect parsePlayerCommand(String command){
		// TODO: complete implementation of parsePlayerCommand
		command = command.toLowerCase();
		if("look".equals(command)) {
			return new LookLocation();
			
		} else if(command.startsWith("look")) {
			String [] split = command.split(" ");
			if(split.length > 2) {
				System.out.println("you can only look at one item at time");
			}else {
				return new LookItem(split[1]);
			}
			
		} else if("inventory".equals(command)) {
			return new ShowInventory();
			
		} else if(command.startsWith("go")){
			String [] split = command.split(" ");
			if(split.length > 2) {
				System.out.println("you can only go at one direction at time");
			}else {
				return new GoDirection(split[1]);
			}
			
		} else if(command.startsWith("take")) {
			String [] split = command.split(" ");
			if(split.length > 2) {
				System.out.println("you can only take one item at a time");
			}else {
				return new TakeItem(split[1]);
			}
			
		} else if(command.startsWith("drop")) {
			
			String [] split = command.split(" ");
			if(split.length > 2) {
				System.out.println("you can only drop one item at time");
			}else {
				return new DropItem(split[1]);
			}
			
		} else if("help".equals(command)) {
			return new Message(HELP_MESSAGE);
			
		}else if("quit".equals(command)) {
			return new Quit();
			
		}else if(command.startsWith("use")) {
			String [] split = command.split(" ");
			if(split.length > 2) {
				System.out.println("Cannnot do this");
			}
		}
				return new DoAction(command);
			
		
	}
}
