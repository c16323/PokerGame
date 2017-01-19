/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame2;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author c16323
 */
public class PokerTester {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        List<Cards> cards = Cards.newDeck();
        
        Player akiyama = new HumanPlayer("Akiyama",100);
        
        for (int i = 0; i < 5; i++) {
            akiyama.drawIn(cards);
        }
        
        List<Cards> hand = akiyama.getHands();
        
        do{
            hand.forEach(System.out::println);
            System.out.println("1~"+(hand.size())+"で捨てる、範囲外でカードを引く");
            int i = stdIn.nextInt();
            if(i<1 || i>hand.size())
                break;
            hand.remove(hand.get(i-1));
        }while(akiyama.getHands().size()>0);
        
        System.out.println("引き直し");
        while(hand.size()<5){
            akiyama.drawIn(cards);
        }
        hand.forEach(System.out::println);
        
    }
}
