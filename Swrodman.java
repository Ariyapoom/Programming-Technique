import java.io.*;
import java.util.*;

public class Swrodman extends Player{
    

    public Swrodman(Player lastPlayer){
        super(lastPlayer.getName());
        super.setClass("Swrodman",lastPlayer.getmaxHp(),lastPlayer.getMaxMp(),lastPlayer.getlvl(),lastPlayer.getDmg(),lastPlayer.bag);
        super.skillList.add("Bash MP 30 DMG x 5");
        super.skillList.add("Priece MP 50 DMG x 7");
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
            if(super.getMp() >= 30){
                System.out.println("Bash Active");
                return super.getDmg()*5;
            }
            else{
                System.out.println("Not Enough MP");
            }
        }
        if(select==2){
            if(super.getMp() >= 50){
                return super.getDmg()*7;
            }
            else{
                System.out.println("Not Enough MP");
            }
        }
        
        return 0;
    }    
}