package Model;

public class Goblin extends Characters
{
    private static final int MAX_HEALTH = 30;
    private static final int MAX_DAMAGE = 8;
    private static final int MIN_DAMAGE = 3;
    private static final int MAX_DEFENCE = 8;
    private static final int MIN_DEFENCE = 4;
    private static final int GOLD = 20;


    public Goblin()
    {
        setName("Goblin");
        setHealth(MAX_HEALTH);
        setMaxHealth(MAX_HEALTH);
        setDamMin(MIN_DAMAGE);
        setDamMax(MAX_DAMAGE);
        setDefMin(MIN_DEFENCE);
        setDefMax(MAX_DEFENCE);
        setGold(GOLD);
        setProb(0.30);        
        setChance(0.50);
        setAbility(getDamage() + 3);
        setSpecial("+ 3 damage");
    }
}