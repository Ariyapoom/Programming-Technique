/**
 * RedSlime
 */
public class RedSlime extends Monster{

    public RedSlime(){
        super("RedSlime");
        maxHp = 150;
        hp = maxHp;
        exp = 50;
        level = 10;
        dmg = 20;
        dropRate = 80;
        itemDrop = new Potion();
        pic = "redslime.png";
    }
}