/**
 * GoldenSlime
 */
public class GoldenSlime extends Monster{

    public GoldenSlime(){
        super("GoldenSlime");
        maxHp = 225;
        hp = maxHp;
        exp = 75;
        level = 15;
        dmg = 60;
        dropRate = 80;
        itemDrop = new Potion();
        pic = "goldenslime.png";
    }
}