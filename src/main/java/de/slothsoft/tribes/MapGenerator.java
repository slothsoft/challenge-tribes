package de.slothsoft.tribes;

import java.awt.Point;
import java.util.List;
import java.util.Random;

/**
 * A generator for {@link Map}.
 *
 * @since 1.0.0
 */

public class MapGenerator {

	private final Random rnd = new Random();
	private int width = 40;
	private int height = 30;
	private List<Tribe> possibleTribes;
	private int tribeCount = 5;

	public Map generate() {
		final Map map = new Map(this.width, this.height);

		for (final Tribe tribe : this.possibleTribes == null ? Tribes.fetchAllImplementations() : this.possibleTribes) {
			for (int i = 0; i < this.tribeCount; i++) {
				final Point startPoint = generateStartPoint(map.tiles);
				map.tiles[startPoint.x][startPoint.y] = new Tile(tribe);
			}
		}
		return map;
	}

	private Point generateStartPoint(Tile[][] tiles) {
		final Point point = new Point();
		do {
			point.x = this.rnd.nextInt(this.width);
			point.y = this.rnd.nextInt(this.height);
		} while (tiles[point.x][point.y] != null);
		return point;
	}

	public int getHeight() {
		return this.height;
	}

	public MapGenerator height(int newHeight) {
		setHeight(newHeight);
		return this;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	public MapGenerator width(int newWidth) {
		setWidth(newWidth);
		return this;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public List<Tribe> getPossibleTribes() {
		return this.possibleTribes;
	}

	public MapGenerator possibleTribes(List<Tribe> newPossibleTribes) {
		setPossibleTribes(newPossibleTribes);
		return this;
	}

	public void setPossibleTribes(List<Tribe> possibleTribes) {
		this.possibleTribes = possibleTribes;
	}

	public int getTribeCount() {
		return this.tribeCount;
	}

	public MapGenerator tribeCount(int newTribeCount) {
		setTribeCount(newTribeCount);
		return this;
	}

	public void setTribeCount(int tribeCount) {
		this.tribeCount = tribeCount;
	}

}
