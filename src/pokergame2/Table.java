 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame2;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author c16323
 */
public class Table {
    private int chip=0;
    public Table(){}
    
    public String fieldChip(int num){
        chip += num;
        return num+"枚ベットしました。　場のチップ = "+chip;
    }
    public String handJudge(List<Cards> hand){
        switch(Judge(hand)){
            case 6:return "FourCard";
            case 5:return "Flash";
            case 4:return "Straight";
            case 3:return "ThreeCard";
            case 2:return "TwoPair";
            case 1:return "OnePair";
            default:return "NoPair";
        }
    }
    public int Judge(List<Cards> hand){
        if (TorF(hand)=="four")
            return 6;
        if (Flash(hand)==true)
            return 5;
        if (Straight(hand)==true)
            return 4;
        if (TorF(hand)=="three")
            return 3;
        String result = Pair(hand);
        if (result == "Two")
            return 2;
        if (result == "One")
            return 1;
        return 0;
    }public String Judge(Player p1,Player p2){
        int p1point = Judge(p1.getHands());
        int p2point = Judge(p2.getHands());
            if (p1point > p2point) {
                p1.setCoins(chip);
                chip = 0;
                return p1.getName();
            }
            else if (p2point > p1point) {
                p2.setCoins(chip);
                chip = 0;
                return p2.getName();
            }else {
                chip = 0;
                return "なし";
            }
    }
    private boolean Flash(List<Cards> hand){
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(0).getSuit() != hand.get(i).getSuit()) {
                return false;
            }
        }
        return true;
    }
    private boolean Straight(List<Cards> hand){
        Cards card = null;
        card = hand.get(0);
        int count = 0;
        for (int i = 1; i < hand.size(); i++)
            if (card.getRank()>hand.get(i).getRank())
                card = hand.get(i);
        for (int i = 0; i < hand.size(); i++) {
            if (card.getRank()+1 == hand.get(i).getRank()) {
                card=hand.get(i);
                count++;
            }
            if (count==4)return true;
        }
        return false;
    }
    private String TorF(List<Cards> hand){
        for (int i = 0; i < hand.size(); i++) {
            int count = 0;
            Cards comp = hand.get(i);
            for (int j = 0; j < hand.size(); j++) {
                if (comp.getRank() == hand.get(j).getRank())
                    count++;
            }
            if (count==3)
                return "three";
            if(count==4)
                return "four";
        }
        return "";
    }
    private String Pair(List<Cards> hand){
        Cards[] stock = new Cards[4];
        int rank=0;
        for (int i = 0; i < hand.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (hand.get(i).getRank() == hand.get(j).getRank()) {
                    stock[0] = (hand.get(i));
                    stock[1] = (hand.get(j));
                    rank = hand.get(i).getRank();
                }
            }
        }
        for (int i = 0; i < hand.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (hand.get(i).getRank() == hand.get(j).getRank() 
                        && hand.get(i).getRank()!=rank) {
                    stock[2] = (hand.get(i));
                    stock[3] = (hand.get(j));
                    return "Two";
                }
            }
        }
        if (rank!=0)
            return "One";
        else
            return "";
    }
}
