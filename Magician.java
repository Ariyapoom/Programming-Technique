/**
 * Magician
 */
public class Magician extends Player{

    public Magician(Player lastPlayer){
        super(lastPlayer.getName(), "Magician");
        maxHp = lastPlayer.getmaxHp();
        maxMp = lastPlayer.getMaxMp()+30;
        hp = maxHp;
        mp = maxMp;
        exp = lastPlayer.getexp();
        myDmg = lastPlayer.getDmg();
        level = lastPlayer.getlvl();
        myBag = lastPlayer.myBag;
        skills.add(new FireballSkill(myDmg));
        skills.add(new MeteoStormSkill(myDmg));
        playerPic ="MagicianPic.png";
        killcount = lastPlayer.getKillCount();
    }
}