package test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import FourRowSolitaire.Card;
import FourRowSolitaire.CardStack;

public class CardStackTest {
	
	CardStack cardStack;
	HashMap cardMap;
	
	/**
	 * Setup all possible cards to use during testing
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		cardStack = new CardStack();
		cardMap = new HashMap<String,HashMap<Integer,Card>>();
		//black
		HashMap<Integer,Card> spadesMap = populateSuiteHashMap(Card.SPADES_SUIT, 1);
		HashMap<Integer,Card> clubsMap = populateSuiteHashMap(Card.CLUBS_SUIT, 14);
		//red
		HashMap<Integer,Card> diamondsMap = populateSuiteHashMap(Card.DIAMONDS_SUIT, 27);
		HashMap<Integer,Card> heartsMap = populateSuiteHashMap(Card.HEARTS_SUIT, 49);
		cardMap.put("Spades", spadesMap);
		cardMap.put("Diamonds", diamondsMap);
		cardMap.put("Hearts",heartsMap);
		cardMap.put("Clubs",clubsMap);
	}
	
	/**
	 * For generating card map for testing
	 * @param suite
	 * @param startingFullNumber
	 * @return
	 */
	public HashMap<Integer,Card> populateSuiteHashMap(String suite, int startingFullNumber){
		HashMap<Integer,Card> res = new HashMap();
		for(int i = 1; i <= 13; i++){
			Card card = new Card(suite, i, 1, startingFullNumber+i-1);
			res.put(i, card);
		}
		return res;
	}
	
	/**
	 * To get card from hash map
	 * @param suite
	 * @param number
	 * @return
	 */
	public Card getCardFromHashMap(String suite, int number){
		return (Card)((HashMap<String,Card>)cardMap.get(suite)).get(number);
	}

	@After
	public void tearDown() throws Exception {
		cardMap=null;
		cardStack=null;

	}
	
	/**
	 * Test pop
	 */
	@Test
	public void testPop(){
		assertTrue(cardStack.pop()==null);
		Card testCard = getCardFromHashMap(Card.CLUBS_SUIT, 2);
		cardStack.push(testCard);
		assertTrue(cardStack.pop()==testCard);
	}
	/**
	 * Test addCard and peek method
	 * This test also tests peeking an empty stack
	 */
	@Test
	public void testAddCardAndPeek() {
		cardStack.addCard(getCardFromHashMap(Card.SPADES_SUIT,1)); //add ace of spades
		assertTrue(cardStack.peek().getNumber()==1);
		assertTrue(cardStack.peek().getSuit()==Card.SPADES_SUIT);
		cardStack.add(getCardFromHashMap(Card.SPADES_SUIT,2)); //push two of spades
		
		cardStack=new CardStack();
		assertTrue(cardStack.peek()==null);
	}
	
	/**
	 * Test pushCard
	 */
	@Test
	public void testPushCard() {
		cardStack.push(getCardFromHashMap(Card.HEARTS_SUIT,1)); //push ace hearts
		cardStack.push(getCardFromHashMap(Card.HEARTS_SUIT,2)); //push two hearts
		cardStack.push(getCardFromHashMap(Card.HEARTS_SUIT,3)); //push three hearts
		cardStack.push(getCardFromHashMap(Card.HEARTS_SUIT,4)); //push four hearts

		Card popped;
		popped = cardStack.pop();
		assertTrue(popped.getNumber()==4 && popped.getSuit() == Card.HEARTS_SUIT); //check for four hearts
		popped = cardStack.pop();
		assertTrue(popped.getNumber()==3 && popped.getSuit() == Card.HEARTS_SUIT); //check for three hearts
		popped = cardStack.pop();
		assertTrue(popped.getNumber()==2 && popped.getSuit() == Card.HEARTS_SUIT); //check for two hearts
		popped = cardStack.pop();
		assertTrue(popped.getNumber()==1 && popped.getSuit() == Card.HEARTS_SUIT); //check for ace hearts
	}
	
	
	/**
	 * Test addCard and peek method
	 */
	@Test
	public void testPushCardStackAndPeek() {
		CardStack toAdd = new CardStack();
		toAdd.push(getCardFromHashMap(Card.DIAMONDS_SUIT,1)); //push ace diamonds 
		toAdd.push(getCardFromHashMap(Card.DIAMONDS_SUIT,2)); //push two diamonds
		toAdd.push(getCardFromHashMap(Card.DIAMONDS_SUIT,3)); //push three diamonds 
		toAdd.push(getCardFromHashMap(Card.DIAMONDS_SUIT,4)); //push four diamonds

		cardStack.push(toAdd); //add temp stack to stack
		Card popped;
		popped = cardStack.pop();
		assertTrue(popped.getNumber()==1 && popped.getSuit() == Card.DIAMONDS_SUIT); //check for ace diamonds
		popped = cardStack.pop();
		assertTrue(popped.getNumber()==2 && popped.getSuit() == Card.DIAMONDS_SUIT); //check for two diamonds
		popped = cardStack.pop();
		assertTrue(popped.getNumber()==3 && popped.getSuit() == Card.DIAMONDS_SUIT); //check for three diamonds
		popped = cardStack.pop();
		assertTrue(popped.getNumber()==4 && popped.getSuit() == Card.DIAMONDS_SUIT); //check for four diamonds
	}
	
