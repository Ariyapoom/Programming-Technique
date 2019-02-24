public class Superpotion extends Item{

    public Superpotion(int amount){
        super("Super Potion",amount);
        setValue(50,40);
        setProperty("Use for +HP 50 or +MP 40");
    }
    
}