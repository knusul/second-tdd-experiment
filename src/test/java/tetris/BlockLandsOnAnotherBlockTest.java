package tetris;

import junit.framework.TestCase;

public class BlockLandsOnAnotherBlockTest extends TestCase {
	private Board board;

	protected void setUp() throws Exception {
		board = new Board(3, 3);
		board.drop(new Block('X'));
		board.tick();
		board.tick();
		board.tick();
		board.drop(new Block('Y'));
		board.tick();
	}

	public void testShouldStillFallingRightAboveTheOtherBlock() {
		assertTrue(board.isFallingBlock());
		assertEquals("" + "...\n" + ".Y.\n" + ".X.\n", board.toString());
	}

	public void testShouldStopsFailingWhenItHitsTheOtherBlock() {
		board.tick();
		assertFalse(board.isFallingBlock());
		assertEquals("" + "...\n" + ".Y.\n" + ".X.\n", board.toString());
	}
}
