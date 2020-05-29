package view;
	
	import java.awt.GridLayout;

import javax.swing.*;

import src.*;

public class StringMap extends JFrame {

	// Instance Variables
	private static final long serialVersionUID = 1L;
	Window _w;

	private JPanel _map = new JPanel(new GridLayout(12, 13));

	private JLabel[][] Maze = new JLabel[12][13];

	// Constructor
	public StringMap() {

	}

	// Getter
	public JPanel getMap() {
		return _map;
	}

	// Icons (images being initialized)
	private Icon wall2 = new ImageIcon(getClass().getResource("bdad2c52f60f35e0de44cd3cc2b16da2.png"));
	private Icon player2 = new ImageIcon(getClass().getResource("f5f0056fb074b03.jpg"));
	private Icon floor2 = new ImageIcon(getClass().getResource("black-square.jpg"));
	private Icon exit2 = new ImageIcon(getClass().getResource("48e89c92f90110b275a79aee8bd36d55.jpg"));
	private Icon Q1 = new ImageIcon(getClass().getResource("black-square.jpg"));
	private Icon Q2 = new ImageIcon(getClass().getResource("black-square.jpg"));
	private Icon Q3 = new ImageIcon(getClass().getResource("black-square.jpg"));
	private Icon Q4 = new ImageIcon(getClass().getResource("black-square.jpg"));
	private Icon Q5 = new ImageIcon(getClass().getResource("black-square.jpg"));
	private Icon Q6 = new ImageIcon(getClass().getResource("black-square.jpg"));
	
	// Visually updates the map according to where the player is moving and checks every time the player moves for questions and when they win.
	public JPanel updateMap(Player p, Maze z, String userIn, Window _w, Question q1) {
		_map = new JPanel(new GridLayout(12, 13));
		if(p.isAlive() == true) {
		if (userIn.equals("NORTH")) {
			if (z.getMaze()[p.getPosition().getRow()-1][p.getPosition().getCol()] == false) {
				p.move(Direction.North, z);
				gameCheck(p, z, userIn,  _w, q1);
			} 
		}
		else if (userIn.equals("SOUTH")) {
			if (z.getMaze()[p.getPosition().getRow()+1][p.getPosition().getCol()] == false){
				p.move(Direction.South, z);
				gameCheck(p, z, userIn,  _w, q1);
				
			}
		}
		else if (userIn.equals("WEST")) {
			if (z.getMaze()[p.getPosition().getRow()][p.getPosition().getCol()-1] == false) {
				p.move(Direction.West, z);
				//gameCheck1(p, m, z, r1, r2, r3,  userIn,  _w,  sw, ma);
				gameCheck(p, z, userIn,  _w, q1);
			
			} 
		}
		else if (userIn.equals("EAST")) {
			if (z.getMaze()[p.getPosition().getRow()][p.getPosition().getCol()+1] == false) {
				p.move(Direction.East, z);
				gameCheck(p, z, userIn,  _w, q1);
				
			} 
		}
		}
		for (int r = 0; r < z.getMaze().length; r++) {
			for (int c = 0; c < z.getMaze()[r].length; c++) {
				//if userIn.equals("NORTH") move player r by - 1 if empty space above
				
				if (z.getMaze()[r][c]) {
					Maze[r][c] = new JLabel(wall2);
					_map.add(Maze[r][c]);
				} else if (r == p.getPosition().getRow() &&
						c == p.getPosition().getCol()) {
					Maze[r][c] = new JLabel(player2);
					_map.add(Maze[r][c]);
				
				} else if (r == z.getEnd().getRow() &&
						c == z.getEnd().getCol()) {
					Maze[r][c] = new JLabel(exit2);
					_map.add(Maze[r][c]);
				
			} else if (null != q1.getQuestPos1() && r == q1.getQuestPos1().getRow() &&
					c == q1.getQuestPos1().getCol()) {
				Maze[r][c] = new JLabel(Q1);
				_map.add(Maze[r][c]);
			}
			else if (null != q1.getQuestPos2() && r == q1.getQuestPos2().getRow() &&
					c == q1.getQuestPos2().getCol()) {
				Maze[r][c] = new JLabel(Q2);
				_map.add(Maze[r][c]);
			}
			else if (null != q1.getQuestPos3() && r == q1.getQuestPos3().getRow() &&
					c == q1.getQuestPos3().getCol()) {
				Maze[r][c] = new JLabel(Q3);
				_map.add(Maze[r][c]);
			}
			else if (null != q1.getQuestPos4() && r == q1.getQuestPos4().getRow() &&
					c == q1.getQuestPos4().getCol()) {
				Maze[r][c] = new JLabel(Q4);
				_map.add(Maze[r][c]);
			}
			else if (null != q1.getQuestPos5() && r == q1.getQuestPos5().getRow() &&
					c == q1.getQuestPos5().getCol()) {
				Maze[r][c] = new JLabel(Q5);
				_map.add(Maze[r][c]);
			}
			else if (null != q1.getQuestPos6() && r == q1.getQuestPos6().getRow() &&
					c == q1.getQuestPos6().getCol()) {
				Maze[r][c] = new JLabel(Q6);
				_map.add(Maze[r][c]);
			}
			else {
					Maze[r][c] = new JLabel(floor2);
					_map.add(Maze[r][c]);
				}

			}
		}
		return _map;
	}
	
