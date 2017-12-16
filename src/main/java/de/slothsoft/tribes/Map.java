package de.slothsoft.tribes;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * A basic map with tiles.
 *
 * @since 1.0.0
 */

public class Map {

	final Random rnd = new Random();
	final Tile[][] tiles;
	final int width;
	final int height;

	public Map(int width, int height) {
		this(new Tile[width][height]);
	}

	public Map(Tile[][] tiles) {
		this.tiles = tiles;
		this.width = tiles.length;
		this.height = tiles[0].length;
	}

	public void executeRound() {
		final Tile[][] nextRoundMap = new Tile[this.width][this.height];

		for (int x = 0; x < this.tiles.length; x++) {
			for (int y = 0; y < this.tiles[x].length; y++) {
				final Tile tile = this.tiles[x][y];
				if (tile != null) {
					executeRoundForTile(nextRoundMap, tile, x, y);
				}
			}
		}

		// copy next round tiles to used array
		for (int x = 0; x < this.tiles.length; x++) {
			for (int y = 0; y < this.tiles[x].length; y++) {
				this.tiles[x][y] = nextRoundMap[x][y];
			}
		}
	}

	private void executeRoundForTile(Tile[][] nextRoundMap, Tile tile, int x, int y) {
		final Action action = tile.executeRound();
		if (action == null) return;

		switch (action) {
			case SPLIT_UP :
				slitTribe(nextRoundMap, tile, x, y);
				break;
			default :
				moveTile(nextRoundMap, tile, action, x, y);
		}
	}

	private void slitTribe(Tile[][] nextRoundMap, Tile tile, int x, int y) {
		final List<Point> availablePoints = calculateAvailablePoints(x, y);
		final Point usedPoint = availablePoints.get(this.rnd.nextInt(availablePoints.size()));

		final int tribeSize = tile.getTribeSize();
		final int halfTribeSize = tribeSize / 2;
		tile.setTribeSize(tile.getTribeSize() - halfTribeSize);

		fillTile(nextRoundMap, tile, x, y);
		if (halfTribeSize > 0) {
			fillTile(nextRoundMap, new Tile(tile.getTribe()).tribeSize(halfTribeSize), usedPoint.x, usedPoint.y);
		}
	}

	private List<Point> calculateAvailablePoints(int x, int y) {
		final List<Point> points = new ArrayList<>();
		final Point left = new Point(sanitizeX(x - 1), y);
		if (isTileEmpty(left)) {
			points.add(left);
		}
		final Point right = new Point(sanitizeX(x + 1), y);
		if (isTileEmpty(right)) {
			points.add(right);
		}
		final Point top = new Point(x, sanitizeY(y - 1));
		if (isTileEmpty(top)) {
			points.add(top);
		}
		final Point bottom = new Point(x, sanitizeY(y + 1));
		if (isTileEmpty(bottom)) {
			points.add(bottom);
		}
		// if there was no point available, all points are available
		if (points.isEmpty()) {
			points.addAll(Arrays.asList(left, right, top, bottom));
		}
		return points;
	}

	private boolean isTileEmpty(Point point) {
		return this.tiles[point.x][point.y] == null;
	}

	private void moveTile(Tile[][] nextRoundMap, Tile tile, Action action, int x, int y) {
		final int newX = sanitizeX(action.getNextRoundX(x));
		final int newY = sanitizeY(action.getNextRoundY(y));

		fillTile(nextRoundMap, tile, newX, newY);
	}

	private static void fillTile(Tile[][] nextRoundMap, Tile tile, final int x, final int y) {
		if (nextRoundMap[x][y] == null) {
			nextRoundMap[x][y] = tile;
		} else {
			nextRoundMap[x][y].getAttackedBy(tile);
		}
	}

	private int sanitizeX(int x) {
		int newX = x;
		if (newX < 0) {
			newX += this.width;
		}
		if (newX >= this.width) {
			newX -= this.width;
		}
		return newX;
	}

	private int sanitizeY(int y) {
		int newY = y;
		if (newY < 0) {
			newY += this.height;
		}
		if (newY >= this.height) {
			newY -= this.height;
		}
		return newY;
	}

	public Set<Tribe> getExistingTribes() {
		final Set<Tribe> result = new HashSet<>();
		for (final Tile[] row : this.tiles) {
			for (final Tile tile : row) {
				if (tile != null) {
					result.add(tile.getTribe());
				}
			}
		}
		return result;
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}

	public Tile[][] getTiles() {
		final Tile[][] result = new Tile[this.tiles.length][];
		for (int i = 0; i < this.tiles.length; i++) {
			result[i] = this.tiles[i].clone();
		}
		return result;
	}

}
