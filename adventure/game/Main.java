package bcu.s17123860.adventure.game;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import bcu.s17123860.adventure.effects.Effect;
import bcu.s17123860.adventure.effects.LookLocation;
import bcu.s17123860.adventure.effects.Message;
import bcu.s17123860.adventure.effects.Quit;
import bcu.s17123860.adventure.model.Action;
import bcu.s17123860.adventure.model.Item;
import bcu.s17123860.adventure.model.Location;
import bcu.s17123860.adventure.model.Player;
import bcu.s17123860.adventure.model.World;

/**
 *  The Main class implements the user input and creates a new world for the game. 
 * @author Najib Abdulkhadir
 * @see Runnable
 *
 */
public class Main implements Runnable {

	private static World world;
	
	/**
	 * This method creates the main object
	 * @param world the world within the game.
	 */
	public Main(World world){
		Main.world = world;
	}
	/**
	 * This method takes in user input and decides the right effect to use to execute
	 */
	@Override
	public void run() throws QuitException {
		Player player = new Player(Main.world.getStartingLocation());
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		while(true) { 
		System.out.print(">>>");
		try {
			String input = keyboard.readLine();
			Effect effect = CommandParser.parsePlayerCommand(input);
			effect.execute(player, world);
			
		} catch (Exception exception) {
			break;
		} 
		}
	}
	/**
	 * This method creatres a new world in the game and .
	 * @param args the inputted commands by player.
	 */
	public static void main(String [ ] args){
		
		World world = new World();
		System.out.println("You are in a small village house");
		System.out.println("There is: clock.\r\n" + 
				"You can go: out");
		Location house = world.addLocation("house", "You are in a small village house.");
		Location street =world.addLocation("street", "You are on the main street of the village.");
	
		house.addNeighbour("out", street);
		street.addNeighbour("in", house);
		
		Item clock = world.addItem("clock", "It is an old grandfather clock.");
		house.addItem(clock);
		
		Item hammer = world.addItem("hammer", "It is a brand new hammer.");
		street.addItem(hammer);
		hammer.setPortable(true);
		
		Action useHammer = world.addAction("use hammer");
		useHammer.addRequiredItem(hammer);
		useHammer.addRequiredItem(clock);
		useHammer.addEffect(new Message("You hit the clock with the hammer."));
		useHammer.addEffect(new Message("The clock shatters into pieces."));
		useHammer.addEffect(new Message("THE END"));
		useHammer.addEffect(new Quit());
		
		
		world.setStartingLocation(house);
		world.onStart(new LookLocation());
		Main main = new Main(world);
		main.run();
		
		}
}



