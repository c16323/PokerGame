/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokergame2;
import java.util.Random;
/**
 *
 * @author c16323
 */
public class ComputerPlayer extends Player{
    
    public ComputerPlayer(String name,int coins){
        super(name,coins);
    }
    @Override
    public int bet(int num){
        Random rand = new Random();
        int betcoin = rand.nextInt(coins);
        coins -= betcoin;
        return betcoin;
    }
}