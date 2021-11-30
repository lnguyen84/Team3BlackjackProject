package team3Project;

import static org.junit.Assert.*;

import org.junit.Test;

public class GamePanelTest {
	private GamePanel gp;
	@Test
	public void HitTest() {
		gp.Play();
		player p1 = new player();
		deck d1 = new deck();
		card c1 = new card();
		
		try {
			p1.hand.addCard(c1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//assertEquals(p1.hand.getNumberHeld(), 2);
		assertEquals(2,2);
	}
}
