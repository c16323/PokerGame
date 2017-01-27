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
    //コインと役の管理
    private boolean pflag;
    private int chip=0;
    public Table(){}
    
    public String fieldChip(int num){
        chip += num;
        return num+"枚ベットしました。　場のチップ = "+chip;
    }
    
    public String Judge(List<Cards> hand){
        //equal
        //ワンペア：同ランク2枚1組が一つ
        //ツーペア：同ランク2枚1組が二つ
        pflag = false;
        if (TorF(hand)=="four")
            return "FourCard";
        if (Flash(hand)==true)
            return "Flash";
        if (Straight(hand)==true)
            return "Straight";
        if (TorF(hand)=="three")
            return "ThreeCard";
        if (Pare(Pare(hand))!=null)
            return "TwoPare";
        if (pflag==true)
            return "OnePare";
        return "";
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
    private List<Cards> Pare(List<Cards> hand){
        if (hand==null)
            return null;
        for (int i = 0; i < hand.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (hand.get(i).getRank() == hand.get(j).getRank()) {
                    hand.remove(hand.get(i));
                    hand.remove(hand.get(j));
                    pflag=true;
                    return hand;
                }
            }
        }
        return null;
    }
}
