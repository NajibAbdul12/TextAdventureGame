package bcu.s17123860.adventure.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bcu.s17123860.adventure.effects.Effect;
/**
 * Action class represents the actions within the game.
 * <p>
 * 
 * @author Najib Abdulkhadir
 *
 */
public class Action {
	private final String name;
	private final List<Item> items = new ArrayList<Item>();
	private final List<Effect> effects = new ArrayList<Effect>();
	/**
	 * Creates an Action.
	 * @param name the name of the action performed.
	 */
	public Action(String name) {
		this.name = name;
	}
	/**
	 * The name of the action.
	 * @return name of the action.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Player can add an item to the inventory.
	 * @param item the item the player will have within the game.
	 */
	public void addRequiredItem(Item item) {
		items.add(item);
		
	}
	/**
	 * Player to perform a action if allowed.
	 * @param player the player within the game performing the action.
	 * @return  true if the player can perform the action and false if the player cannot.
	 */
	public boolean isAllowed(Player player) {
		boolean isAllowed = true;
		for (Item item :this.items) {
			isAllowed = isAllowed && player.canSeeItem(item);
		}
		return isAllowed;
		
	}
	/**
	 * This method adds an effect of the action.
	 * @param effect the effect which is in the game.
	 */
	public void addEffect(Effect effect) {
		effects.add(effect);
	}
	/**
	 * Returns a list of effects
	 * @return a list of effects
	 */
	public List<Effect> getEffects() {
		return Collections.unmodifiableList(effects);
	}
}
