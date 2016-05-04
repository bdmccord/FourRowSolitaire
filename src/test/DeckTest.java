package test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import FourRowSolitaire.Deck;

public class DeckTest {
	
	private Deck testDeck;
	private LinkedList<Integer> list;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testDeck = new Deck(1);
		list = new LinkedList<Integer>();
		list.add(1);
		list.add(5);
	}

	@After
	public void tearDown() throws Exception {
		testDeck = null;
		list = null;
	}
	
	@Test
	public void testShuffle(){
		assertTrue(testDeck.getDeck().size() == 52);
	}
	
	@Test
	public void testgetLinkedDeck(){
		assertTrue(testDeck.getDeck(list).size()==2);
	}

}
