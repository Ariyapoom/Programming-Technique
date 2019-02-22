import java.io.*;
import java.util.*;

public class Player {
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
    ArrayList<String> skillList;

    public Player(String newName) {
        this.name = newName;
        jobClass = "Novice";
        level = 1;
        maxHp = 50;
        maxMp = 30;
        hp = maxHp;
        mp = maxMp;
        exp = 0;
        myDmg = 10;
        bag = new Bag();
        skillList = new ArrayList<String>();
    }

    public void setClass(String newClass,int newHp,int newMp,int newLv,int newDmg,Bag newbag){
        jobClass = newClass;
        maxHp = newHp;
        maxMp = newMp;
        level = newLv;
        myDmg = newDmg;
        bag = newbag;
        hp = maxHp;
        mp = maxMp;
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

    public void lvlup() {
        while (exp >= level * 10) {
            exp = exp - (level * 10);
            level++;
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
    public void showSkillList(){
        int i=0;
        for (String skill : skillList) {
            System.out.println((i+1)+". "+skill);
            i++;
        }
    }
    public int useSkill(int select){
        int skillDmg = 0;
        return skillDmg;
    }
}
