/**
 * FireballSkill
 */
public class FireballSkill extends Skill{

    public FireballSkill(int baseDMG){
        super("Fireball : 50 MP");
        damage = baseDMG*5; 
        mpUse = 50;
    }
}