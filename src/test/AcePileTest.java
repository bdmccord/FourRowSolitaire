package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import FourRowSolitaire.AcePile;
import FourRowSolitaire.Card;

public class AcePileTest {
	AcePile spadesPile;
	AcePile diamondsPile;
	AcePile heartsPile;
	AcePile clubsPile;
	Card aceSpades;
	Card aceDiamonds;
	Card aceHearts;
	Card aceClubs;
	Card twoSpades;
	Card twoDiamonds;
	Card twoHearts;
	Card twoClubs;
	Card threeSpades;
	
	@Before
	public void setUp() throws Exception {
		spadesPile = new AcePile("Spades");
		diamondsPile = new AcePile("Diamonds");
		heartsPile = new AcePile("Hearts");
		clubsPile = new AcePile("Clubs");
		aceSpades = new Card("Spades", 1, 1, 1);
		aceDiamonds = new Card("Diamonds", 1, 1, 2);
		aceHearts = new Card("Hearts", 1, 1, 3);
		aceClubs = new Card("Clubs", 1, 1, 4);
		twoSpades = new Card("Spades", 2, 1, 5);
		twoDiamonds = new Card("Diamonds", 2, 1, 6);
		twoHearts = new Card("Hearts", 2, 1, 7);
		twoClubs = new Card("Clubs", 2, 1, 8);
		threeSpades = new Card("Spades", 3, 1, 5);
		
	}

	@After
	public void tearDown() throws Exception {
		spadesPile = null;
		diamondsPile = null;
		heartsPile = null;
		clubsPile = null;
		aceSpades = null;
		aceDiamonds = null;
		aceHearts = null;
		aceClubs = null;
		twoSpades = null;
		twoDiamonds = null;
		twoHearts = null;
		twoClubs = null;
		threeSpades = null;
	}
	
	/**
	 * Test getSuite method
	 */
	@Test
	public void testGetSuite() {
		assertTrue(spadesPile.getSuit().equals("Spades"));
		assertTrue(diamondsPile.getSuit().equals("Diamonds"));
		assertTrue(heartsPile.getSuit().equals("Hearts"));
		assertTrue(clubsPile.getSuit().equals("Clubs"));	
	}
	
	/**
	 * Test push method
	 */
	@Test
	public void testPush(){
		assertTrue(spadesPile.push(twoSpades)==null);
	}

}
