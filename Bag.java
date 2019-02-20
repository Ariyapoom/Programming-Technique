import java.io.*;
import java.util.*;

public class Bag {
    private ArrayList<Item> items;
    private int bagSize;

    public Bag(){
        items = new ArrayList<Item>();
        bagSize = 10;
        items.add(new Item("Potion",3));
    }

    public void showitem(){
        int i = 1;
        for(Item item : items){
            System.out.println(i +". "+ item.getItemNameAndValue()+" x"+item.getAmount());
            i++;
        }
    }
    public String getItem(int index){
        return  items.get(index-1).getItemName();
    }
    
    public int getCountBag(){
        return items.size();
    }

    public void getNewItem(String nameItem,int amount){
        if(isFull()){
            System.out.println("Bag is Full");
            return;
        }
        else if(isItHave(nameItem)){
            for (Item item : items) {
                if(item.getItemName().equals(nameItem)){
                    item.setAmount(amount);
                    return;
                }
            }
        }
        else items.add(new Item(nameItem,amount));
    }
    private boolean isItHave(String nameItem){
        for (Item item : items) {
            if(item.getItemName().equals(nameItem)){
                return true;
            }
        }
        return false;
    }

    private boolean isFull(){
        if(items.size() >= bagSize){
            return true;
        }
        return false;
    }

    public void usePotion(int index){
        items.get(index-1).setAmount(-1);
        System.out.println("Use "+items.get(index-1).getItemName());
        System.out.println("HP+ " + items.get(index-1).getHealAmount());
        System.out.println("Mp+" + items.get(index-1).getMpAmount());
        if(items.get(index-1).getAmount() == 0){
            items.remove(index-1);
        }   
    }

    public int getHpFromPotion(int index){
        return items.get(index-1).getHealAmount();
    }

    public int getMpFromPotion(int index){
        return items.get(index-1).getMpAmount();
    }

}