package team3Project;


public class Hand { // need to be able to handle a hand of cards for both player & server dealer
	private card[] heldhand = new card[14]; // the absolute maximal possible handsize in a standard game of blackjack, only needed in specific cases, but allots space incase
	private int numberheld=0;
	
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
		if(aceflag && total +10 <21) {//determines that ace is 11 here
			total += 10;
		}
		return(total);
	}
	
	public void addCard(card card) {
		heldhand[numberheld++]=card;
	}
	public void clearHand() {
		numberheld=0;//effective reset as it will overwrite itself moving forward
	}
	
}
