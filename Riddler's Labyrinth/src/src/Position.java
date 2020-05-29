package src;

public class Position {
	
	// Instance variables
	private int _row;
	private int _col;
	
	// getters
	public int getRow() { return _row; }
	public int getCol() { return _col; }
	
	// Constructor
	public Position(int r, int c) {
		_row = r;
		_col = c;
	}
}