	// Checks if the player is at a question or at the end of the game and responds accordingly, either by asking the question or with the end game screen.
	public void gameCheck(Player _p,  Maze _z, String userIn, Window _w, Question q1) {
		if (_p.getPosition().getRow() == _z.getEnd().getRow() && _p.getPosition().getCol() == _z.getEnd().getCol()) {
			_p.killPlayer();
			JOptionPane.showMessageDialog(null, "You feel a breeze and hear a voice whisper 'You have done well, I will grant you another chance, don't mess it up again.'");
			JOptionPane.showMessageDialog(null, "Maybe something happened in your past life... i mean... 'my' past life");
			JOptionPane.showMessageDialog(null, "*** The Riddler's Labyrinth ***");
			System.exit(0);
		}
		if (null != q1.getQuestPos1() &&_p.getPosition().getRow() == q1.getQuestPos1().getRow() && _p.getPosition().getCol() == q1.getQuestPos1().getCol()) {
			if(q1.randomQuestion1(_z,_p)) q1.setQuestion(1);
		}
		if (null != q1.getQuestPos2() &&_p.getPosition().getRow() == q1.getQuestPos2().getRow() && _p.getPosition().getCol() == q1.getQuestPos2().getCol()) {
			if(q1.randomQuestion2(_z,_p)) q1.setQuestion(2);
		}
		if (null != q1.getQuestPos3() &&_p.getPosition().getRow() == q1.getQuestPos3().getRow() && _p.getPosition().getCol() == q1.getQuestPos3().getCol()) {
			if(q1.randomQuestion3(_z,_p)) q1.setQuestion(3);
		}
		if (null != q1.getQuestPos4() &&_p.getPosition().getRow() == q1.getQuestPos4().getRow() && _p.getPosition().getCol() == q1.getQuestPos4().getCol()) {
			if(q1.randomQuestion4(_z,_p)) q1.setQuestion(4);
		}
		if (null != q1.getQuestPos5() &&_p.getPosition().getRow() == q1.getQuestPos5().getRow() && _p.getPosition().getCol() == q1.getQuestPos5().getCol()) {
			if(q1.randomQuestion5(_z,_p)) q1.setQuestion(5);
		}
		if (null != q1.getQuestPos6() &&_p.getPosition().getRow() == q1.getQuestPos6().getRow() && _p.getPosition().getCol() == q1.getQuestPos6().getCol()) {
			if(q1.randomQuestion6(_z,_p)) q1.setQuestion(6);
		}
	}
}