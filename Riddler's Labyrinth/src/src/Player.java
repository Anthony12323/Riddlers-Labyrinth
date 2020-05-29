package src;

public class Player {
	
	// Instance variables
	
	public Position _curPos;
	
	private boolean _isAlive = true;
	
	// Getters
	
	public Position getPosition() { return _curPos; }
	
	public boolean isAlive() { return _isAlive; }
	
	// Setters
	
	public void setPosition(Position p) { _curPos = p; }
	
	public void killPlayer() { _isAlive = false; _curPos= new Position(1,0); }
	
	public Position setPosition(Maze z) { return  _curPos = new Position(z.getStart().getRow(), z.getStart().getCol()); }
	
	// Constructor
	
	public Player(Maze z) {
		_curPos = new Position(z.getStart().getRow(), z.getStart().getCol());
	}
	
	// Takes in a direction from input and moves the players position in the maze accordingly assuming the player is still alive.
	// returns false if dead. (question wrong)
	public boolean move(Direction d, Maze z) {
		if(_isAlive == true) {
		if(d == Direction.North) {
			if(_curPos.getRow() - 1 >= 0 && !z.getMaze()[_curPos.getRow() - 1]
					[_curPos.getCol()]) {
				_curPos = new Position(_curPos.getRow() - 1, _curPos.getCol());
				return true;
			}
		}
		else if(d == Direction.South) {
			if(_curPos.getRow() + 1 < z.getMaze().length && !z.getMaze()[_curPos.getRow() + 1]
					[_curPos.getCol()]) {
				_curPos = new Position(_curPos.getRow() + 1, _curPos.getCol());
				return true;
			}
		}
		else if(d == Direction.East) {
			if(_curPos.getCol() + 1 < z.getMaze()[_curPos.getRow()].length && !z.getMaze()[_curPos.getRow()]
					[_curPos.getCol() + 1]) {
				_curPos = new Position(_curPos.getRow(), _curPos.getCol() + 1);
				return true;
			}	
		}
		else {
			if(_curPos.getCol() - 1 >= 0 && !z.getMaze()[_curPos.getRow()][_curPos.getCol()- 1]) {
				_curPos = new Position(_curPos.getRow(), _curPos.getCol() - 1);
				return true;
			}
		}
		}
		return false;
	}

}