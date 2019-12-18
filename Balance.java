//Miruna Andreea Lazar 2459499L

public class Balance {
	int balance;
	String label;
	
	public void setBalance(int b) {
		balance=b;
	}
	
	public String getLabel() {
		return label;
	}
	
	public int UpdateBalance(String cardOne, String cardTwo, String cardThree) {
		
			  int j = 0;
			  if(cardOne.equals("Joker"))j = j + 1; //counting the jokers with variable j
			  if(cardTwo.equals("Joker"))j = j + 1;
			  if(cardThree.equals("Joker"))j = j + 1;
			  if(j > 0) { balance = balance - j * 25;
				          label = j +" joker/s - you lose " + 25 * j +" points!";
			  } //else, check if all the cards are equal, add 50 if true
			    else if(cardOne.equals(cardTwo) && cardTwo.equals(cardThree) && cardOne.equals(cardThree)) 
			     { balance = balance + 50;
			       label = "Three of a kind - you win 50 points!";
			      } //check if two cards are equal, add 20 if true
			       else if(cardOne.equals(cardTwo) || cardTwo.equals(cardThree) || cardOne.equals(cardThree)) 
			              { balance = balance + 20;
			                label = "Two of a kind - you win 20 points!";
			              } else label = "Three different cards - no changes";
		return balance;
	}	
}