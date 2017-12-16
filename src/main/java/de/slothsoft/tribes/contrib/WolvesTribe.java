package de.slothsoft.tribes.contrib;

import java.awt.Color;
import java.util.Random;

import de.slothsoft.tribes.Action;

public class WolvesTribe extends AbstractTribe {

	private final Random rnd = new Random();
	private final Action[] actions = Action.values();

	@Override
	public String getDisplayName() {
		return "Wolves";
	}

	@Override
	public String getAuthor() {
		return "Slothsoft";
	}

	@Override
	public Color getColor() {
		return Color.GRAY;
	}

	@Override
	public Action execute(Context context) {
		Action action = this.actions[this.rnd.nextInt(this.actions.length)];
		if (context.getTribeSize() == 1 && action == Action.SPLIT_UP) {
			action = Action.SETTLE;
		}
		return action;
	}

}
