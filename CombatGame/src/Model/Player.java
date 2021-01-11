package Model;

public class Player extends Characters
{
    //CONSTANTS
    private static final int MAX_HEALTH = 30;
    private static final int MAX_DAMAGE = 5;
    private static final int MIN_DAMAGE = 1;
    private static final int MAX_DEFENCE = 5;
    private static final int MIN_DEFENCE = 1;
    private static final int GOLD = 100;


    public Player() 
    {
        setName("Player");
        setHealth(MAX_HEALTH);
        setMaxHealth(MAX_HEALTH);
        setDamMin(MIN_DAMAGE);
        setDamMax(MAX_DAMAGE);
        setDefMin(MIN_DEFENCE);
        setDefMax(MAX_DEFENCE);
        setGold(GOLD);
    }
}