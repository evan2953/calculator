//EVAN LABANCA PERIOD 2
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
 
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
 
 
	
 
 
public class Calculator {
	
	
	
	static double firstNum;
	static double secondNum;
	static double finalNum;
	static int numBut;
	static int operation;
	static String displayString;
	static boolean done = false;
	static boolean first = true;
	static boolean wild = true;
	static boolean useDot = false;
 
	
	static public String action(String in){
		String displayOut = in;
		secondNum = Double.parseDouble(displayOut);
		if (operation == 1){
			displayOut = Double.toString((firstNum + secondNum));
			return displayOut;
		}
		else if (operation == 2){
			displayOut = Double.toString((firstNum - secondNum));
			return displayOut;
		}
		else if (operation == 3){
			displayOut = Double.toString((firstNum * secondNum));
			return displayOut;
		}
		else if (operation == 4){
			if (Double.isInfinite(firstNum/secondNum)){
				displayOut = "ERROR";
				firstNum = 0;
				secondNum = 0;
				finalNum = 0;
				operation = 0;
				first = true;
				wild = true;
				done = true;
				useDot = false;
			}
			else{
				displayOut = (Double.toString(firstNum / secondNum));
				}
			return displayOut;
			
		}
		return "";
	}
	
	
	public static void main(String[] args){
		
	
	JFrame calcFrame = new JFrame();
	calcFrame.setSize(333,425);
	calcFrame.setResizable(false);
	calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	calcFrame.setTitle("Calculator");
	
	JMenuBar menuBar = new JMenuBar();
	JMenu color = new JMenu("Color");
	menuBar.add(color);
	
	JMenuItem defaultColor = new JMenuItem("Default");
	color.add(defaultColor);
	
	JMenuItem blueColor = new JMenuItem("Blue");
	color.add(blueColor);	
	
	JMenuItem redColor = new JMenuItem("Red");
	color.add(redColor);
	
	JMenuItem greenColor = new JMenuItem("Green");
	color.add(greenColor);
	
	JMenuItem pinkColor = new JMenuItem("Pink");
	color.add(pinkColor);
	
	JMenuItem orangeColor = new JMenuItem("Orange");
	color.add(orangeColor);
	
	JMenuItem yellowColor = new JMenuItem("Yellow");
	color.add(yellowColor);
	
	JMenuItem magentaColor = new JMenuItem("Magenta");
	color.add(magentaColor);
	
	JMenuItem grayColor = new JMenuItem("Gray");
	color.add(grayColor);
	
	JMenuItem blackColor = new JMenuItem("Black");
	color.add(blackColor);
	
	JPanel menuPanel = new JPanel();
	menuPanel.setLayout(new GridLayout());
	menuPanel.add(menuBar);
	
	JPanel displayPanel = new JPanel(new BorderLayout());
	JTextArea display = new JTextArea();
	display.setEditable(false);
	display.setFont(new Font("Meiryo UI", Font.PLAIN, 27));
	displayPanel.add(menuPanel, BorderLayout.NORTH);
    displayPanel.add(display, BorderLayout.CENTER);
    
	
	JPanel buttonPanel = new JPanel();
	buttonPanel.setLayout(new GridLayout(0, 4, 5, 5));
	
	JButton buttonAdd = new JButton("+");
	buttonPanel.add(buttonAdd);
	
	JButton buttonSub = new JButton("-");
	buttonPanel.add(buttonSub);
	
	JButton buttonDiv = new JButton("/");
	buttonPanel.add(buttonDiv);
	
	JButton buttonMult = new JButton("*");
	buttonPanel.add(buttonMult);
	
	JButton button7 = new JButton("7");
	buttonPanel.add(button7); 
	
	JButton button8 = new JButton("8");
	buttonPanel.add(button8);
	
	JButton button9 = new JButton("9");
	buttonPanel.add(button9);
	
	JButton buttonRoot = new JButton("ROOT");
	buttonPanel.add(buttonRoot);
	
	JButton button4 = new JButton("4");
	buttonPanel.add(button4);
	
	JButton button5 = new JButton("5");
	buttonPanel.add(button5);
	
	JButton button6 = new JButton("6");
	buttonPanel.add(button6);
	
	JButton buttonCE = new JButton("CE");
	buttonPanel.add(buttonCE);
	
	JButton button1 = new JButton("1");
	buttonPanel.add(button1);
	
	JButton button2 = new JButton("2");
	buttonPanel.add(button2);
	
	JButton button3 = new JButton("3");
	buttonPanel.add(button3);
	
	JButton buttonC = new JButton("C");
	buttonPanel.add(buttonC);
	
	JButton button0 = new JButton("0");
	buttonPanel.add(button0);
	
	JButton buttonDot = new JButton(".");
	buttonPanel.add(buttonDot);
	
	JButton buttonPlusMinus = new JButton("+/-");
	buttonPanel.add(buttonPlusMinus);
	
	JButton buttonEqual = new JButton("=");
	buttonPanel.add(buttonEqual);
	
	
	class NumButt implements ActionListener{
 
		
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getActionCommand().equals("0")){
				if(done){
					display.setText("");
					done = false;
				}
				if(first)
				display.setText(display.getText() + "0");
				else if (wild){
					display.setText("");
					display.setText(display.getText() + "0");
					wild = false;
				}
					else{
						display.setText(display.getText() + "0");
					}			
			}
			else if (arg0.getActionCommand().equals(".")){
				if(done){
					display.setText("");
					done = false;
				}
				
				if (useDot){	}
				
				
				else if(first){
				display.setText(display.getText() + ".");
				useDot = true;
				if (display.getText().equals(".")){
					display.setText("0.");
					useDot = true;
				}
				}
				else if (wild){
					display.setText("");
					useDot = true;
					display.setText(display.getText() + ".");
					if (display.getText().equals(".")){	
						display.setText("0.");
						useDot = true;
					}
					wild = false;
					useDot = true;
				}
					else{
						display.setText(display.getText() + ".");
						useDot = true;
					}			
			}
			else if (arg0.getActionCommand().equals("1")){
				if(done){
					display.setText("");
					done = false;
				}
				if(first)
				display.setText(display.getText() + "1");
				else if (wild){
					display.setText("");
					display.setText(display.getText() + "1");
					wild = false;
				}
					else{
						display.setText(display.getText() + "1");
					}			
			}
			else if (arg0.getActionCommand().equals("2")){
				if(done){
					display.setText("");
					done = false;
				}
				if(first)
				display.setText(display.getText() + "2");
				else if (wild){
					display.setText("");
					display.setText(display.getText() + "2");
					wild = false;
				}
					else{
						display.setText(display.getText() + "2");
					}			
			}
			else if (arg0.getActionCommand().equals("3")){
				if(done){
					display.setText("");
					done = false;
				}
				if(first)
				display.setText(display.getText() + "3");
				else if (wild){
					display.setText("");
					display.setText(display.getText() + "3");
					wild = false;
				}
					else{
						display.setText(display.getText() + "3");
					}			
			}
			else if (arg0.getActionCommand().equals("4")){
				if(done){
					display.setText("");
					done = false;
				}
				if(first)
				display.setText(display.getText() + "4");
				else if (wild){
					display.setText("");
					display.setText(display.getText() + "4");
					wild = false;
				}
					else{
						display.setText(display.getText() + "4");
					}			
			}
			else if (arg0.getActionCommand().equals("5")){
				if(done){
					display.setText("");
					done = false;
				}
				if(first)
				display.setText(display.getText() + "5");
				else if (wild){
					display.setText("");
					display.setText(display.getText() + "5");
					wild = false;
				}
					else{
						display.setText(display.getText() + "5");
					}			
			}
			else if (arg0.getActionCommand().equals("6")){
				if(done){
					display.setText("");
					done = false;
				}
				if(first)
					display.setText(display.getText() + "6");
					else if (wild){
						display.setText("");
						display.setText(display.getText() + "6");
						wild = false;
					}
						else{
							display.setText(display.getText() + "6");	
						}
			}
			else if (arg0.getActionCommand().equals("7")){
				if(done){
					display.setText("");
					done = false;
				}
				if(first)
					display.setText(display.getText() + "7");
					else if (wild){
						display.setText("");
						display.setText(display.getText() + "7");
						wild = false;
					}
						else{
							display.setText(display.getText() + "7");
						}	
			}
			else if (arg0.getActionCommand().equals("8")){
				if(done){
					display.setText("");
					done = false;
				}
				if(first)
					display.setText(display.getText() + "8");
					else if (wild){
						display.setText("");
						display.setText(display.getText() + "8");
						wild = false;
					}
						else{
							display.setText(display.getText() + "8");
						}
			}
			else if (arg0.getActionCommand().equals("9")){
				if(done){
					display.setText("");
					done = false;
				}
				if(first)
					display.setText(display.getText() + "9");
					else if (wild){
						display.setText("");
						display.setText(display.getText() + "9");
						wild = false;
					}
						else{
							display.setText(display.getText() + "9");
						}
			}
		}	
	}
	
	class opButt implements ActionListener{
 
		public void actionPerformed(ActionEvent e) {
 
			if (e.getActionCommand().equals("+")){
				
				useDot = false;
				if (first){
				firstNum =  Double.parseDouble(display.getText());
				operation = 1;
				first = false;
				}
				else {	
					displayString = display.getText();
					display.setText(action(displayString));
						firstNum = Double.parseDouble(display.getText());
						operation = 1;
						wild = true;				
				}
			}
			
				if (e.getActionCommand().equals("-")){
				
				useDot = false;
				if (first){
				firstNum =  Double.parseDouble(display.getText());
				operation = 2;
				first = false;
				}
				else {	
					displayString = display.getText();
					display.setText(action(displayString));
						firstNum = Double.parseDouble(display.getText());
						operation = 2;
						wild = true;	
			}
				}
				if (e.getActionCommand().equals("*")){
					
					useDot = false;
					if (first){
					firstNum =  Double.parseDouble(display.getText());
					operation = 3;
					first = false;
					}
					else {	
						displayString = display.getText();
						display.setText(action(displayString));
							firstNum = Double.parseDouble(display.getText());
							operation = 3;
							wild = true;					
					}
				}
				
				if (e.getActionCommand().equals("/")){
					
					useDot = false;
					if (first){
					firstNum =  Double.parseDouble(display.getText());
					operation = 4;
					first = false;
					}
					else {	displayString = display.getText();
					display.setText(action(displayString));
					firstNum = Double.parseDouble(display.getText());
					operation = 4;
					wild = true;					
					}
				}
				if (e.getActionCommand().equals("ROOT")){
					display.setText(Double.toString(Math.sqrt(Double.parseDouble(display.getText()))));
					useDot = true;
				}
 
		
	}
		}
	
	class CE implements ActionListener{
 
		
		public void actionPerformed(ActionEvent arg0) {
			if (first){
				display.setText("");
			}
			else if (!wild)
				display.setText("");
			else{
				operation = 0;
				first = true;
			}
				
		}
		
	}
	
	
	class Clear implements ActionListener{
 
		
		public void actionPerformed(ActionEvent e) {
			
			display.setText("");
			firstNum = 0;
			secondNum = 0;
			finalNum = 0;
			operation = 0;
			first = true;
			wild = true;
			done = true;
			useDot = false;
		}
		
	}
	
	class PlusMinus implements ActionListener{
 
		
		public void actionPerformed(ActionEvent e) {
			
			display.setText(Double.toString(Double.parseDouble(display.getText())*-1));
		}
		
	}
	
	class Equal implements ActionListener{
 
		public void actionPerformed(ActionEvent e) {
			displayString = display.getText();
			display.setText(action(displayString));
			firstNum = 0;
			secondNum = 0;
			finalNum = 0;
			operation = 0;
			first = true;
			wild = true;
			useDot = false;
			done = true;
		}
	}
	
	
		
		
	
		class Colors implements ActionListener{
 
			
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getActionCommand().equals("Blue"))
					buttonPanel.setBackground(Color.BLUE);
				else if (arg0.getActionCommand().equals("Black"))
					buttonPanel.setBackground(Color.BLACK);
				else if (arg0.getActionCommand().equals("Red"))
					buttonPanel.setBackground(Color.RED);
				else if (arg0.getActionCommand().equals("Pink"))
					buttonPanel.setBackground(Color.PINK);
				else if (arg0.getActionCommand().equals("Green"))
					buttonPanel.setBackground(Color.GREEN);
				else if (arg0.getActionCommand().equals("Orange"))
					buttonPanel.setBackground(Color.ORANGE);
				else if (arg0.getActionCommand().equals("Yellow"))
					buttonPanel.setBackground(Color.YELLOW);
				else if (arg0.getActionCommand().equals("Gray"))
					buttonPanel.setBackground(Color.LIGHT_GRAY);
				else if (arg0.getActionCommand().equals("Magenta"))
					buttonPanel.setBackground(Color.MAGENTA);
				else if (arg0.getActionCommand().equals("Default"))
					buttonPanel.setBackground(new Color(238,238,238));
			}
			
		}
		
		blueColor.addActionListener(new Colors());
		blackColor.addActionListener(new Colors());
		redColor.addActionListener(new Colors());
		pinkColor.addActionListener(new Colors());
		greenColor.addActionListener(new Colors());
		yellowColor.addActionListener(new Colors());
		grayColor.addActionListener(new Colors());
		magentaColor.addActionListener(new Colors());
		orangeColor.addActionListener(new Colors());
		defaultColor.addActionListener(new Colors());
		
		
	
	buttonC.addActionListener(new Clear());
	buttonDot.addActionListener(new NumButt());
	button0.addActionListener(new NumButt());
	button1.addActionListener(new NumButt());
	button2.addActionListener(new NumButt());
	button3.addActionListener(new NumButt());
	button4.addActionListener(new NumButt());
	button5.addActionListener(new NumButt());
	button6.addActionListener(new NumButt());
	button7.addActionListener(new NumButt());
	button8.addActionListener(new NumButt());
	button9.addActionListener(new NumButt());
	
	buttonRoot.addActionListener(new opButt());
	buttonAdd.addActionListener(new opButt());
	buttonSub.addActionListener(new opButt());
	buttonMult.addActionListener(new opButt());
	buttonDiv.addActionListener(new opButt());
	buttonEqual.addActionListener(new Equal());
	buttonCE.addActionListener(new CE());
	buttonPlusMinus.addActionListener(new PlusMinus());
	
	
	class keyDispatcher implements KeyEventDispatcher{
 
		
		public boolean dispatchKeyEvent(KeyEvent e) {
			if (e.getID() == KeyEvent.KEY_PRESSED){
				if(e.getKeyChar() == '0'){
				if(done){
					display.setText("");
					done = false;
				}
				if(first)
				display.setText(display.getText() + "0");
				else if (wild){
					display.setText("");
					display.setText(display.getText() + "0");
					wild = false;
				}
					else{
						display.setText(display.getText() + "0");
					}
				
			}
			
				else if(e.getKeyChar() == '1'){
					if(done){
						display.setText("");
						done = false;
					}
					if(first)
					display.setText(display.getText() + "1");
					else if (wild){
						display.setText("");
						display.setText(display.getText() + "1");
						wild = false;
					}
						else{
							display.setText(display.getText() + "1");
						}
					
				}
			
				else if(e.getKeyChar() == '2'){
					if(done){
						display.setText("");
						done = false;
					}
					if(first)
					display.setText(display.getText() + "2");
					else if (wild){
						display.setText("");
						display.setText(display.getText() + "2");
						wild = false;
					}
						else{
							display.setText(display.getText() + "2");
						}
					
				}
				
				else if(e.getKeyChar() == '3'){
					if(done){
						display.setText("");
						done = false;
					}
					if(first)
					display.setText(display.getText() + "3");
					else if (wild){
						display.setText("");
						display.setText(display.getText() + "3");
						wild = false;
					}
						else{
							display.setText(display.getText() + "3");
						}
					
				}
			
				else if(e.getKeyChar() == '4'){
					if(done){
						display.setText("");
						done = false;
					}
					if(first)
					display.setText(display.getText() + "4");
					else if (wild){
						display.setText("");
						display.setText(display.getText() + "4");
						wild = false;
					}
						else{
							display.setText(display.getText() + "4");
						}
					
				}
				
				else if(e.getKeyChar() == '5'){
					if(done){
						display.setText("");
						done = false;
					}
					if(first)
					display.setText(display.getText() + "5");
					else if (wild){
						display.setText("");
						display.setText(display.getText() + "5");
						wild = false;
					}
						else{
							display.setText(display.getText() + "5");
						}
					
				}
				
				else if(e.getKeyChar() == '6'){
					if(done){
						display.setText("");
						done = false;
					}
					if(first)
					display.setText(display.getText() + "6");
					else if (wild){
						display.setText("");
						display.setText(display.getText() + "6");
						wild = false;
					}
						else{
							display.setText(display.getText() + "6");
						}
					
				}
				
				else if(e.getKeyChar() == '7'){
					if(done){
						display.setText("");
						done = false;
					}
					if(first)
					display.setText(display.getText() + "7");
					else if (wild){
						display.setText("");
						display.setText(display.getText() + "7");
						wild = false;
					}
						else{
							display.setText(display.getText() + "7");
						}
					
				}
				
				else if(e.getKeyChar() == '8'){
					if(done){
						display.setText("");
						done = false;
					}
					if(first)
					display.setText(display.getText() + "8");
					else if (wild){
						display.setText("");
						display.setText(display.getText() + "8");
						wild = false;
					}
						else{
							display.setText(display.getText() + "8");
						}
					
				}
				
				else if(e.getKeyChar() == '9'){
					if(done){
						display.setText("");
						done = false;
					}
					if(first)
					display.setText(display.getText() + "9");
					else if (wild){
						display.setText("");
						display.setText(display.getText() + "9");
						wild = false;
					}
						else{
							display.setText(display.getText() + "9");
						}
					
				}
			
				else if (e.getKeyChar() == '+'){
					useDot = false;
					if (first){
					firstNum =  Double.parseDouble(display.getText());
					operation = 1;
					first = false;
					}
					else {	
						displayString = display.getText();
						display.setText(action(displayString));
							firstNum = Double.parseDouble(display.getText());
							operation = 1;
							wild = true;				
					}
				}
				
				else if (e.getKeyChar() == '-'){
					useDot = false;
					if (first){
					firstNum =  Double.parseDouble(display.getText());
					operation = 2;
					first = false;
					}
					else {	
						displayString = display.getText();
						display.setText(action(displayString));
							firstNum = Double.parseDouble(display.getText());
							operation = 2;
							wild = true;	
				}
					}
				else if (e.getKeyChar() == '*'){
						useDot = false;
						if (first){
						firstNum =  Double.parseDouble(display.getText());
						operation = 3;
						first = false;
						}
						else {	
							displayString = display.getText();
							display.setText(action(displayString));
								firstNum = Double.parseDouble(display.getText());
								operation = 3;
								wild = true;					
						}
					}
					
				else if (e.getKeyChar() == '/'){
						useDot = false;
						if (first){
						firstNum =  Double.parseDouble(display.getText());
						operation = 4;
						first = false;
						}
						else {	displayString = display.getText();
						display.setText(action(displayString));
						firstNum = Double.parseDouble(display.getText());
						operation = 4;
						wild = true;					
						}
					}
				
				else if(e.getKeyCode() == 10 || e.getKeyChar() == '='){ //Enter
				displayString = display.getText();
				display.setText(action(displayString));
				firstNum = 0;
				secondNum = 0;
				finalNum = 0;
				operation = 0;
				first = true;
				wild = true;
				useDot = false;
				done = true;
				}
				
				else if(e.getKeyChar() == 'c' || e.getKeyChar() == 'C'){ //CE
					if (first){
						display.setText("");
					}
					else if (!wild)
						display.setText("");
					else{
						operation = 0;
						first = true;
				}
				}
				
				else if(e.getKeyCode() == 8){ //C delete/backspace
					display.setText("");
					firstNum = 0;
					secondNum = 0;
					finalNum = 0;
					operation = 0;
					first = true;
					wild = true;
					done = true;
					useDot = false;		
				}
				
				else if(e.getKeyChar() == 'r' || e.getKeyChar() == 'R'){ //root
					display.setText(Double.toString(Math.sqrt(Double.parseDouble(display.getText()))));
					useDot = true;
			}
				
				else if(e.getKeyChar() =='n' || e.getKeyChar() == 'N'){
					display.setText(Double.toString(Double.parseDouble(display.getText())*-1));
				}
				
				else if(e.getKeyChar() == '.'){
						if(done){
							display.setText("");
							done = false;
						}
						
						if (useDot){	}
						
						
						else if(first){
						display.setText(display.getText() + ".");
						useDot = true;
						if (display.getText().equals(".")){
							display.setText("0.");
							useDot = true;
						}
						}
						else if (wild){
							display.setText("");
							useDot = true;
							display.setText(display.getText() + ".");
							if (display.getText().equals(".")){	
								display.setText("0.");
								useDot = true;
							}
							wild = false;
							useDot = true;
						}
							else{
								display.setText(display.getText() + ".");
								useDot = true;
							}			
				}
			}
			return false;
		}
		
	}
	
	
	
	calcFrame.getContentPane().add(displayPanel, BorderLayout.NORTH);
	calcFrame.getContentPane().add(buttonPanel, BorderLayout.CENTER);
	
	KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
	manager.addKeyEventDispatcher(new keyDispatcher());
	
	calcFrame.setVisible(true);
}
	
	}
 
 
 
 
