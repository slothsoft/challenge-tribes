package de.slothsoft.tribes;

/**
 * Actions tribes can do during their round.
 *
 * @author Stef Schulz
 * @since 1.0.0
 */

public enum Action {
	/** Moves the tribe right. */
	MOVE_RIGHT(1, 0),
	/** Moves the tribe left. */
	MOVE_LEFT(-1, 0),
	/** Moves the tribe up. */
	MOVE_UP(0, -1),
	/** Moves the tribe down. */
	MOVE_DOWN(0, 1),
	/** Splits the tribe into two. */
	SPLIT_UP(0, 0),
	/** Skip this round. Tribe does not move nor split up. */
	SETTLE(0, 0),

	;

	private int nextRoundXIncrement;
	private int nextRoundYIncrement;

	private Action(int nextRoundXIncrement, int nextRoundYIncrement) {
		this.nextRoundXIncrement = nextRoundXIncrement;
		this.nextRoundYIncrement = nextRoundYIncrement;
	}

	public int getNextRoundX(int x) {
		return x + this.nextRoundXIncrement;
	}

	public int getNextRoundY(int y) {
		return y + this.nextRoundYIncrement;
	}
}