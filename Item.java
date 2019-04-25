/**
 * Item
 */
public class Item {

    protected String itemName;
    public Item(String name){
        itemName = name;
    }
    public String getItemName(){
        return itemName;
    }

    public int getForHp(){
        return 0;
    }

    public int getForMp(){
        return 0;
    }
}