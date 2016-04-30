package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import FourRowSolitaire.Card;



public class cardTest {
	
	private Card card1, card2, card3, card4;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		card1 = new Card("Hearts", 5, 1, 1);
		card2 = new Card("Spades", 5, 1, 2);
		card3 = new Card("Clubs", 5, 1, 3);
		card4 = new Card("Diamonds", 5, 1, 4);
	}

	@After
	public void tearDown() throws Exception {
		card1 = null;
		card2 = null;
		card3 = null;
		card4 = null;
	}

	@Test
	public void testGetNumber() {
		assertEquals(card1.getNumber(), 5);
		assertEquals(card2.getNumber(), 5);
		assertEquals(card3.getNumber(), 5);
		assertEquals(card4.getNumber(), 5);
	}

}
