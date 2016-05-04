package test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import FourRowSolitaire.Card;
import FourRowSolitaire.CardStack;
import FourRowSolitaire.SingleCell;

public class TestSingleCell {
	
	SingleCell testCell;
	Card testCard1;
	Card testCard2;
	Card testCard3;
	CardStack testCardStack;
	
	@Before
	public void setUp() throws Exception {
		testCell = new SingleCell();
		testCard1 = new Card(Card.CLUBS_SUIT, 1, 1, 1); //ace of clubs
		testCard2 = new Card(Card.HEARTS_SUIT, 2, 1, 2); //two of hearts
		testCard3 = new Card(Card.SPADES_SUIT, 13, 1, 3); //king of spades
		testCardStack = new CardStack();
		testCardStack.push(new Card(Card.SPADES_SUIT, 4,1,4)); //push four of spades
		testCardStack.push(new Card(Card.DIAMONDS_SUIT,3, 1, 5)); //push three of diamonds
		testCardStack.push(new Card(Card.CLUBS_SUIT,2, 1, 6)); //push 2 of clubs
	}

	@After
	public void tearDown() throws Exception {
		testCell = null;
	}

	
	/**
	 * Test is valid move
	 */
	@Test
	public void testValidMove(){
		assertTrue(testCell.isValidMove(testCard1));
		assertTrue(testCell.isValidMove(testCard2));
		assertTrue(testCell.isValidMove(testCard3));
		testCell.push(testCard1);
		assertTrue(testCell.isValidMove(testCard2)==false);
		assertTrue(testCell.isValidMove(testCardStack)==false);
	}
	
	/**
	 * Test get card at location
	 */
	@Test
	public void testGetCardAtLocation(){
		testCell.push(testCard2);
		Card cardAtLocation = testCell.getCardAtLocation(2);
		assertTrue(cardAtLocation==null);
		cardAtLocation = testCell.getCardAtLocation(0);
		assertTrue(cardAtLocation==testCard2);
		testCell.pop();
		cardAtLocation = testCell.getCardAtLocation(0);
		assertTrue(cardAtLocation==null);
		testCell.push(testCard3);
		cardAtLocation = testCell.getCardAtLocation(new Point((int)Math.random()*10, (int)Math.random()*10));
		assertTrue(cardAtLocation==testCard3);
	}
	
	/**
	 * Test push
	 */
	@Test
	public void testPush(){
		Card popped = testCell.pop();
		assertTrue(popped==null);
		testCell.push(testCard3);
		popped = testCell.pop();
		assertTrue(popped==testCard3);
	}
}
