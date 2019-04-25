/**
 * MeteoStormSkill
 */
public class MeteoStormSkill extends Skill{

    public MeteoStormSkill(int baseDMG){
        super("MeteoStorm : 100 MP");
        damage = baseDMG*8; 
        mpUse = 100;
    }
}