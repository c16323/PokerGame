
package pokergame2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author c16323
 */
public class Player {
    private String name;
    int coins = 0;
    private List<Cards> hand;
    
    public Player(String name,int coins){
        this.name = name;
        this.coins = coins;
        hand = new ArrayList<>();
    }
    public void setCoins(int num){this.coins += num;}
    
    public String getName(){return name;}
    public int getCoins(){return coins;}
    public List<Cards> getHands(){return hand;}
    
    public int bet(int num){
        coins -= num;
        return num;
    }
    Cards drawOut(int index){
        return hand.remove(index);
    }
    void drawIn(List<Cards> deck){
        hand.add(deck.remove(0));
        
    }
}
