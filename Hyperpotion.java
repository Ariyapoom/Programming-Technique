
public class Hyperpotion extends Item{

    public Hyperpotion(int amount){
        super("Hyper Potion",amount);
        setValue(75,60);
        setProperty("Use for +HP 75 or +MP 60");
    }
}