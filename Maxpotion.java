public class Maxpotion extends Item{

    public Maxpotion(int amount){
        super("Max Potion",amount);
        setValue(100,80);
        setProperty("Use for +HP 100 or +MP 80");
    }
}