public class Monster {
    protected int hp;
    protected int maxHp;
    protected int exp;
    protected int dmg;
    protected int level;
    protected int dropRate;
    protected Item itemDrop;
    protected String pic;
    private String name;
    
    public Monster(String newName){
        name = newName;
        maxHp = 0;
        hp = maxHp;
        exp = 0;
        level = 0;
        dmg = 0;
        dropRate = 0;
        pic ="";
    }
    
    public String getPic(){
        return pic;
    }

    public String getName(){
        return name;
    }

    public int getlvl(){
        return level;
    }

    public int getHp(){
        return hp;
    }

    public int getMaxHp(){
        return  maxHp;
    }

    public int getDmg(){
        return dmg;
    }

    public int getExp(){
        return exp;
    }

    public void takingDmg(int commingDmg){
        hp -= commingDmg;
        if(hp < 0){
            hp = 0;
        }
    }

    public String toString() {
        return "Name :" + name + "  Level :" + level + "  HP :" + maxHp + "/" + hp;
    }

    public boolean isDie(){
        if(hp == 0){
            return true;
        }
        return false;
    }

    public Item DropItem(){
        if(Math.random()*100+1 < dropRate){
            return itemDrop;
        }
        return null;
    }
}