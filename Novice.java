import java.io.*;
import java.util.*;

public class Novice extends Player{

    public Novice(String newName){
        super(newName);
        skillList.add("Trump MP 20 DMGx2");
        skillList.add("Heal MP 10 HP+20");
    }

    public int useSkill(int select){
        if(select==1 && getMp() >=20){
            System.out.println("Trump Active");
            useMp(-20);
            return getDmg()*2;
        }
        if(select==2 && getMp() >=10){
            System.out.println("Heal Active HP+20");
            useMp(-10);
            dmgToHp(20);
            return 0;
        }
        return 0;
    }    
}