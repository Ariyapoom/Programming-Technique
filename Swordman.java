import java.io.*;
import java.util.*;

public class Swordman extends Player{
    

    public Swordman(Player lastPlayer){
        super(lastPlayer.getName());
        setClass("Swordman",lastPlayer.getmaxHp(),lastPlayer.getMaxMp(),lastPlayer.getlvl(),lastPlayer.getDmg(),lastPlayer.bag);
        skillList.add("Bash MP 30 DMG x 5");
        skillList.add("Priece MP 50 DMG x 7");
    }
    public void showSkillList(){
        int i=0;
        for (String skill : skillList) {
            System.out.println((i+1)+". "+skill);
            i++;
        }
    }
    public int useSkill(int select){
        if(select==1){
            if(getMp() >= 30){
                System.out.println("Bash Active");
                useMp(-30);
                return getDmg()*5;
            }
            else{
                System.out.println("Not Enough MP");
            }
        }
        if(select==2){
            if(getMp() >= 50){
                System.out.println("priece Active");
                useMp(-50);
                return getDmg()*7;
            }
            else{
                System.out.println("Not Enough MP");
            }
        }
        
        return 0;
    }    
}