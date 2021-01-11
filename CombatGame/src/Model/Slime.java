package Model;

public class Slime extends Characters 
{
    private static final int MAX_HEALTH = 10;
    private static final int MAX_DAMAGE = 5;
    private static final int MIN_DAMAGE = 3;
    private static final int MAX_DEFENCE = 2;
    private static final int MIN_DEFENCE = 0;
    private static final int GOLD = 10;

    public Slime() {
        setName("Slime");
        setHealth(MAX_HEALTH);
        setMaxHealth(MAX_HEALTH);
        setDamMin(MIN_DAMAGE);
        setDamMax(MAX_DAMAGE);
        setDefMin(MIN_DEFENCE);
        setDefMax(MAX_DEFENCE);
        setGold(GOLD);
        setProb(0.50);
        setChance(0.20);
        setAbility(getDamage() * 0);
        setSpecial("no damage");
    } 

}