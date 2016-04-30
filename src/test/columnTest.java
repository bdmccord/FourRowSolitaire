package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import FourRowSolitaire.Card;
import FourRowSolitaire.Column;

public class columnTest {
	
	Card card1, card2, card3, card4;
	Column column1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		card1 = new Card("Hearts", 13, 1, 1);
		card2 = new Card("Spades", 12, 1, 2);
		card3 = new Card("Diamonds", 12, 1, 3);
		card4 = new Card("Spades", 11, 1, 4);
		column1 = new Column();
		
	}

	@After
	public void tearDown() throws Exception {
		card1 = null;
		card2 = null;
		card3 = null;
		card4 = null;
		column1 = null;
	}

	@Test
	public void testIsValidMoveCard() {
		column1.push(card1);
		assertTrue("This is not a valid move", column1.isValidMove(card2));
		assertTrue("This is not a valid move", column1.isValidMove(card3));
		assertTrue("This is not a valid move", column1.isValidMove(card4));
	}
	
	

}
