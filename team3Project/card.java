package team3Project;

public class card {
	private char suit;
	private int value;
	
	public card() {
		suit=' ';
		value=0;
	}
	public card(char suit, int value) {
		this.suit=suit;
		this.value=value;
	}
	public String toString() {
		return getSuitName() + " "+this.value;
	}
	public String getSuitName() {
		String suit;
		
		if(this.suit == 'h') {
			suit = "Hearts";
		}
		else if(this.suit == 's') {
			suit = "Spades";
		}
		else if(this.suit == 'd') {
			suit = "Diamonds";
		}
		else if(this.suit == 'c') {
			suit = "Clubs";
		}
		else {
			suit = "Unknown";
		}
		
		return (suit);
	}
	public char getSuit() {
		return suit;
	}
	public String getValueName(){

		String name = "Unknown";

		if (this.value == 1) {		
			name = "Ace";
		}
		else if (this.value == 2) {
			name = "Two";
		}
		else if (this.value == 3) {
			name = "Three";
		}
		else if (this.value == 4) {
			name = "Four";
		}
		else if (this.value == 5) {
			name = "Five";
		}
		else if (this.value == 6) {
			name = "Six";
		}
		else if (this.value == 7) {
			name = "Seven";
		}
		else if (this.value == 8) {
			name = "Eight";
		}
		else if (this.value == 9) {

			name = "Nine";
		}
		else if (this.value == 10) {

			name = "Ten";
		}
		else if (this.value == 11) {

			name = "Jack";
		}
		else if (this.value == 12) {

			name = "Queen";
		}
		else if (this.value == 13) {

			name = "King";
	
	
	
	
		}	
		return name;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public boolean compareSuit(card card) {
		return this.suit == card.getSuit();
	}
	public boolean compareTo(card card) {
		return this.suit == card.getSuit() && this.value == card.getValue();
	}
	
	
	
}//end card class
