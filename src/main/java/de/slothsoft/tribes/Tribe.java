package de.slothsoft.tribes;

import java.awt.Color;

/**
 * The interface that does all the heavy work in this challenge.
 *
 * @author Stef Schulz
 * @since 1.0.0
 */

public interface Tribe {

	/**
	 * The maximum size for a tribe. After this value is achieved, a tribe will stop
	 * growing.
	 */
	int MAX_TRIBE_SIZE = 100;
	/**
	 * The factor to which a tribe's size increases each round.
	 */
	double GROW_FACTOR = 1.1;
	/**
	 * The minimum growth of the tribe each round.
	 */
	int GROW_SUMMAND = 1;

	/**
	 * Returns the display name of the tribe.
	 *
	 * @return a string or class name on default
	 */

	default String getDisplayName() {
		return getClass().getSimpleName();
	}

	/**
	 * Returns the author of the tribe.
	 *
	 * @return a string or "unknown" on default
	 */

	default String getAuthor() {
		return "unknown";
	}

	/**
	 * Returns the color of the tribe.
	 *
	 * @return a color or RED on default
	 */

	default Color getColor() {
		return Color.RED;
	}

	/**
	 * Executes a round for this tribe.
	 *
	 * @return the action the tribe should do this round.
	 */

	Action execute(Context context);

	/**
	 * A context the tribe gets to consider which action to take.
	 */

	interface Context {

		/**
		 * Returns the current size of the tribe.
		 *
		 * @return the tribe's current size
		 */

		int getTribeSize();
	}

}
