package bcu.s17123860.adventure.test;

import static org.junit.Assert.*;

import org.junit.Test;

import bcu.s17123860.adventure.effects.Effect;
import bcu.s17123860.adventure.effects.GoDirection;
import bcu.s17123860.adventure.model.Location;
import bcu.s17123860.adventure.model.Player;
import bcu.s17123860.adventure.model.World;

public class GoDirectionTest {
	private final World world = new World();
	private final Location street = world.addLocation("street", "");
	private final Location house = world.addLocation("house", "");
	private final Player player = new Player(house);
	
	
	@Test
	public void testGoDirection() {
		Effect goDirection = new GoDirection("out");
		house.addNeighbour("out", street);
		player.setLocation(house);
		goDirection.execute(player, world);
		assertEquals(player.getLocation(), world.getLocation("house").getNeighbour("out"));
	}

}
