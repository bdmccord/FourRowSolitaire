package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import FourRowSolitaire.DealDeck;
import FourRowSolitaire.DiscardPile;

public class DealDeckTest {
	
	private DealDeck dealTest;
	private DiscardPile testDiscard;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testDiscard = new DiscardPile(1);
		dealTest = new DealDeck(testDiscard, 1);
	}

	@After
	public void tearDown() throws Exception {
		testDiscard = null;
		dealTest = null;
	}

	@Test
	public void testDeal() {
		dealTest.reset();
		assertTrue(dealTest.getDeckThroughs() == 1);
		dealTest.setDeckThroughs(5);
		assertTrue(dealTest.getDeckThroughs() == 5);
		assertTrue(dealTest.hasDealsLeft());
	}


}
