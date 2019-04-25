/**
 * BlueSlime
 */
public class BlueSlime extends Monster{

    public BlueSlime(){
        super("BlueSlime");
        maxHp = 60;
        hp = maxHp;
        exp = 20;
        level = 5;
        dmg = 20;
        dropRate = 80;
        itemDrop = new Potion();
        pic = "blueslime.png";
    }
    
}