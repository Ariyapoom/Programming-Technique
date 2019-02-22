import java.io.*;
import java.util.*;

public class Novice extends Player{

    public Novice(String newName){
        super(newName);
        super.skillList.add("Trump MP 20 DMGx2");
        super.skillList.add("Heal MP 10 HP+20");
    }

    public int useSkill(int select){
        if(select==1 && super.getMp() >=20){
            System.out.println("Trump Active");
            super.useMp(-20);
            return super.getDmg()*2;
        }
        if(select==2 && super.getMp() >=10){
            System.out.println("Heal Active HP+20");
            super.useMp(-10);
            super.dmgToHp(20);
            return 0;
        }
        return 0;
    }    
}