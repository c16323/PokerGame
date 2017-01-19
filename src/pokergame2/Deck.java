/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame2;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> deck;
    
    public Deck(){
        deck = new ArrayList<>();
    }
    public Card withdraw(int num){
        if(num>deck.size()) num = deck.size();
        return deck.remove(num);
    }

    Card remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
