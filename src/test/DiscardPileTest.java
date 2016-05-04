package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import FourRowSolitaire.Card;
import FourRowSolitaire.CardStack;
import FourRowSolitaire.DiscardPile;

public class DiscardPileTest {
	
	private DiscardPile testDiscard;
	private Card testCard, testCard2;
	private CardStack testStack;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testDiscard = new DiscardPile(1);
		testCard = new Card("Hearts", 3, 1, 1);
		testCard2 = new Card("Spades", 4, 1, 2);
		testStack = new CardStack();
	}

	@After
	public void tearDown() throws Exception {
		testDiscard = null;
		testCard = null;
		testCard2 = null;
		testStack = null;
	}


	@Test
	public void testIsValidMoveCard() {
		assertFalse(testDiscard.isValidMove(testCard));
		assertFalse(testDiscard.isValidMove(testDiscard.push(testCard)));
	}
	
	@Test
	public void testaddCard(){
		testDiscard.addCard(testCard);
		assertTrue(testDiscard.getNumViewableCards()==1);
	}
	
	@Test
	public void testStacks(){
		testStack.addCard(testCard2);
		testStack.addCard(testCard);
		testDiscard.addStack(testStack);
		assertTrue(testDiscard.getNumViewableCards()==2);
	}

}
