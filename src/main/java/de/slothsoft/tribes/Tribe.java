package de.slothsoft.tribes;

import java.awt.Color;

public interface Tribe {

	int MAX_TRIBE_SIZE = 100;
	double GROW_FACTOR = 1.1;
	int GROW_SUMMAND = 1;

	default String getDisplayName() {
		return getClass().getSimpleName();
	}

	default String getAuthor() {
		return "unknown";
	}

	default Color getColor() {
		return Color.RED;
	}

	Action execute(Context context);

	interface Context {

		int getTribeSize();
	}

}
