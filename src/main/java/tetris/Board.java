package tetris;

import java.util.Arrays;

public class Board {
	private static final char EMPTY = '.';
	private Block fallingBlock;
	private char[][] board;

	public Board(int rows, int columns) {
		board = new char[rows][columns];
		for (char[] tmp : board) {
			Arrays.fill(tmp, EMPTY);
		}
	}

	public boolean isFallingBlock() {
		return fallingBlock != null;
	}

	public void drop(Block block) {
		if (isFallingBlock()) {
			throw new IllegalStateException(
					"Another block may not be dropped when one is already falling");
		}
		fallingBlock = block.moveTo(0, columns() / 2);

	}

	private int columns() {
		return board[0].length;
	}

	public void tick() {
		Block test = fallingBlock.moveDown();
		if (conflictsWithBoard(test)) {
			stopFallingBlock();
		} else {
			fallingBlock = test;
		}
	}

	public void moveFallingBlockLeft() {
		if (fallingBlock != null) {
			Block test = fallingBlock.moveLeft();
			if (!conflictsWithBoard(test)) {
				fallingBlock = test;
			}
		}
	}

	public void moveFallingBlockRight() {
		if (fallingBlock != null) {
			Block test = fallingBlock.moveRight();
			if (!conflictsWithBoard(test)) {
				fallingBlock = test;
			}
		}
	}

	private void stopFallingBlock() {
		assert isFallingBlock();
		copyToBoard(fallingBlock);
		fallingBlock = null;
	}

	private void copyToBoard(Block block) {
		board[block.row()][block.col()] = block.style();
	}

	private boolean conflictsWithBoard(Block block) {
		return outsideBoard(block) || hitsAnotherBlock(block);
	}

	private boolean outsideBoard(Block block) {
		return block.row() >= rows() || block.col() >= columns()
				|| block.col() < 0;
	}

	private int rows() {
		return board.length;
	}

	private boolean hitsAnotherBlock(Block block) {
		return board[block.row()][block.col()] != EMPTY;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				sb.append(cellAt(row, col));
			}
			sb.append('\n');
		}
		return sb.toString();
	}

	private char cellAt(int row, int col) {
		if (fallingBlock != null && fallingBlock.isAt(row, col)) {
			return fallingBlock.style();
		} else {
			return board[row][col];
		}
	}

}
