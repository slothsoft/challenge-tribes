package de.slothsoft.tribes;

import java.awt.Point;
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

	public Map generate() {
		final Map map = new Map(this.width, this.height);

		int index = 0;
		for (final Tribe tribe : Tribes.fetchAllImplementations()) {
			map.tiles[7][index++] = new Tile(tribe);
			map.tiles[11][index++] = new Tile(tribe);
			map.tiles[19][index++] = new Tile(tribe);
		}
		return map;
	}

	private Point generateStartPoint(boolean[][] tiles) {
		final Point point = new Point();
		do {
			point.x = this.rnd.nextInt(this.width);
			point.y = this.rnd.nextInt(this.height);
		} while (tiles[point.x][point.y]);
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

}
