package de.slothsoft.tribes;

import org.junit.Assert;
import org.junit.Test;

public class MapTest {

	@Test
	public void testSettle() throws Exception {
		final Map map = new Map(3, 3);
		map.tiles[1][1] = new Tile(c -> Action.SETTLE);
		map.executeRound();

		Assert.assertNull(map.tiles[0][0]);
		Assert.assertNull(map.tiles[0][1]);
		Assert.assertNull(map.tiles[0][2]);

		Assert.assertNull(map.tiles[1][0]);
		Assert.assertNotNull(map.tiles[1][1]);
		Assert.assertNull(map.tiles[1][2]);

		Assert.assertNull(map.tiles[2][0]);
		Assert.assertNull(map.tiles[2][1]);
		Assert.assertNull(map.tiles[2][2]);

		Assert.assertTrue("Tribe should have gotten bigger!", map.tiles[1][1].getTribeSize() > 1);
	}

	@Test
	public void testMoveDown() throws Exception {
		final Map map = new Map(3, 3);
		map.tiles[1][1] = new Tile(c -> Action.MOVE_DOWN);
		map.executeRound();

		Assert.assertNull(map.tiles[0][0]);
		Assert.assertNull(map.tiles[0][1]);
		Assert.assertNull(map.tiles[0][2]);

		Assert.assertNull(map.tiles[1][0]);
		Assert.assertNull(map.tiles[1][1]);
		Assert.assertNotNull(map.tiles[1][2]);

		Assert.assertNull(map.tiles[2][0]);
		Assert.assertNull(map.tiles[2][1]);
		Assert.assertNull(map.tiles[2][2]);
	}
	@Test
	public void testMoveDown_Overflow() throws Exception {
		final Map map = new Map(3, 3);
		map.tiles[1][2] = new Tile(c -> Action.MOVE_DOWN);
		map.executeRound();

		Assert.assertNull(map.tiles[0][0]);
		Assert.assertNull(map.tiles[0][1]);
		Assert.assertNull(map.tiles[0][2]);

		Assert.assertNotNull(map.tiles[1][0]);
		Assert.assertNull(map.tiles[1][1]);
		Assert.assertNull(map.tiles[1][2]);

		Assert.assertNull(map.tiles[2][0]);
		Assert.assertNull(map.tiles[2][1]);
		Assert.assertNull(map.tiles[2][2]);
	}

	@Test
	public void testMoveUp() throws Exception {
		final Map map = new Map(3, 3);
		map.tiles[1][1] = new Tile(c -> Action.MOVE_UP);
		map.executeRound();

		Assert.assertNull(map.tiles[0][0]);
		Assert.assertNull(map.tiles[0][1]);
		Assert.assertNull(map.tiles[0][2]);

		Assert.assertNotNull(map.tiles[1][0]);
		Assert.assertNull(map.tiles[1][1]);
		Assert.assertNull(map.tiles[1][2]);

		Assert.assertNull(map.tiles[2][0]);
		Assert.assertNull(map.tiles[2][1]);
		Assert.assertNull(map.tiles[2][2]);
	}

	@Test
	public void testMoveUp_Overflow() throws Exception {
		final Map map = new Map(3, 3);
		map.tiles[1][0] = new Tile(c -> Action.MOVE_UP);
		map.executeRound();

		Assert.assertNull(map.tiles[0][0]);
		Assert.assertNull(map.tiles[0][1]);
		Assert.assertNull(map.tiles[0][2]);

		Assert.assertNull(map.tiles[1][0]);
		Assert.assertNull(map.tiles[1][1]);
		Assert.assertNotNull(map.tiles[1][2]);

		Assert.assertNull(map.tiles[2][0]);
		Assert.assertNull(map.tiles[2][1]);
		Assert.assertNull(map.tiles[2][2]);
	}

	@Test
	public void testMoveRight() throws Exception {
		final Map map = new Map(3, 3);
		map.tiles[1][1] = new Tile(c -> Action.MOVE_RIGHT);
		map.executeRound();

		Assert.assertNull(map.tiles[0][0]);
		Assert.assertNull(map.tiles[0][1]);
		Assert.assertNull(map.tiles[0][2]);

		Assert.assertNull(map.tiles[1][0]);
		Assert.assertNull(map.tiles[1][1]);
		Assert.assertNull(map.tiles[1][2]);

		Assert.assertNull(map.tiles[2][0]);
		Assert.assertNotNull(map.tiles[2][1]);
		Assert.assertNull(map.tiles[2][2]);
	}

	@Test
	public void testMoveRight_Overflow() throws Exception {
		final Map map = new Map(3, 3);
		map.tiles[2][1] = new Tile(c -> Action.MOVE_RIGHT);
		map.executeRound();

		Assert.assertNull(map.tiles[0][0]);
		Assert.assertNotNull(map.tiles[0][1]);
		Assert.assertNull(map.tiles[0][2]);

		Assert.assertNull(map.tiles[1][0]);
		Assert.assertNull(map.tiles[1][1]);
		Assert.assertNull(map.tiles[1][2]);

		Assert.assertNull(map.tiles[2][0]);
		Assert.assertNull(map.tiles[2][1]);
		Assert.assertNull(map.tiles[2][2]);
	}

	@Test
	public void testMoveLeft() throws Exception {
		final Map map = new Map(3, 3);
		map.tiles[1][1] = new Tile(c -> Action.MOVE_LEFT);
		map.executeRound();

		Assert.assertNull(map.tiles[0][0]);
		Assert.assertNotNull(map.tiles[0][1]);
		Assert.assertNull(map.tiles[0][2]);

		Assert.assertNull(map.tiles[1][0]);
		Assert.assertNull(map.tiles[1][1]);
		Assert.assertNull(map.tiles[1][2]);

		Assert.assertNull(map.tiles[2][0]);
		Assert.assertNull(map.tiles[2][1]);
		Assert.assertNull(map.tiles[2][2]);
	}

	@Test
	public void testMoveLeft_Overflow() throws Exception {
		final Map map = new Map(3, 3);
		map.tiles[0][1] = new Tile(c -> Action.MOVE_LEFT);
		map.executeRound();

		Assert.assertNull(map.tiles[0][0]);
		Assert.assertNull(map.tiles[0][1]);
		Assert.assertNull(map.tiles[0][2]);

		Assert.assertNull(map.tiles[1][0]);
		Assert.assertNull(map.tiles[1][1]);
		Assert.assertNull(map.tiles[1][2]);

		Assert.assertNull(map.tiles[2][0]);
		Assert.assertNotNull(map.tiles[2][1]);
		Assert.assertNull(map.tiles[2][2]);
	}

}
