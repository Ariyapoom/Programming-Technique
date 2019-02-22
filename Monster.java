import java.io.*;
import java.util.*;


public class Monster {
    private String monsterName;
    private int hpMonster;
    private int maxHp;
    private int expMonster;
    private int monsterDmg;
    private String itemMonster;
    private int dropRate;
    public Monster(){
        monsterName = "";
        maxHp = 0;
        hpMonster = maxHp;
        expMonster = 0;
        monsterDmg = 0;
        itemMonster = "";
        dropRate = 0;
    }
    public void selectmonster(int idMonster){
        if(idMonster == 1){
            monsterName = "Green Slime Lv.1";
            maxHp = 30;
            hpMonster = maxHp;
            expMonster = 560;
            monsterDmg = 10;
            itemMonster = "Potion";
            dropRate = 80;
        }
        if(idMonster == 2){
            monsterName = "Blue Slime Lv.5";
            maxHp = 60;
            hpMonster = maxHp;
            expMonster = 20;
            monsterDmg = 20;
            itemMonster = "Super Potion";
            dropRate = 70;
        }
        if(idMonster == 3){
            monsterName = "Red Slime lv.10";
            maxHp = 150;
            hpMonster = maxHp;
            expMonster = 50;
            monsterDmg = 40;
            itemMonster = "Hyper Potion";
            dropRate = 60;
        }
        if(idMonster == 4){
            monsterName = "Rainbow Slime lv.15";
            maxHp = 225;
            hpMonster = maxHp;
            expMonster = 75;
            monsterDmg = 60;
            itemMonster = "Max Potion";
            dropRate = 50;
        }
        if(idMonster == 5){
            monsterName = "King Blossom lv.20";
            maxHp = 300;
            hpMonster = maxHp;
            expMonster = 100;
            monsterDmg = 80;
            itemMonster = "Restoration";
            dropRate = 40;
        }
    }
    public String getNameMonster(){
        return monsterName;
    }
    public int getHpMonster(){
        return hpMonster;
    }
    public int getMaxHp(){
        return maxHp;
    }
    public int getExpMonster(){
        return expMonster;
    }
    public int getDmgMonster(){
        return monsterDmg;
    }
    public String getItem(){
        return itemMonster;
    }
    public void dmgToMonster(int dmg){
        hpMonster = hpMonster-dmg;
    }
    public int getDropRate(){
        return dropRate;
    }
}