package team3Project;

import java.io.IOException;

import ocsf.server.*;

public class player {

	private String name;
	protected Hand hand;
	private ConnectionToClient ctc;
	private int number;
	
	public player() {
		hand = new Hand();
	}

	public player(int playerNumber, String username) {
		this.number = playerNumber;
		this.name = username;
		hand = new Hand();
		ctc = null;
	}
	
	public player(ConnectionToClient ctc, String username, int playerNumber) {
		this.ctc = ctc;
		hand = new Hand();
		name = username;
		number = playerNumber;
	}
	
	public player(String username) {
		setName(username);
		hand = new Hand();
	}
	
	public void hit(card Card) {
		hand.addCard(Card);
	}
	
	public int getValue() {
		return hand.calculateTotal();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void clearHand() {
		this.hand.clearHand();
	}
	
	public ConnectionToClient getConnectionToClient() {
		return ctc;
	}
	
	public void requestPlayerAction() throws IOException {
		this.ctc.sendToClient("Next Players Turn");
	}
	
	public void setNumber(int n) {
		this.number = n;
	}
	
	public int getNumber() {
		return number;
	}
}