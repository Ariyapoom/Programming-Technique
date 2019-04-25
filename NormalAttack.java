/**
 * NormalAttack
 */
public class NormalAttack extends Skill{

    public NormalAttack(int baseDMG){
        super("Normal Attack : 10 MP");
        damage = (int)(baseDMG*1.5);
        mpUse = 10;
    }
}