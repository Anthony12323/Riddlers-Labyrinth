package view;

import javax.swing.JOptionPane;

public class Window {

	// displays a message dialogue box
	public static void msg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	// displays an input dialogue box
	public String in(String msg) {
		return JOptionPane.showInputDialog(msg);
	}
	
	// displays an option dialogue box
	public int option(String[] options, String msg) {
		return JOptionPane.showOptionDialog(
				null, 
				msg, // my message
                "Click a button", // dialog box title
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, // possible options
                options[0]); // default option
	}
	
	// prints a line with msg
	public void println(String msg) {
		System.out.println(msg);
	}
	
	// prints msg
	public void print(String msg) {
		System.out.println(msg);
	}
	
	// displays a message dialogue box
	public void msg(Object msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	// displayes an input dialogue box
	public String in(Object msg) {
		return JOptionPane.showInputDialog(msg);
	}
	
	// displays an option dialogue box
	public int option(Object[] options, Object msg) {
		return JOptionPane.showOptionDialog(
				null, 
				msg, // my message
                "Click a button", // dialog box title
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, // possible options
                options[0]); // default option
	}
}