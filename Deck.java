import java.util.ArrayList;
import java.util.Random;

public class Deck
{
    private ArrayList<Card> deck;
    int index;
    
    public Deck()
    {
        deck = new ArrayList<Card>();
        initializeDeck();
    }
    
    public void initializeDeck() {
        String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
        String[] ranks = {"Ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "Jack", "Queen", "King"};
        for (String s : suits) {
            int value = 1;
            for(String r : ranks) {
                Card temp =new Card(value, s, r);
                value++;
                deck.add(temp);
            }
        }
    }
    
    public void printDeck() {
        for(Card c : deck) {
            System.out.println(c);
        }
    }
    
    public Card deal() {
        Random r = new Random();
        int index = r.nextInt(deck.size());
        Card temp = deck.get(index);
        deck.remove(index);
        return temp;
    }
}
