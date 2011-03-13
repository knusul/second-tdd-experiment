package tetris;

import junit.framework.TestCase;

public class MovingBlackTest extends TestCase {
	Board board;

	public void setUp() {
		board = new Board(3, 3);
		board.drop(new Block('X'));
	}

	public void testShouldMoveBlockLeft() {
		board.moveFallingBlockLeft();
		assertEquals("" + "X..\n" + "...\n" + "...\n", board.toString());
	}

	public void testShouldNotAllowToMoveBlockOutsideBoard() {
		board.moveFallingBlockLeft();
		board.moveFallingBlockLeft();
		board.moveFallingBlockLeft();
		assertEquals("" + "X..\n" + "...\n" + "...\n", board.toString());
	}

	public void testShouldMoveBlockRight() {
		board.moveFallingBlockRight();
		assertEquals("" + "..X\n" + "...\n" + "...\n", board.toString());
	}

	public void testShouldNotAllowToMoveBlockOutsideRight() {
		board.moveFallingBlockRight();
		board.moveFallingBlockRight();
		board.moveFallingBlockRight();
		assertEquals("" + "..X\n" + "...\n" + "...\n", board.toString());
	}

	public void testShouldAllowToMoveBlockWhenAboveAnotherBlock() {
		board.tick();
		board.tick();
		board.tick();
		board.drop(new Block('X'));
		board.tick();
		board.moveFallingBlockRight();
		board.moveFallingBlockRight();
		board.moveFallingBlockRight();
		assertEquals("" + "...\n" + "..X\n" + ".X.\n", board.toString());
	}

	public void testShouldNotAllowToMoveBlockWhenLandedOnAnotherBlock() {
		board.tick();
		board.tick();
		board.tick();
		board.drop(new Block('X'));
		board.tick();
		board.tick();
		board.moveFallingBlockRight();
		board.moveFallingBlockRight();
		board.moveFallingBlockRight();
		assertEquals("" + "...\n" + ".X.\n" + ".X.\n", board.toString());
	}
}
