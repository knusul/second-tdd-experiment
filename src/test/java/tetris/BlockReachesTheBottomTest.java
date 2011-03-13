package tetris;

import junit.framework.TestCase;

public class BlockReachesTheBottomTest extends TestCase {

	Board board;
	public void setUp(){
		 board = new Board(3, 3);
	        board.drop(new Block('X'));
	        board.tick();
	        board.tick();
	}
    public void testShouldStillFallingOnTheLastRow() {
        assertTrue(board.isFallingBlock());
        assertEquals("" +
                "...\n" +
                "...\n" +
                ".X.\n", board.toString());
    }

    public void testShouldStopFailingWhenItHitsTheBottom() {
        board.tick();
        assertFalse(board.isFallingBlock());
        assertEquals("" +
                "...\n" +
                "...\n" +
                ".X.\n", board.toString());
    }

}
