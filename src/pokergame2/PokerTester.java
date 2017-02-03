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
        
        
        Player akiyama = new HumanPlayer("human",100);
        ComputerPlayer mac = new ComputerPlayer("mac",100);
        Table table = new Table();
        
        List<Cards> cards = Cards.newDeck();
        for (int i = 0; i < 5; i++) {
            akiyama.drawIn(cards);
            mac.drawIn(cards);
        }
        
        List<Cards> hand = akiyama.getHands();
        List<Cards> chand=mac.getHands();
        
        int chip=0;
        hand.forEach(System.out::println);
        
        System.out.println("mac:"+table.fieldChip(mac.bet(0)));
        System.out.print("ベット枚数指定：");
        do{
            chip = stdIn.nextInt();
        }while(chip>akiyama.getCoins() || 0>chip);
        
        akiyama.bet(chip);
        System.out.println(table.fieldChip(chip));
        
        
        do{
            
            System.out.println("1~"+(hand.size())+"で捨てる、範囲外でカードを引く");
            hand.forEach(System.out::println);
            int i = stdIn.nextInt();
            if(i<1 || i>hand.size())
                break;
            hand.remove(hand.get(i-1));
        }while(akiyama.getHands().size()>0);
        
        System.out.println("引き直し");
        while(hand.size()<5){
            akiyama.drawIn(cards);
        }
        System.out.println(akiyama.getName()+"の手札");
        hand.forEach(System.out::println);
        System.out.println(table.handJudge(akiyama.getHands()));
        
        System.out.println(mac.getName()+"の手札");
        chand.forEach(System.out::println);
        System.out.println(table.handJudge(mac.getHands()));
        
        System.out.println("勝者："+table.Judge(akiyama, mac));
        
        System.out.println(akiyama.getName()+"のコイン："+akiyama.getCoins());
        System.out.println(mac.getName()+"のコイン："+mac.getCoins());
        
    }
}
