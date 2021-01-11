package Model;

public class Ogre extends Characters
{
    private static final int MAX_HEALTH = 40;
    private static final int MAX_DAMAGE = 10;
    private static final int MIN_DAMAGE = 5;
    private static final int MAX_DEFENCE = 12;
    private static final int MIN_DEFENCE = 6;
    private static final int GOLD = 40;


    public Ogre()
    {
        setName("ogre");
        setHealth(MAX_HEALTH);
        setMaxHealth(MAX_HEALTH);
        setDamMin(MIN_DAMAGE);
        setDamMax(MAX_DAMAGE);
        setDefMin(MIN_DEFENCE);
        setDefMax(MAX_DEFENCE);
        setGold(GOLD);
        setProb(0.20);        
        setChance(0.20);
        setAbility(getDamage() + getDamage());
        setSpecial("attack twice in a row");
    }
}