/**
 * SwordMan
 */
public class SwordMan extends Player{

    public SwordMan(Player lastPlayer){
        super(lastPlayer.getName(), "Swordman");
        maxHp = lastPlayer.getmaxHp()+30;
        maxMp = lastPlayer.getMaxMp();
        hp = maxHp;
        mp = maxMp;
        exp = lastPlayer.getexp();
        myDmg = lastPlayer.getDmg();
        level = lastPlayer.getlvl();
        myBag =lastPlayer.myBag;
        skills.add(new BashSkill(myDmg));
        skills.add(new PierceSkill(myDmg));
        playerPic ="SwordmanPic2.png";
        killcount =lastPlayer.getKillCount();
    }
}