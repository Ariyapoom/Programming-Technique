import java.util.ArrayList;

/**
 * Bag
 */
public class Bag {

    private ArrayList<Item> items;
    private int bagsize;
    public Bag(){
        items = new ArrayList<Item>();
        bagsize = 20;
    }

    public Item getItem(int index){
        if(index < items.size()){
            return items.get(index);
        }
        else{
            System.out.println("Not Found");
            return null;
        }
        
    }

    public void addItem(Item newItem){
        if(items.size() < bagsize){
           items.add(newItem); 
        }
        else{
            System.out.println("Bag is Full");
        }
    }

    public int getNumberItem(){
        return items.size();
    }

    public void removeItem(int index){
        items.remove(index);
    }
}