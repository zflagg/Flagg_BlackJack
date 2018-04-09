import java.util.ArrayList;
import java.util.Scanner;
public class Player
{
    public int money;
    public int handTotal;
    public int bet;
    public boolean bust;
    String name;
    ArrayList<Card> currentHand = new ArrayList<Card>();
    public boolean ace;
    
    Scanner scan = new Scanner(System.in);
    
    public Player(String n, int m) {
        this.name = n;
        this.money = m;
    }
    
    public void getName(String n) {
        this.name = n;
    }
    public void bet(int b) {
        this.bet = b;
        if(b < money) {
            money -= b;
        }
        else {
            System.out.println("Nice try, you don't have that money.");
        }
    }
    public void hit(Card c) {
        currentHand.add(c);
    }
    public boolean stay() {
        System.out.println("Stay? y/n");
        String hit = scan.next();
        
        if (hit.equals("y")) return true;
        else return false;
    }
    public void updateWinnings() {
        money += 2*bet;
    }
    public void checkHand(ArrayList<Card> hand) {
        for (Card c : hand) {
            handTotal += c.value;
            if(c.value == 1) {
                if(handTotal + 10 < 21) {
                    handTotal +=10;
                    ace = true;
                }
            }
        }
        if(handTotal > 21) {
            if(ace == true) {
                handTotal -= 10;
            }
            else {
                bust = true;
            }
        }
    }
    
    
}