	/**
	 * Test addStack
	 */
	@Test
	public void testAddStack() {
		CardStack toAdd = new CardStack();
		toAdd.addCard(getCardFromHashMap(Card.DIAMONDS_SUIT,1)); //push ace diamonds 
		toAdd.addCard(getCardFromHashMap(Card.DIAMONDS_SUIT,2)); //push two diamonds
		toAdd.addCard(getCardFromHashMap(Card.DIAMONDS_SUIT,3)); //push three diamonds 
		toAdd.addCard(getCardFromHashMap(Card.DIAMONDS_SUIT,4)); //push four diamonds

		cardStack.addStack(toAdd); //add temp stack to stack
		
		Card popped;
		popped = cardStack.pop();
		assertTrue(popped.getNumber()==1 && popped.getSuit() == Card.DIAMONDS_SUIT); //check for ace diamonds
		popped = cardStack.pop();
		assertTrue(popped.getNumber()==2 && popped.getSuit() == Card.DIAMONDS_SUIT); //check for two diamonds
		popped = cardStack.pop();
		assertTrue(popped.getNumber()==3 && popped.getSuit() == Card.DIAMONDS_SUIT); //check for three diamonds
		popped = cardStack.pop();
		assertTrue(popped.getNumber()==4 && popped.getSuit() == Card.DIAMONDS_SUIT); //check for four diamonds
	}
	
	/**
	 * Test isValid move
	 */
	@Test
	public void testIsValidMove() {
		cardStack.push(getCardFromHashMap(Card.CLUBS_SUIT,12)); //push queen clubs
		
		Card testCard = getCardFromHashMap(Card.SPADES_SUIT, 11);
		assertTrue(cardStack.isValidMove(testCard) == false); //always returns false
		testCard = getCardFromHashMap(Card.HEARTS_SUIT, 11);
		assertTrue(cardStack.isValidMove(testCard) == false); //always returns false
		CardStack tempStack = new CardStack();
		tempStack.push(testCard);
		assertTrue(cardStack.isValidMove(tempStack) == false); //always returns false
		
	}
	
	/**
	 * Test getStack
	 */
	@Test
	public void testGetStack(){
		cardStack.addCard(getCardFromHashMap(Card.SPADES_SUIT,4)); //push four spades
		cardStack.addCard(getCardFromHashMap(Card.HEARTS_SUIT,3)); //push three hearts 
		cardStack.addCard(getCardFromHashMap(Card.CLUBS_SUIT,2)); //push two clubs
		cardStack.addCard(getCardFromHashMap(Card.DIAMONDS_SUIT,1)); //push ace diamonds 
		
		Card testCard = getCardFromHashMap(Card.CLUBS_SUIT, 2);
		CardStack returnedStack = cardStack.getStack(testCard);
		
		Card popped = returnedStack.pop();
		assertTrue(popped.getSuit().equals(Card.CLUBS_SUIT) && popped.getNumber()==2);
		
		popped = returnedStack.pop();
		assertTrue(popped.getSuit().equals(Card.DIAMONDS_SUIT) && popped.getNumber()==1);
		//---------------------------
		cardStack = new CardStack();
		
		cardStack.addCard(getCardFromHashMap(Card.SPADES_SUIT,4)); //push four spades
		cardStack.addCard(getCardFromHashMap(Card.HEARTS_SUIT,3)); //push three hearts 
		cardStack.addCard(getCardFromHashMap(Card.CLUBS_SUIT,2)); //push two clubs
		cardStack.addCard(getCardFromHashMap(Card.DIAMONDS_SUIT,1)); //push ace diamonds 
		
		returnedStack = cardStack.getStack(3);
		
		popped = returnedStack.pop();
		System.out.println(popped.getSuit());
		assertTrue(popped.getSuit().equals(Card.HEARTS_SUIT) && popped.getNumber()==3);
		
		popped = returnedStack.pop();
		assertTrue(popped.getSuit().equals(Card.CLUBS_SUIT) && popped.getNumber()==2);
		
		popped = returnedStack.pop();
		assertTrue(popped.getSuit().equals(Card.DIAMONDS_SUIT) && popped.getNumber()==1);
	}
	
	
	/**
	 * Test get bottom
	 */
	@Test
	public void testGetBottom() {
		assertTrue(cardStack.getBottom() == null); //test empty stack
		cardStack.push(getCardFromHashMap(Card.DIAMONDS_SUIT,1)); //push ace diamonds 
		cardStack.push(getCardFromHashMap(Card.SPADES_SUIT,10)); //push ten spades
		cardStack.push(getCardFromHashMap(Card.HEARTS_SUIT,8)); //push eight hearts 
		cardStack.push(getCardFromHashMap(Card.HEARTS_SUIT,4)); //push four hearts
		Card bottom=cardStack.getBottom();
		assertTrue(bottom.getSuit()==Card.DIAMONDS_SUIT && bottom.getNumber()==1);
	}


}
