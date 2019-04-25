/**
 * BashSkill
 */
public class BashSkill extends Skill{

    public BashSkill(int baseDMG){
        super("Bash : 30 MP");
        damage = baseDMG*3; 
        mpUse = 30;
    }
}