package de.slothsoft.tribes;

import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

/**
 * A start class for each game.
 *
 * @since 1.0.0
 */

public class Game {

	private final Map map;
	private final Thread thread = new Thread(this::run);

	private boolean stop = true;
	private long sleepTime = 100L;
	private Consumer<Tribe> onFinish = winner -> System.out
			.println(winner == null ? "Game finished. There were no survivors." : "Game finished. " + winner + " won.");

	public Game(Map map) {
		this.map = Objects.requireNonNull(map);
	}

	/**
	 * Starts the current game
	 */

	public void start() {
		this.stop = false;
		this.thread.start();
	}

	private void run() {
		while (!this.stop) {
			executeRound();
		}
	}

	private void executeRound() {
		executeRoundOnMap();

		if (isGameOver()) {
			finishGame();
			return;
		}

		try {
			Thread.sleep(this.sleepTime);
		} catch (final InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	private void executeRoundOnMap() {
		this.map.executeRound();
	}

	private boolean isGameOver() {
		return this.map.getExistingTribes().size() < 2;
	}

	private void finishGame() {
		stopGame();
		final Set<Tribe> existingTribes = this.map.getExistingTribes();
		this.onFinish.accept(existingTribes.isEmpty() ? null : existingTribes.iterator().next());
	}

	/**
	 * Stops the current game
	 */

	public void stopGame() {
		this.stop = true;
	}

	public Map getMap() {
		return this.map;
	}

	public Consumer<Tribe> getOnFinish() {
		return this.onFinish;
	}

	public Game onFinish(Consumer<Tribe> newOnFinish) {
		setOnFinish(newOnFinish);
		return this;
	}

	public void setOnFinish(Consumer<Tribe> onFinish) {
		this.onFinish = Objects.requireNonNull(onFinish);
	}

	public long getSleepTime() {
		return this.sleepTime;
	}

	public Game sleepTime(long newSleepTime) {
		setSleepTime(newSleepTime);
		return this;
	}

	public void setSleepTime(long sleepTime) {
		this.sleepTime = sleepTime;
	}

}
