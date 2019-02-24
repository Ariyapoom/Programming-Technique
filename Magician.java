import java.io.*;
import java.util.*;

public class Magician extends Player{
    
    public Magician(Player lastPlayer){
        super(lastPlayer.getName());
        setClass("Magician",lastPlayer.getmaxHp(),lastPlayer.getMaxMp(),lastPlayer.getlvl(),lastPlayer.getDmg(),lastPlayer.bag);
        skillList.add("Fire Ball MP 50 DMG x 6");
        skillList.add("Meteo Strom MP 100 DMG x 10");
        
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
            if(getMp() >= 50){
                System.out.println("Fire Ball Active");
                useMp(50);
                return getDmg()*6;
            }
            else{
                System.out.println("Not Enough MP");
            }
        }
        if(select==2){
            if(getMp() >= 100){
                System.out.println("Meteo Strom Active");
                useMp(100);
                return getDmg()*10;
            }
            else{
                System.out.println("Not Enough MP");
            }
        }
        return 0;
    }
}