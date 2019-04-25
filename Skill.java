/**
 * Skill
 */
public class Skill {

    protected int damage;
    protected int mpUse;
    private String skillName;
    
    public Skill(String name){
        skillName = name;
        damage = 0;
        mpUse = 0;
    }

    public int getSkillDamage(){
        return damage;
    }

    public int getSkillMpUse(){
        return mpUse;
    }

    public String getSkillName(){
        return skillName;
    }
}