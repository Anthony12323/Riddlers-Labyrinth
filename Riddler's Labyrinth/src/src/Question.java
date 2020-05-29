package src;

import view.*;

import java.util.ArrayList;
import java.util.Collections;

import src.Position;

public class Question {
	
	// Instance Variables
	
	private static Position _curPos1;
	private static Position _curPos2;
	private static Position _curPos3;
	private static Position _curPos4;
	private static Position _curPos5;
	private static Position _curPos6;
	private static Position _curPos7;
	private static Position _curPos8;
	private static Position _curPos9;
	private static Position _curPos10;
	private static Position _curPos11;
	private static Position _curPos12;
	private static Position _curPos13;
	private static Position _curPos14;
	private static Position _curPos15;
	private static boolean _isAlive1 = true;
	private static boolean _isAlive2 = true;
	private static boolean _isAlive3 = true;
	
	// Getters
	public boolean isAlive1() { return _isAlive1; }
	public boolean isAlive2() { return _isAlive2; }
	public boolean isAlive3() { return _isAlive3; }
	public Position getPosition1() { return _curPos1;	}
	public Position getPosition2() { return _curPos2;	}
	public Position getPosition3() { return _curPos3;	}
	public Position getPosition4() { return _curPos4;	}
	public Position getPosition5() { return _curPos5;	}
	public Position getPosition6() { return _curPos6;	}
	public Position getPosition7() { return _curPos7;	}
	public Position getPosition8() { return _curPos8;	}
	public Position getPosition9() { return _curPos9;	}
	public Position getPosition10() { return _curPos10;	}
	public Position getPosition11() { return _curPos11;	}
	public Position getPosition12() { return _curPos12;	}
	public Position getPosition13() { return _curPos13;	}
	public Position getPosition14() { return _curPos14;	}
	public Position getPosition15() { return _curPos15;	}

	public ArrayList<Position> positions =  new ArrayList<Position>();
	
	// adds questions to a list of positions (not to the actual maze yet)
	public void addQuestions() {
		positions.add(new Position(6,7));
		positions.add(new Position(8,7));
		positions.add(new Position(8,5));
		positions.add(new Position(8,3));
		positions.add(new Position(6,3));
		positions.add(new Position(4,3));
		positions.add(new Position(4,5)); 
		positions.add(new Position(4,7));
		positions.add(new Position(4,9)); 
		positions.add(new Position(6,9));
		positions.add(new Position(8,9)); 
		positions.add(new Position(10,9)); 
		positions.add(new Position(10,4));
		positions.add(new Position(6,1));
		positions.add(new Position(2,6));
	}
	
	public ArrayList<Position> positionsNew = new ArrayList<Position>();
	
	// Getters for question positions
	public Position getQuestPos1() {return positions.get(0);}

	public Position getQuestPos2() {return positions.get(1);}

	public Position getQuestPos3() {return positions.get(2);}

	public Position getQuestPos4() {return positions.get(3);}

	public Position getQuestPos5() {return positions.get(4);}
	
	public Position getQuestPos6() {return positions.get(5);}
	
	// sets 6 questions to the position at 0, 0
	
	public void setQuestion(int s){
		if (s==1) {
			positions.set(0, new Position(0,0));
		}
		if (s==2) {
			positions.set(1, new Position(0,0));
		}
		if (s==3) {
			positions.set(2, new Position(0,0));
		}
		if (s==4) {
			positions.set(3, new Position(0,0));
		}
		if (s==5) {
			positions.set(4, new Position(0,0));
		}
		if (s==6) {
			positions.set(5, new Position(0,0));
		}
	}
	
	// randomizes questions to pick for each game
	public void questionpick() {
		addQuestions();
		Collections.shuffle(positions);
		newList();
		Collections.shuffle(nums);
	}
	ArrayList<Integer> nums = new ArrayList<Integer>();
	
	// adds the questions numbers to nums
	public void newList() {
		nums.add(0);
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		nums.add(6);
		nums.add(7);
		nums.add(8);
		nums.add(9);
		nums.add(10);
		nums.add(11);
	}
	
