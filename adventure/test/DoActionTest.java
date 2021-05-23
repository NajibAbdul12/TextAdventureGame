package bcu.s17123860.adventure.test;

import static org.junit.Assert.*;


import org.junit.Test;

import bcu.s17123860.adventure.effects.DoAction;
import bcu.s17123860.adventure.effects.Effect;
import bcu.s17123860.adventure.effects.TakeItem;
import bcu.s17123860.adventure.model.Action;
import bcu.s17123860.adventure.model.Item;
import bcu.s17123860.adventure.model.Location;
import bcu.s17123860.adventure.model.Player;
import bcu.s17123860.adventure.model.World;

public class DoActionTest {

	private final World world = new World();
	private final Location house = world.addLocation("house", "You are in the house");
	private final Player player = new Player(house);
	private final Item hammer = new Item("hammer", "its a brand new hammer");
	
	
	@Test
	public void testDoAction() {
		Action doAction =world.addAction("use");
		doAction.addEffect(new TakeItem("hammer"));
		hammer.setPortable(true);
		hammer.setLocation(house);
		Effect effect = new DoAction("use");
		effect.execute(player, world);
		assertTrue(player.getLocation().equals(house));
	}

}
