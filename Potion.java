/**
 * Potion
 */
public class Potion extends Item{

    protected int forHP;
    protected int forMp;

    public Potion(){
        super("Potion");
        forHP = 25;
        forMp = 20;
    }
    
    public int getForHp(){
        return forHP;
    }

    public int getForMp(){
        return forMp;
    }
}