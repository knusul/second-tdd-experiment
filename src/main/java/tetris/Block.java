package tetris;

public class Block {

	private final int row;
	private final int col;
	private final char style;

	public Block(char style) {
		this(0, 0, style);
	}

	private Block(int row, int col, char style) {
		this.row = row;
		this.col = col;
		this.style = style;
	}

	public int row() {
		return row;
	}

	public int col() {
		return col;
	}

	public char style() {
		return style;
	}

	public boolean isAt(int row, int col) {
		return row == this.row && col == this.col;
	}

	public Block moveTo(int row, int col) {
		return new Block(row, col, style);
	}

	public Block moveDown() {
		return new Block(row + 1, col, style);
	}

	public Block moveLeft() {
		return new Block(row, col - 1, style);
	}

	public Block moveRight() {
		return new Block(row, col + 1, style);
	}
}
