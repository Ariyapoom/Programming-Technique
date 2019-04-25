/**
 * NekoSlime
 */
public class NekoSlime extends Monster{

    public NekoSlime(){
        super("NekoSlime(Level Upper)");
        maxHp = 10;
        hp = maxHp;
        exp = 450;
        level = 99;
        dmg = 10;
        dropRate = 80;
        itemDrop = new Potion();
        pic = "nekoslime.png";
    }
}