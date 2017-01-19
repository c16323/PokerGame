/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame2;

/**
 *
 * @author c16323
 */
public class Card {
    CardSuit suit;
    CardRank rank;
    
    public Card(CardSuit suit,CardRank rank){
        this.suit = suit;
        this.rank = rank;
    }
    public Card(int suit,int rank){    }
}
