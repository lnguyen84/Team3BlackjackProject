package team3Project;

import java.util.Random;

public class deck {
	card[] deck = new card[52]; // create the deck of 52 cards
	private int nextCardIndex;
	public deck() {
		int count =0;
		//add the cards into the deck to start out, 13 cards 4 suits
		
		for (int i =1;i<=13;i++) {//count from 1-13 & add in heart cards
			deck[count++]=new card('h',i);
		}
		for (int i =1;i<=13;i++) {//count from 1-13 & add in diamond cards
			deck[count++]=new card('d',i);
		}
		for (int i =1;i<=13;i++) {//count from 1-13 & add in club cards
			deck[count++]=new card('c',i);
		}
		for (int i =1;i<=13;i++) {//count from 1-13 & add in spade cards
			deck[count++]=new card('s',i);
		}
		
		nextCardIndex=0;
		
	}//end public deck()
	
	
	public String toString() {
		String deckstring="";
		for (int i =0;i<deck.length;i++) {
			deckstring+=deck[i].toString()+"";
		}
		
		return deckstring;
	}
	public boolean indexcheck(int index) {
		boolean check=false;
		if(index >= 0 && index <= 51) {
			check=true;
		}
		else {
			check=false;
			return check;
		}
		
		return check;
	}
	
	private void swapCards(int index1, int index2) {
		card hold;
		if(indexcheck(index1) == true && indexcheck(index2)==true) {
			hold = deck[index1];
			deck[index1]=deck[index2];
			deck[index2]=hold;
		}
		
	}
	
	public void shuffle(){	// five sets of full deck random swaps to emulate some means of shuffling
		Random rand = new Random();
		for(int i =0;i<5;i++) {
			for(int j =0;j<deck.length;j++) {
				swapCards(j,rand.nextInt(52));//shouldn't hit snags should rand & j equal, simply wont change based on swap's implementation.. i hope
			}
		}
	}
	
	public card nextCard() throws Exception {
		if(nextCardIndex <0 || nextCardIndex > 51) {
			throw new Exception("No Next Card Available, Deck Empty");
		}
		return deck[nextCardIndex++];
	}
}//end class deck
