package tetris;

import junit.framework.TestCase;

public class NewBoardTest extends TestCase {
	private Board board;

	public void setUp() {
		board = new Board(3, 3);
	}

	public void testShouldSetEmptyTableForNewBoard() {
		assertEquals("" + "...\n" + "...\n" + "...\n", board.toString());
	}

	public void testShouldHasNoFallingBlocks() {
		assertFalse(board.isFallingBlock());
	}
}