	// initialize the randomly selected questions in the maze
	public boolean randomQuestion1(Maze z, Player p){
		int num1 = nums.get(0);
		askQuestions(num1,z,p);
		return true;
	}
	public boolean randomQuestion2(Maze z, Player p){
		int num2 =  nums.get(1);
		askQuestions(num2,z,p);
		return true;
	}
	public boolean randomQuestion3(Maze z, Player p){
		int num3 =  nums.get(2);
		askQuestions(num3,z,p);
		return true;
	}
	public boolean randomQuestion4(Maze z, Player p){
		int num4 =  nums.get(3);
		askQuestions(num4,z,p);
		return true;
	}
	public boolean randomQuestion5(Maze z, Player p){
		int num5 =  nums.get(4);
		askQuestions(num5,z,p);
		return true;
	}
	public boolean randomQuestion6(Maze z, Player p){
		int num6 = nums.get(5);
		askQuestions(num6,z,p);
		return true;
	}
	
	// Sets the text for all the questions in the game and properly sets them up in a JOptionPane input box where the user can
	// type in their responses for the question and the game responds accordingly.
	public static boolean askQuestions(int s, Maze z, Player p) {
		if(s == 0) {
		Window Msg = new Window();
		String b = Msg.in("Who was the second president of America? (last name)"); // question
		if(b==null)
        		{
			Window.msg("I am disappointed in your lack of effort"); // x button
			p.setPosition(z);
			return true;
       		 }
			if(b.equalsIgnoreCase("Adams")) { // correct answer
				Window.msg("very impressive, not many know who the second president was, even in America."); // correct answer screen
				return true;
			}
			else {
				Window.msg("I'm disappointed, I expected you to know your own country's founding fathers."); // wrong answer screen
				p.setPosition(z);
				return true;
			}
		}
		if(s == 1) {
			Window Msg = new Window();
			String b = Msg.in("What currency does Japan use?"); // question
			if(b==null)
	        		{
				Window.msg("I am disappointed in your lack of effort"); // x button
				p.setPosition(z);
				return true;
	       		 }
				if(b.equalsIgnoreCase("Yen")) { // correct answer
					Window.msg("vey good, you don't remember that your from America, but can still recall other currencies."); // correct answer screen
					return true;
				}
				else {
					Window.msg("I feel distraught by your lack of knowledge outside your state of mind."); // wrong answer screen
					p.setPosition(z);
					return true;
				}
			}
		if(s == 2) {
			Window Msg = new Window();
			String b = Msg.in("Name the country that overall won the '7 years war' in one word."); // question
			if(b==null)
	        		{
				Window.msg("I am disappointed in your lack of effort"); // x button
				p.setPosition(z);
				return true;
	       		 }
				if(b.equalsIgnoreCase("Britain")) { // correct answer
					Window.msg("You have a good knowledge of your species history, impressive indeed."); // correct answer screen
					return true;
				}
				else {
					Window.msg("Your lack of knowledge on your own societie's struggles are a mockery to history."); // wrong answer screen
					p.setPosition(z);
					return true;
				}
			}
		if(s == 3) {
			Window Msg = new Window();
			String b = Msg.in("What country gifted America the famous 'stature of liberty'"); // question
			if(b==null)
	        		{
				Window.msg("I am disappointed in your lack of effort"); // x button
				p.setPosition(z);
				return true;
	       		 }
				if(b.equalsIgnoreCase("France")) { // correct answer
					Window.msg("very good, know your allies well."); // correct answer screen
					return true;
				}
				else {
					Window.msg("if the French saw this, I wonder if they would regret it"); // wrong answer screen
					p.setPosition(z);
					return true;
				}
			}
		if(s == 4) {
			Window Msg = new Window();
			String b = Msg.in("In what century did Christopher Columbus sail to America (ex: 1900)"); // question
			if(b==null)
	        		{
				Window.msg("I am disappointed in your lack of effort"); // x button
				p.setPosition(z);
				return true;
	       		 }
				if(b.equalsIgnoreCase("1400")) { // correct answer
					Window.msg("good, knowing your dates are important and show good memory."); // correct answer screen
					return true;
				}
				else {
					Window.msg("your memory is failing you, now is not the time."); // wrong answer screen
					p.setPosition(z);
					return true;
				}
			}
		if(s == 5) {
			Window Msg = new Window();
			String b = Msg.in("Name the famous trade route that opened trade to many countries in Asia long ago (do not include 'The')"); // question
			if(b==null)
	        		{
				Window.msg("I am disappointed in your lack of effort"); // x button
				p.setPosition(z);
				return true;
	       		 }
				if(b.equalsIgnoreCase("Silk Road")) { // correct answer
					Window.msg("Understanding relationships between countries other than your own is very important."); // correct answer screen
					return true;
				}
				else {
					Window.msg("I thought you were better than this, guess i was wrong."); // wrong answer screen
					p.setPosition(z);
					return true;
				}
			}
		if(s == 6) {
			Window Msg = new Window();
			String b = Msg.in("What was the name of the war between Russia and the U.S. that avoided actual conflict (do not include 'The')"); // question
			if(b==null)
	        		{
				Window.msg("I am disappointed in your lack of effort"); // x button
				p.setPosition(z);
				return true;
	       		 }
				if(b.equalsIgnoreCase("Cold War")) { // correct answer
					Window.msg("Good, know your friends close, and your enemies closer."); // correct answer screen
					return true;
				}
				else {
					Window.msg("I am losing repsect for your knowledge"); // wrong answer screen
					p.setPosition(z);
					return true;
				}
			}
		if(s == 7) {
			Window Msg = new Window();
			String b = Msg.in("What was famously the most costly(in deaths) war in human history.(use a number)"); // question
			if(b==null)
	        		{
				Window.msg("I am disappointed in your lack of effort"); // x button
				p.setPosition(z);
				return true;
	       		 }
				if(b.equalsIgnoreCase("World War 2")) { // correct answer
					Window.msg("Good, understand humanities cnoflicts well."); // correct answer screen
					return true;
				}
				else {
					Window.msg("You must understand your species conflicts before you can tackle your own."); // wrong answer screen
					p.setPosition(z);
					return true;
				}
			}
		if(s == 8) {
			Window Msg = new Window();
		String b = Msg.in("What is the largest, most practiced worldwide religion today."); // question
			if(b==null)
	        		{
				Window.msg("I am disappointed in your lack of effort"); // x button
				p.setPosition(z);
				return true;
	       		 }
				if(b.equalsIgnoreCase("Christianity")) { // correct answer
					Window.msg("Very good, understand your peoples beliefs."); // correct answer screen
					return true;
				}
				else {
					Window.msg("You must understand belief, even if you dont partake in it."); // wrong answer screen
					p.setPosition(z);
					return true;
				}
			}
		if(s == 9) {
			Window Msg = new Window();
			String b = Msg.in("What is the most spoken language in the world"); // question
			if(b==null)
	        		{
				Window.msg("I am disappointed in your lack of effort"); // x button
				p.setPosition(z);
				return true;
	       		 }
				if(b.equalsIgnoreCase("Mandarin")) { // correct answer
					Window.msg("Good, you have a very prevasive knowledge."); // correct answer screen
					return true;
				}
				else {
					Window.msg("To those who believed it was English, you need to expand your view"); // wrong answer screen
					p.setPosition(z);
					return true;
				}
			}
		if(s == 10) {
			Window Msg = new Window();
			String b = Msg.in("What is the most spoken language in Australia"); // question
			if(b==null)
	        		{
				Window.msg("I am disappointed in your lack of effort"); // x button
				p.setPosition(z);
				return true;
	       		 }
				if(b.equalsIgnoreCase("English")) { // correct answer
					Window.msg("Very basic yet it shows you have good common sense."); // correct answer screen
					return true;
				}
				else {
					Window.msg("you have a lot of work to do, perhaps too much"); // wrong answer screen
					p.setPosition(z);
					return true;
				}
			}
		if(s == 11) {
			Window Msg = new Window();
			String b = Msg.in("What is currently the most populated country in the world."); // question
			if(b==null)
	        		{
				Window.msg("I am disappointed in your lack of effort"); // x button
				p.setPosition(z);
				return true;
	       		 }
				if(b.equalsIgnoreCase("China")) { // correct answer
					Window.msg("you have good knowledge of the current world"); // correct answer screen
					return true;
				}
				else {
					Window.msg("I am disappointed in your futile efforts."); // wrong answer screen
					p.setPosition(z);
					return true;
				}
			}
		return true;
	}
}