package de.slothsoft.tribes.gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

import de.slothsoft.tribes.Map;
import de.slothsoft.tribes.Tile;
import de.slothsoft.tribes.Tribe;

/**
 * A renderer that displays the entire {@link Map}.
 *
 * @author Stef Schulz
 * @since 1.0.0
 */

public class MapRenderer {

	static final int BORDER_WIDTH = 2;
	static final int WIDTH_IN_PIXELS = 1;
	static final int HEIGHT_IN_PIXELS = 1;

	/**
	 * Paints a map
	 *
	 * @param graphics graphics
	 * @param map block array
	 */

	public void paintMap(Graphics2D graphics, Map map) {
		graphics.setColor(Color.DARK_GRAY);
		graphics.fillRect(0, 0, map.getWidth() + 2, map.getHeight() + 2);

		graphics.setColor(Color.WHITE);
		graphics.fillRect(WIDTH_IN_PIXELS, HEIGHT_IN_PIXELS, map.getWidth() * WIDTH_IN_PIXELS,
				map.getHeight() * HEIGHT_IN_PIXELS);

		graphics.translate(1, 1);
		paintTiles(graphics, map.getTiles());
		graphics.translate(-1, -1);
	}

	/**
	 * Paints an entire tile array
	 *
	 * @param graphics graphics
	 * @param tiles tiles array
	 */

	protected void paintTiles(Graphics2D graphics, Tile[][] tiles) {
		for (int xi = 0; xi < tiles.length; xi++) {
			for (int yi = 0; yi < tiles[xi].length; yi++) {
				if (tiles[xi][yi] != null) {
					graphics.translate(xi * WIDTH_IN_PIXELS, yi * HEIGHT_IN_PIXELS);
					paintTribe(graphics, tiles[xi][yi].getTribe(), tiles[xi][yi].getTribeSize());
					graphics.translate(-xi * WIDTH_IN_PIXELS, -yi * HEIGHT_IN_PIXELS);
				}
			}
		}
	}

	protected void paintTribe(Graphics2D graphics, Tribe tribe, int tribeSize) {
		graphics.setComposite(AlphaComposite.SrcOver
				.derive((float) Math.min(Tribe.MAX_TRIBE_SIZE, tribeSize) / Tribe.MAX_TRIBE_SIZE));
		paintTribe(graphics, tribe);
		graphics.setComposite(AlphaComposite.SrcOver);
	}

	/**
	 * Paints a single tile of the map
	 *
	 * @param graphics graphics
	 * @param tribe the tribe to be painted
	 */

	public void paintTribe(Graphics2D graphics, Tribe tribe) {
		graphics.setColor(tribe.getColor());
		graphics.fillRect(0, 0, WIDTH_IN_PIXELS, HEIGHT_IN_PIXELS);
	}

}
