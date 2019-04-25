public class GreenSlime extends Monster{

    public GreenSlime(){
        super("Greenslime");
        maxHp = 30;
        hp = maxHp;
        exp = 10;
        level = 1;
        dmg = 10;
        dropRate = 80;
        itemDrop = new Potion();
        pic = "greenslime.png";
    }

}