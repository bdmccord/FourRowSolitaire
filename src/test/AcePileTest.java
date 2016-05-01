package test;

import static org.junit.Assert.*;

import java.awt.Point;

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
	
	/**
	 * Setup creates an instance of each ace pile suite, as well as a two for each suite, and a three of spades
	 * @throws Exception
	 */
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
	
	/**
	 * Tear down sets all global objects to null
	 * @throws Exception
	 */
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
		assertTrue(spadesPile.push(aceSpades)==aceSpades);
		assertTrue(spadesPile.push(threeSpades)==null);
		assertTrue(spadesPile.push(twoSpades)==twoSpades);
		assertTrue(spadesPile.push(threeSpades)==threeSpades);
		
		assertTrue(diamondsPile.push(twoDiamonds)==null);
		assertTrue(diamondsPile.push(aceDiamonds)==aceDiamonds);
		assertTrue(diamondsPile.push(twoSpades)==null);
		assertTrue(diamondsPile.push(twoDiamonds)==twoDiamonds);
		assertTrue(diamondsPile.push(threeSpades)==null);
		
		assertTrue(heartsPile.push(twoHearts)==null);
		assertTrue(heartsPile.push(aceHearts)==aceHearts);
		assertTrue(heartsPile.push(twoClubs)==null);
		assertTrue(heartsPile.push(twoHearts)==twoHearts);
		assertTrue(heartsPile.push(threeSpades)==null);
		
		assertTrue(clubsPile.push(twoClubs)==null);
		assertTrue(clubsPile.push(aceClubs)==aceClubs);
		assertTrue(clubsPile.push(twoSpades)==null);
		assertTrue(clubsPile.push(twoClubs)==twoClubs);
		assertTrue(clubsPile.push(threeSpades)==null);
	}
	
	/**
	 * Test getCardAtLocation 
	 */
	@Test
	public void testGetCardAtLocation(){
		assertTrue(spadesPile.getCardAtLocation(new Point(0,0))==null);
		spadesPile.push(aceSpades);
		assertTrue(spadesPile.getCardAtLocation(new Point(0,0))==aceSpades);
		spadesPile.push(twoSpades);
		assertTrue(spadesPile.getCardAtLocation(new Point(0,0))==twoSpades);
		spadesPile.push(threeSpades);
		assertTrue(spadesPile.getCardAtLocation(new Point(0,0))==threeSpades);
		
		diamondsPile.push(aceDiamonds);
		assertTrue(diamondsPile.getCardAtLocation(new Point(0,0))==aceDiamonds);
		assertTrue(diamondsPile.getCardAtLocation(new Point(0,0))==aceDiamonds);
		diamondsPile.push(twoDiamonds);
		assertTrue(diamondsPile.getCardAtLocation(new Point(0,0))==twoDiamonds);
		
		heartsPile.push(aceHearts);
		assertTrue(heartsPile.getCardAtLocation(new Point(0,0))==aceHearts);
		heartsPile.push(twoHearts);
		assertTrue(heartsPile.getCardAtLocation(new Point(0,0))==twoHearts);
		
		clubsPile.push(aceClubs);
		assertTrue(clubsPile.getCardAtLocation(new Point(0,0))==aceClubs);
		clubsPile.push(twoClubs);
		assertTrue(clubsPile.getCardAtLocation(new Point(0,0))==twoClubs);
		assertTrue(clubsPile.getCardAtLocation(new Point(0,0))==twoClubs);
	}
	
	/**
	 * Test isValidMove
	 */
	@Test
	public void testIsValidMove(){
		assertTrue(spadesPile.isValidMove(twoSpades)==false);
		assertTrue(spadesPile.isValidMove(aceDiamonds)==false);
		assertTrue(spadesPile.isValidMove(aceHearts)==false);
		assertTrue(spadesPile.isValidMove(aceClubs)==false);
		assertTrue(spadesPile.isValidMove(aceSpades)==true);
		spadesPile.push(aceSpades);
		assertTrue(spadesPile.isValidMove(threeSpades)==false);
		assertTrue(spadesPile.isValidMove(twoSpades)==true);
		
		assertTrue(diamondsPile.isValidMove(twoDiamonds)==false);
		assertTrue(diamondsPile.isValidMove(aceSpades)==false);
		assertTrue(diamondsPile.isValidMove(aceHearts)==false);
		assertTrue(diamondsPile.isValidMove(aceClubs)==false);
		assertTrue(diamondsPile.isValidMove(aceDiamonds)==true);
		diamondsPile.push(aceDiamonds);
		assertTrue(diamondsPile.isValidMove(threeSpades)==false);
		assertTrue(diamondsPile.isValidMove(twoDiamonds)==true);
		
		assertTrue(heartsPile.isValidMove(twoHearts)==false);
		assertTrue(heartsPile.isValidMove(aceDiamonds)==false);
		assertTrue(heartsPile.isValidMove(aceSpades)==false);
		assertTrue(heartsPile.isValidMove(aceClubs)==false);
		assertTrue(heartsPile.isValidMove(aceHearts)==true);
		heartsPile.push(aceHearts);
		assertTrue(heartsPile.isValidMove(threeSpades)==false);
		assertTrue(heartsPile.isValidMove(twoHearts)==true);
		
		assertTrue(clubsPile.isValidMove(twoClubs)==false);
		assertTrue(clubsPile.isValidMove(aceDiamonds)==false);
		assertTrue(clubsPile.isValidMove(aceHearts)==false);
		assertTrue(clubsPile.isValidMove(aceSpades)==false);
		assertTrue(clubsPile.isValidMove(aceClubs)==true);
		clubsPile.push(aceClubs);
		assertTrue(clubsPile.isValidMove(threeSpades)==false);
		assertTrue(clubsPile.isValidMove(twoClubs)==true);
	}

}
