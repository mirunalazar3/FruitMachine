//Miruna Andreea Lazar 2459499L

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
    Balance b=new Balance();
    Cards card=new Cards();
	JLabel welcome;
	JLabel balance;
        JLabel emptyLabel;
	JButton spin;
	JButton newGame;
	JLabel cardOne;
	JLabel cardTwo;
	JLabel cardThree;
	JPanel cardOnePanel;
	JPanel cardTwoPanel;
	JPanel cardThreePanel;
	
	public MainFrame() {
    	 super("Fruit Machine");
    	 setLayout(new BorderLayout());
    	 
    	 Font font = new Font("Comic Sans MS", Font.PLAIN, 20); //create font (this part is just for fun)
    	 Font buttonsFont = new Font("Comic Sans MS", Font.BOLD, 15);  //smaller font for buttons
    	
    	 //WELCOME AND BALANCE LABELS PART
    	 
    	 //create Welcome label
    	 welcome = new JLabel("Welcome!"); 
    	 welcome.setFont(font);
    	 
    	 //create Balance is label
    	 balance = new JLabel("Balance is 100");
    	 balance.setFont(font);
        
         emptyLabel = new JLabel(""); //an initially empty label that will display either You win or You lose
    	 emptyLabel.setFont(font);
    	
    	 
    	 //BUTTONS PART
    	 //create spin button
    	 spin = new JButton("Spin"); 
    	 spin.setSize(50, 50);
    	 spin.setFont(buttonsFont);
    	 spin.setEnabled(false);
    	 //action listener
    	 spin.addActionListener(new ActionListener() {

  			
  			public void actionPerformed(ActionEvent e) {
  					cardOne.setText(card.getCard());
  					cardTwo.setText(card.getCard());
  					cardThree.setText(card.getCard());
  					b.UpdateBalance(cardOne.getText(), cardTwo.getText(), cardThree.getText());
  					balance.setText("Balance is "+b.balance);
  					welcome.setText(b.getLabel());
  					//play the game while 0<balance<150
  					if(b.balance<0) {
  						emptyLabel.setText("You lose!");
  						newGame.setEnabled(true); //new game gets enabled after loss
  						spin.setEnabled(false); //spin gets disabled after loss
  					}
  					if(b.balance>150) {
  						emptyLabel.setText("You win!");
  						newGame.setEnabled(true); //new game gets enabled after win
  						spin.setEnabled(false); //spin gets disabled after win
  					}
  			}
  	    	   
  	       });
    	 
    	 //create new game button
    	 newGame = new JButton("New Game"); 
    	 newGame.setSize(40, 40);
    	 newGame.setFont(buttonsFont);
    	 
    	 //action listener
    	 newGame.addActionListener(new ActionListener() {

 			public void actionPerformed(ActionEvent e) {
 					b.setBalance(100); //initial balance
 					balance.setText("Balance is 100");
 					newGame.setEnabled(false);  //new game is disabled
 					spin.setEnabled(true); //spin will be enabled
					welcome.setText("Welcome!");
 					emptyLabel.setText(" ");
					cardOne.setText("King");
  					cardTwo.setText("Queen");
  					cardThree.setText("Jack");
 			}
 	    	   
 	       });
    	 
    	 //CARDS PART	 
    	 
    	 //create label of cards 
    	 cardOne = new JLabel("King");
    	 cardOne.setFont(font);
    	 cardTwo = new JLabel("Queen");
    	 cardTwo.setFont(font);
    	 cardThree = new JLabel("Jack");
    	 cardThree.setFont(font); 
    	 
    	 //create "cards" as panels, to be able to set colours and border
    	 cardOnePanel = new JPanel();
    	 cardTwoPanel = new JPanel();
    	 cardThreePanel = new JPanel();
    	 
    	 //set the size of "cards"
    	 cardOnePanel.setPreferredSize(new Dimension(100, 150));
    	 cardTwoPanel.setPreferredSize(new Dimension(100, 150));
    	 cardThreePanel.setPreferredSize(new Dimension(100, 150));
    	 
    	 //add labels on the "cards"
    	 cardOnePanel.add(cardOne);
    	 cardTwoPanel.add(cardTwo);
    	 cardThreePanel.add(cardThree);
    	 
    	 //center the text 
    	 cardOnePanel.setLayout(new GridBagLayout());
    	 cardTwoPanel.setLayout(new GridBagLayout());
    	 cardThreePanel.setLayout(new GridBagLayout());
    	 
    	 //set colours and borders of the three panels
    	 cardOnePanel.setBackground(Color.YELLOW);
    	 cardOnePanel.setBorder(BorderFactory.createLineBorder(null, 1));
    	 cardTwoPanel.setBackground(Color.YELLOW);
    	 cardTwoPanel.setBorder(BorderFactory.createLineBorder(null, 1));
    	 cardThreePanel.setBackground(Color.YELLOW);
    	 cardThreePanel.setBorder(BorderFactory.createLineBorder(null, 1));
    
    	 //adding everything in the main Panel	 
    	 JPanel subPanelOne = new JPanel();
    	 subPanelOne.add(cardOnePanel);
    	 subPanelOne.add(Box.createRigidArea(new Dimension(10, 20)));
    	 subPanelOne.add(cardTwoPanel);
    	 subPanelOne.add(Box.createRigidArea(new Dimension(10, 20)));
    	 subPanelOne.add(cardThreePanel);
    	 add(subPanelOne, BorderLayout.CENTER);
    	 
    	 JPanel subPanelTwo = new JPanel();
    	 subPanelTwo.setLayout(new BoxLayout(subPanelTwo, BoxLayout.PAGE_AXIS));
    	 subPanelTwo.add(Box.createRigidArea(new Dimension(10, 20)));
    	 subPanelTwo.add(balance);
    	 subPanelTwo.add(Box.createRigidArea(new Dimension(10, 50)));
    	 subPanelTwo.add(welcome);
    	 subPanelTwo.add(Box.createRigidArea(new Dimension(10, 50)));
	 subPanelTwo.add(emptyLabel);
	 subPanelTwo.add(Box.createRigidArea(new Dimension(10, 30)));
    	 add(subPanelTwo, BorderLayout.NORTH);
    	 
    	 JPanel subPanelThree = new JPanel();
    	 subPanelThree.setLayout(new BoxLayout(subPanelThree, BoxLayout.PAGE_AXIS));
    	 subPanelThree.setBorder(new EmptyBorder(new Insets(35, 10, 10, 25)));
    	 subPanelThree.add(spin);
    	 subPanelThree.add(Box.createRigidArea(new Dimension(5, 10)));
    	 subPanelThree.add(newGame);
         add(subPanelThree, BorderLayout.EAST);
    	 
    	 //size of the frame and misc(close the window when cross is clicked, set frame location on desktop and make the frame visible)
    	 setSize(550,450);
    	 setLocation(550,350);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setVisible(true);	
     }	
}