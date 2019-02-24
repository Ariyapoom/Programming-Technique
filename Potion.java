public class Potion extends Item{

    public Potion(int amount){
        super("Potion",amount);
        setValue(25,20);
        setProperty("Use for +HP 25 or +MP 20");
    }
    
}