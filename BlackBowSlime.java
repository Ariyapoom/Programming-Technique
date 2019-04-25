/**
 * BlackBowSlime
 */
public class BlackBowSlime extends Monster{

    public BlackBowSlime(){
        super("BlackBowSlime");
        maxHp = 300;
        hp = maxHp;
        exp = 100;
        level = 20;
        dmg = 80;
        dropRate = 80;
        itemDrop = new Potion();
        pic ="blackslime.png";
    }
}