import java.io.*;
import java.util.*;


public class Item {
    private String itemName;
    private String itemProperty;
    private int itemAmount;
    private int healAmount;
    private int mpAmount;

    public Item(String name,int number){
        itemName  = name;
        itemAmount = number;
        itemProperty = "";
    }
    public void setValue(int valueForHp,int valueForMp){
        healAmount = valueForHp;
        mpAmount = valueForMp;
    }

    public String getItemName(){
        return itemName;
    }

    public String getItemProperty(){
        return itemProperty;
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

    public void setProperty(String property){
        itemProperty = property;
    }

    public void printProperty(){
        System.out.println(itemProperty);
    }

}