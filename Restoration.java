public class Restoration extends Item{

    public Restoration(int amount){
        super("Max Potion",amount);
        setValue(9999,9999);
        setProperty("Use for +Full HP or +Full MP");
    }
}