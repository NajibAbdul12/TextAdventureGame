package bcu.s17123860.adventure.test;

import static org.junit.Assert.*;

import org.junit.Test;

import bcu.s17123860.adventure.effects.Effect;
import bcu.s17123860.adventure.effects.TakeItem;
import bcu.s17123860.adventure.model.Item;
import bcu.s17123860.adventure.model.Location;
import bcu.s17123860.adventure.model.Player;
import bcu.s17123860.adventure.model.World;

public class TakeItemTest {
	private final World world = new World();
	private final Item hammer = world.addItem("hammer", "it is a brand new hammer");
	private final Location house = world.addLocation("house", "You are in the house");
	private final Player player = new Player(house);
	
	
	@Test
	public void testTakeItem() {
		Effect takeItem = new TakeItem("hammer");
		house.addItem(hammer);
		hammer.setLocation(house);
		hammer.setPortable(true);
		takeItem.execute(player, world);
		assertTrue(player.hasItem(hammer));
		
	}

}
