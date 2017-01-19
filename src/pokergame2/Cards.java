/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * @author c16323
 */
public class Cards {

    public enum Suit{

        Diamond("♦",0),
        Clover("♣",1),
        Spade("♠",2),
        Heart("❤",3);
        
        private String label;
        private int id;
        
        Suit(String label,int id){
            this.label = label;
            this.id = id;
        }
        public String getSuitLabel(){return label;}
        public int getSuitId(){return id;}
    }
    
    public enum Rank{
        Ace("A",1),Two("2",2),Three("3",3),Four("4",4),Five("5",5),
        Six("6",6),Seven("7",7),Eight("8",8),Nine("9",9),Ten("10",10),
        Jack("J",11),Queen("Q",12),King("K",13);
        
        private String label;
        private int id;
        Rank(String label,int id){
            this.label = label;
            this.id = id;
        }
        public String getRankLabel(){return label;}
        public int getRankId(){return id;}
    }
    
    static final List<Cards> deck = new ArrayList<>();
    private final Suit suit;
    private final Rank rank;
    
    Cards(Suit suit,Rank rank){
        this.suit = suit;
        this.rank = rank;
    }
    public int getSuit(){return suit.getSuitId();}
    public int getRank(){return rank.getRankId();}
    
    static {
        for(Suit suit:Suit.values()){
            for(Rank rank:Rank.values()){
                deck.add(new Cards(suit,rank));
            }
        }
    }
    public static List<Cards> newDeck(){
        Collections.shuffle(deck);
        return deck;
    }
    @Override
    public String toString(){
        return String.format("%s %s",suit.getSuitLabel(),rank.getRankLabel());
    }
}
