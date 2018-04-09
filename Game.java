import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
    private ArrayList<Card> player;
    private ArrayList<Card> dealer;
    Deck deck = new Deck();
    Scanner scan = new Scanner(System.in);
    String hit;
    String winner;
    public Game() {
        
    }
    public void main(String[] args)
    {
        Deck deck = new Deck();
        
        Card c = deck.deal();
        
        Player pOne = new Player("Joe", 100);
        Player pTwo = new Player("Jack", 100);
        pOne.hit(c);
        pTwo.hit(c);
        
        while(pOne.stay() == false) {
            c = deck.deal();
            pOne.hit(c);
        }
    }
    public void determineWinner(Player p1, Player p2) {
        if(p1.handTotal > p2.handTotal) {
            winner = "Player 1";
            p1.updateWinnings();
        }
        else {
            winner = "Player 2";
            p2.updateWinnings();
        }
    }
}
