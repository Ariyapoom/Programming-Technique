/**
 * Novice
 */
public class Novice extends Player{

    public Novice(String newName){
        super(newName, "Novice");
        maxHp = 50;
        maxMp = 30;
        hp = maxHp;
        mp = maxMp;
        exp = 0;
        myDmg = 10;
        skills.add(new NormalAttack(myDmg));
        playerPic = "NovicePic.png";
    }
    
}