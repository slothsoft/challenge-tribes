package de.slothsoft.tribes;

public enum Action {
	MOVE_RIGHT(1, 0),

	MOVE_LEFT(-1, 0),

	MOVE_UP(0, -1),

	MOVE_DOWN(0, 1),

	SPLIT_UP(0, 0),

	SETTLE(0, 0),;

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