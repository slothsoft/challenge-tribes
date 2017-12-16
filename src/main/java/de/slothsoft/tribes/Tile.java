package de.slothsoft.tribes;

import java.util.Objects;

/**
 * A tile of the {@link Map}.
 *
 * @since 1.0.0
 */

public class Tile implements Tribe.Context {

	private Tribe tribe;
	private int size = 1;

	public Tile(Tribe tribe) {
		this.tribe = Objects.requireNonNull(tribe);
	}

	public Action executeRound() {
		this.size = (int) (Tribe.GROW_FACTOR * this.size + Tribe.GROW_SUMMAND);
		final Action action = this.tribe.execute(this);
		return action;
	}

	public void getAttackedBy(Tile tile) {
		if (tile.getTribe() == this.tribe) {
			// same tribe
			this.size += tile.getTribeSize();
		} else {
			if (this.size == tile.getTribeSize()) {
				// different tribes, same size. a random one wins
				if (Math.random() >= 0.5) {
					this.tribe = tile.getTribe();
				}
			} else if (this.size < tile.getTribeSize()) {
				// we are smaller: replace
				this.tribe = tile.getTribe();
			}
		}
	}

	public Tribe getTribe() {
		return this.tribe;
	}

	public Tile tribeSize(int newSize) {
		setTribeSize(newSize);
		return this;
	}

	public void setTribeSize(int size) {
		this.size = size;
	}

	@Override
	public int getTribeSize() {
		return this.size;
	}

}
