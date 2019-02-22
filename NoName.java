import java.io.*;
import java.util.*;

public class NoName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("Insert Name:");
        String name = scanner.nextLine();
        Player novice;
        novice = new Novice(name);
        Monster monster = new Monster();

        while (true) {
            System.out.println("========================");
            novice.showAllStatus();
            System.out.println("========================");
            System.out.println("1. Go Fight");
            System.out.println("2. Bag");
            System.out.println("0. Exit");
            System.out.println("========================");
            int choose = scanner.nextInt();
            if (choose == 0) {
                break;
            } else if (choose == 2) {
                System.out.println("========================");
                System.out.println("My Bag");
                System.out.println("========================");
                System.out.println("0. Exit");
                novice.bag.showitem();
                System.out.println("========================");
                int selectItem = scanner.nextInt();
                if (selectItem > 0 && selectItem <= novice.bag.getCountBag()) {
                    novice.usepotion(selectItem);
                }
            } 
            else if(choose == 1){
                System.out.println("========================");
                System.out.println("Select Monster");
                System.out.println("========================");
                System.out.println("1. Green Slime Lv.1");
                System.out.println("2. Blue Slime Lv.5");
                System.out.println("3. Red Slime lv.10");
                System.out.println("4. Rainbow Slime lv.15");
                System.out.println("5. King Blossom lv.20");
                System.out.println("6. LV Upper For Class 2");
                System.out.println("========================");
                int monsterChoose = scanner.nextInt();
                monster.selectmonster(monsterChoose);
                while (monster.getHpMonster() > 0) {
                    System.out.println("========================");
                    System.out.println("Monster");
                    System.out.println(monster.getNameMonster());
                    System.out.println("HP : " + monster.getHpMonster() + "/" + monster.getMaxHp());
                    System.out.println("========================");
                    System.out.println("Your HP : " + novice.gethp() + "/" + novice.getmaxHp());
                    System.out.println("Your MP : " + novice.getMp() + "/" + novice.getMaxMp());
                    System.out.println("========================");
                    System.out.println("1.Attack DMG "+novice.getDmg());
                    System.out.println("2.Skill Attack");
                    System.out.println("3.Bag");
                    System.out.println("3.Run");
                    System.out.println("========================");
                    int selectAttack = scanner.nextInt();
                    if (selectAttack == 1) {
                        System.out.println("You Attack Monster "+novice.getDmg()+" Dmg");
                        monster.dmgToMonster(novice.getDmg());
                    }
                    else if(selectAttack == 2){
                        System.out.println("========================");
                        System.out.println("Skill");
                        System.out.println("========================");
                        novice.showSkillList();
                        System.out.println("========================");
                        int skillDmg = novice.useSkill(scanner.nextInt());
                        System.out.println("You Attack Monster " + skillDmg + " Dmg");
                        monster.dmgToMonster(skillDmg);
                    } 
                    else if (selectAttack == 3) {
                        System.out.println("========================");
                        System.out.println("My Bag");
                        System.out.println("========================");
                        System.out.println("0. BacktoFight");
                        novice.bag.showitem();
                        System.out.println("========================");
                        int selectItem = scanner.nextInt();
                        if (selectItem > 0 && selectItem <= novice.bag.getCountBag()) {
                            novice.usepotion(selectItem);
                        }
                    }
                    else {
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(selectAttack != 3){
                        System.out.println("You Take "+monster.getDmgMonster()+" Dmg");
                        novice.dmgToHp(-monster.getDmgMonster());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (novice.gethp() <= 0) {
                            break;
                        }
                }
                }
                if (novice.gethp() <= 0) {
                    novice.resurrection();
                }
                else if(monster.getHpMonster() <= 0){
                    //Reward
                    System.out.println("Monster Defeated");
                    novice.expgain(monster.getExpMonster());
                    System.out.println("+EXP : "+monster.getExpMonster());
                    novice.lvlup(); 
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(rand.nextInt(101) < monster.getDropRate()){
                    int amount=rand.nextInt(2)+1;
                    System.out.println("Item Drop : "+monster.getItem()+" "+amount+" ea");
                    novice.bag.getNewItem(monster.getItem(),amount);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    }
                    if(novice.getlvl() >= 10 && novice.getJobClass().equals("Novice")){
                        System.out.println("Class Up");
                        System.out.println("========================");
                        System.out.println("Choose Your Class 1");
                        System.out.println("========================");
                        System.out.println("1. Swordman");
                        System.out.println("2. Magician");
                        int selectclass = scanner.nextInt();
                        if(selectclass == 1){
                            novice = new Swordman(novice);
                        }
                        if(selectclass == 2){
                            novice = new Magician(novice);    
                        }
                    }
                }
            }
        }
    }
}