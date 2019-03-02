package de.slothsoft.tribes.contrib;

import java.awt.Color;

import de.slothsoft.tribes.Action;
import de.slothsoft.tribes.Tribe;

/**
 * A demo tribe. Romans settle and split when they are above {@link Tribe#MAX_TRIBE_SIZE}.
 *
 * @author Stef Schulz
 * @since 1.0.0
 */

public class RomansTribe extends AbstractTribe {

	@Override
	public String getDisplayName() {
		return "Romans";
	}

	@Override
	public String getAuthor() {
		return "Slothsoft";
	}

	@Override
	public Color getColor() {
		return Color.RED;
	}

	@Override
	public Action execute(Context context) {
		if (context.getTribeSize() > MAX_TRIBE_SIZE) return Action.SPLIT_UP;
		return Action.SETTLE;
	}

}
