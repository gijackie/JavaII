
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * @author pi
 *
 */
public class Deck {

	private List<PlayingCard> deck= new ArrayList<>();
	
	public List<PlayingCard> getDeck() {
		return this.deck;
	}
	
	public void Deck(){
		
	}
	
	
	
	public void printDeckUsingFor(List<PlayingCard> deck) {
		for (PlayingCard card : deck) {
			System.out.println(card.rank + " of " + card.suit);
		}
	}
	
	public void printDeckUsingIterator(List<PlayingCard> deck) {
		Iterator<PlayingCard> iter = deck.iterator();
		while (iter.hasNext()) {
			PlayingCard card = iter.next();
			System.out.println(card.rank + " of " + card.suit);
		}
	}

	public List<PlayingCard> shuffle() {
		ArrayList<PlayingCard> newDeck = new ArrayList<>(deck);
		int deckSize = newDeck.size();
		
		/*  do the shuffle using random indices a random number of times */
		Random rand = new Random();
		int loops = rand.nextInt(200);
		for (int i = 0; i < loops; i++) {
			int index1 = rand.nextInt(deckSize);
			int index2 = rand.nextInt(deckSize);
			PlayingCard card1 = newDeck.get(index1);
			PlayingCard card2 = newDeck.get(index2);
			newDeck.set(index2,card1);
			newDeck.set(index1,card2);
		}
		return newDeck;
	}
	
	public void removeSpades(Deck d1){
		System.out.println("Inside remove Spades");
		ListIterator<PlayingCard> it = deck.listIterator();
		while (it.hasPrevious()){
			System.out.println("it.hasPrevious");
			PlayingCard card = it.previous();
			if(card.suit.equals(VALIDSUITS.SPADES)){
				deck.remove(card);
			}
			
		}
	}
	
	public static void main(String[] args) {
		// Create a normal deck of 52 PlayingCard instances
		Deck deck_1 = new Deck();
		System.out.println("Building deck...");
		
		for (VALIDSUITS the_suit : VALIDSUITS.values()) {
			for (VALIDRANKS the_rank : VALIDRANKS.values()) {
				deck_1.deck.add(new PlayingCard(the_suit, the_rank));
			}
		}
		//Added this part to remove the spades
		deck_1.removeSpades(deck_1);
		System.out.println(deck_1);
		//***********************
/*		System.out.println("Printing deck with enhanced for...");
		deck_1.printDeckUsingFor(deck_1.deck);
		System.out.println("Printing deck with Iterator...");
		deck_1.printDeckUsingIterator(deck_1.deck);
		System.out.println("Printing a shuffled deck..." );
		deck_1.printDeckUsingIterator(deck_1.shuffle());*/
	}

}
