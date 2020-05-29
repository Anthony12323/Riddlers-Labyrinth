package cont;


import src.*;
import view.*;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
	
	private static JPanel scene;
	
	// main method
	public static void main(String[] args)  {
			Lab2();
	}

	// sets up the beginning text boxes as well as the keyListener for the game to later use to let the player move.
	// Uses KeyEvents and an Enum in order to keep track of movement throughout the game. Also initializes some behaviors 
	// such as setting resizable to false and the size of the screen.
	public static void Lab2() {
		final Question q = new Question();
		q.questionpick();
		final StringMap s = new StringMap();
		final JFrame fram = new JFrame();
		final Maze z = new Maze();
		final Player p = new Player(z);
		final Window _w = new Window();
		Window.msg("'The Riddler's Labrynth'");
		Window.msg("Press E to exit at any time, or H for help, answer the questions and reach the end. W A S D to move.");
		Window.msg("You awake in a cavernous pit with no recollection of why.");
		Window.msg("you immediately get this empty feeling in your stomach and legs. Only to realise you are but a spirit.");
		Window.msg("You must reach the exit of this dark place to find out what has happened and why you are here.");
		fram.setVisible(true);
		fram.setSize(800,800);
		fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fram.setResizable(false);
		scene = s.updateMap(p, z, "",  _w, q);
		fram.add(scene);

		fram.add(s.getMap());
		fram.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}

			public void keyReleased(KeyEvent e) { }

			public void keyPressed(KeyEvent e) {
				int input = e.getKeyCode();
				if (input == KeyEvent.VK_W) {
					scene = s.updateMap(p, z, "NORTH",  _w, q);
					fram.add(scene);
					fram.revalidate();
				} else if (input == KeyEvent.VK_S) {
				
					scene = s.updateMap(p, z, "SOUTH",  _w, q);
						
					fram.add(scene);
					fram.revalidate();
				} else if (input == KeyEvent.VK_D) {
				
					scene = s.updateMap(p, z, "EAST",  _w, q);
							
					fram.add(scene);
					fram.revalidate();
				} else if (input == KeyEvent.VK_A) {
				
					scene = s.updateMap(p, z, "WEST",  _w, q);
					
					fram.add(scene);
					fram.revalidate();
				}
				else if (input == KeyEvent.VK_E) {
				 	System.exit(0);
				}
			 	else if(input == KeyEvent.VK_H){
				 	Window.msg("Reach the end of the maze(the torch), but be wary, there is an uneasy feeling about this place.\n"
						 + " It seems there is some sort of phantasm that wishes to test our knowledge of history. Strange.");
			 	}
			};
		});

		fram.revalidate();
	}
}