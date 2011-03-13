package tetris;

import junit.framework.TestCase;

public class DroppedBlock extends TestCase {

	Board board;

	public void setUp() {
		board = new Board(3, 3);
		board.drop(new Block('X'));
	}

	public void testShouldReturnFailingBlock() {

		assertTrue(board.isFallingBlock());
	}

	public void testShouldStartsFailigFromTheTopMiddle() {
		assertEquals("" + ".X.\n" + "...\n" + "...\n", board.toString());
	}

	public void testShouldMovesDownOneRowPerTick() {
		board.tick();
		assertEquals("" + "...\n" + ".X.\n" + "...\n", board.toString());
	}

	public void testShouldAllowToFailOnlyWhanBlockAyTime() {
		try {
			board.drop(new Block('Y'));
			fail();
		} catch (IllegalStateException e) {
			assertTrue(e.getMessage().contains("already falling"));
		}
		assertEquals("" + ".X.\n" + "...\n" + "...\n", board.toString());
	}
}
