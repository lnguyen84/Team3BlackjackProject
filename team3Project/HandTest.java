package team3Project;

import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest {

	@Test
	public void addCardtest() {
		Hand h1 = new Hand();
		card c1 = new card();
		deck d1 = new deck();
		
		d1.shuffle();
		try {
			c1 = d1.nextCard();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		h1.addCard(c1);
		assertEquals(h1.getCard(1),c1);
		//if(assertEquals(h1.getCard(1),c1))
		//	System.out.ln("pass");
	}

}
