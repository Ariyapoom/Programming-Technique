import java.io.*;
import java.util.*;


public class Item {
    private String itemName;
    private int itemAmount;
    private int healAmount;
    private int mpAmount;

    public Item(String name,int number){
        itemName  = name;
        itemAmount = number;
        if(name.equals("Potion")){
            healAmount = 25;
            mpAmount = 10;
        }
        else if(name.equals("Super Potion")){
            healAmount = 50;
            mpAmount = 20;
        }
        else if(name.equals("Hyper Potion")){
            healAmount = 75;
            mpAmount =30;
        }
        else if(name.equals("Max Potion")){
            healAmount = 100;
            mpAmount = 40;
        }
        else if(name.equals("Restoration")){
            healAmount = 9999;
            mpAmount = 9999;
        }
    }

    public String getItemName(){
        return itemName;
    }

    public String getItemNameAndValue(){
        return itemName + " HP+" + healAmount + "MP+" + mpAmount;
    }

    public int getAmount(){
        return itemAmount;
    }

    public void setAmount(int amount){
        itemAmount += amount;
    }

    public int getHealAmount(){
        return healAmount;
    }

    public int getMpAmount(){
        return mpAmount;
    }

}