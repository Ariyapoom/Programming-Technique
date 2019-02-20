import java.io.*;
import java.util.*;

public class Novice {
    private int hp;
    private int mp;
    private int exp;
    private int level;
    private int maxHp;
    private int maxMp;
    private int myDmg;
    private String name;
    private String jobClass;
    public Bag bag ;

    public Novice(String newName) {
        name = newName;
        jobClass = "Novice";
        level = 1;
        maxHp = 50;
        maxMp = 30;
        hp = maxHp;
        mp = maxMp;
        exp = 0;
        myDmg = 10;
        bag = new Bag();
    }
    
    public String getName(){
        return name;
    }

    public String getJobClass(){
        return jobClass;
    }

    public int getmaxHp(){
        return maxHp;
    }

    public int gethp() {
        return hp;
    }

    public int getMaxMp(){
        return maxMp;
    }

    public int getMp(){
        return mp;
    }

    public int getexp() {
        return exp;
    }

    public int getlvl() {
        return level;
    }
    public int getDmg(){
        return myDmg;
    }
    public void showAllStatus(){
        System.out.println("Name: " + name);
        System.out.println("Class: " + jobClass);
        System.out.println("Level: " + level);
        System.out.println("HP: " + hp + "/" + maxHp);
        System.out.println("MP: " + mp + "/" + maxMp);
        System.out.println("EXP: " + exp + "/" + level*10);
    }

    public void expgain(int expIncome) {
        exp = exp + expIncome;
    }

    public void dmgToHp(int dmg) {
        hp = hp + dmg;
        if(hp > maxHp){
            hp = maxHp;
        }
    }

    public void useMp(int used){
        mp += used;
        if(mp>maxMp){
            mp = maxMp;
        }
    }

    public void lvlup(int expNow, int lvlNow) {
        while (expNow >= lvlNow * 10) {
            level++;
            expNow = expNow - (lvlNow * 10);
            exp = expNow;
            maxHp = maxHp + 20;
            maxMp = maxMp +10;
            hp = maxHp;
            mp = maxMp;
            myDmg += 5;
            System.out.println("Level Up!!!!!");
        }
    }
    
    public void resurrection() {
        hp = maxHp / 2;
        mp = maxMp / 2;
        System.out.println("You Lose!!!");
        System.out.println("Waiting For Resurrection....");
        try {
            Thread.sleep(5000);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("+++++++Resurrection+++++++");
    }

    public void usepotion(int index){
        dmgToHp(bag.getHpFromPotion(index));
        useMp(bag.getMpFromPotion(index));
        bag.usePotion(index);
    }
    
    public int useSkill(int select){
        int skillDmg = 0;
        if(select == 1){
            if(mp >= 20){
               skillDmg = myDmg*2; 
               mp -= 20;
               System.out.println("Bash Atctive");
            }
            else{
                System.out.println("Not Enough MP");
            }    
        }
        else if(select == 2){
            if(mp >= 10){
                dmgToHp(20);
                mp -= 10;
                System.out.println("Heal Active HP+20");
            }
            else{
                System.out.println("Not Enough MP");
            }  
        }
        return skillDmg;
    }
}
