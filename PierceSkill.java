/**
 * PierceSkill
 */
public class PierceSkill extends Skill{

    public PierceSkill(int baseDMG){
        super("Pierce : 40 MP");
        damage = baseDMG*4; 
        mpUse = 40;
    }
}