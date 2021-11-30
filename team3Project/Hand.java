package team3Project;


public class Hand { // need to be able to handle a hand of cards for both player & server dealer
	private card[] heldhand; 
	private int numberheld;

	public Hand()
	{
		// the absolute maximal possible handsize in a standard game of blackjack,
		// only needed in specific cases, but allots space incase
		heldhand = new card[14]; 
		numberheld = 0;
	}

	//calculate the total of a hand & decided if ace is counting as 1 or 11
	public int calculateTotal() {
		int total=0;
		boolean aceflag=false;
		for (int i =0; i<numberheld;i++) {
			int value = heldhand[i].getValue();
			if(value>10) {
				value=10;
			}
			else if (value ==1 ) {
				aceflag=true;
			}
			total+=value;
		}
		if(aceflag && total +10 < 21) {//determines that ace is 11 here
			total += 10;
		}
		return(total);
	}

	public void addCard(card card) {
		heldhand[numberheld++]=card;
	}
	
	public card getCard(int index) {
		return heldhand[index];
	}

	public void clearHand() {
		// will overwrite itself moving forward
		numberheld = 0;
	}

	//getters and setters
	public int getNumberHeld() {
		return numberheld;
	}

}
