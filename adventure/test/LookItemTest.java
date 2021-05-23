package bcu.s17123860.adventure.test;

import static org.junit.Assert.*;

import org.junit.Test;

import bcu.s17123860.adventure.effects.Effect;
import bcu.s17123860.adventure.effects.LookItem;
import bcu.s17123860.adventure.model.Item;
import bcu.s17123860.adventure.model.Location;
import bcu.s17123860.adventure.model.Player;
import bcu.s17123860.adventure.model.World;

public class LookItemTest {
	private final World world = new World();
	private final Item hammer = world.addItem("hammer", "it is a brand new hammer");
	private final Item clock = world.addItem("clock", "it is a old grandfather clock");
	private final Location house = world.addLocation("house", "You are in the house");
	private final Location street = world.addLocation("street", "You are in the street");
	private final Player player = new Player(house);
	
	
	@Test
	public void testLookItemHammer() {
		Effect lookItem = new LookItem("hammer");
		street.addItem(hammer);
		hammer.setLocation(street);
		hammer.setPortable(true);
		lookItem.execute(player, world);
		assertFalse(player.canSeeItem(hammer));
	}
	
	@Test
	public void testLookItemClock() {
		Effect lookItem = new LookItem("clock");
		clock.setLocation(house);
		clock.setPortable(false);
		lookItem.execute(player, world);
		assertFalse(player.canSeeItem(clock));
	}

}
