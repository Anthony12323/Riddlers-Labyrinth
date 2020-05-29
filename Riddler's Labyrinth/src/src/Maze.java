package src;

public class Maze {
	
	// Instance Variables
	private boolean[][] _maze;
	private Position _start;
	private Position _end;
	public Position _mmap;
	
	private static final int PLAYER_START_ROW = 6;
	private static final int PLAYER_START_COL = 5;
	private static final int PLAYER_END_ROW = 11;
	private static final int PLAYER_END_COL = 11;

	
	public Position getStart() { return _start; }
	public Position getEnd() { return _end; }
	
	
	public boolean[][] getMaze() { return _maze; }
	
	// Constructor (Initializes maze to a 2d array of walls and corridors to represent the maze, also sets the start end end position in said maze)
	public Maze() {
		// true is a wall.
		boolean[][] maze = 
			{{true, true,  true, true, true, true, true, true, true, true, true, true,  true},//0
			 {true, false, false,false,true, true, true, true, false,false,false,false, true},
			 {true, false, true, false,false,false,false,false,false, true, true, false, true},
			 {true, false, true, true, true, true, true, true, true, true, true, false, true},
			 {true, false, true, false,false,false,false,false,false,false,true, false, true},
			 {true, false, true, false,true, true, true, true, true, false,true, false, true},//5
			 {true, false, true, false,true, false,false,false,true, false,true, false, true},
			 {true, false, true, false,true, true, true, false,true, false,true, false, true},
			 {true, false, true, false,false,false,false,false,true, false,true, false, true},
			 {true, false, true, true, true, true, true, true, true, false,true, false, true},
			 {true, false, false,false,false,false,false,false,false,false,true, false, true},//10
			 {true, true,  true, true, true, true, true, true, true, true, true, false, true},
			};
		_maze = maze;
		_start = new Position(PLAYER_START_ROW, PLAYER_START_COL);
		_end = new Position(PLAYER_END_ROW, PLAYER_END_COL);
	}
}