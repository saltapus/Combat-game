package Model;

public class Dragon extends Characters 
{

    private static final int MAX_HEALTH = 100;
    private static final int MAX_DAMAGE = 30;
    private static final int MIN_DAMAGE = 15;
    private static final int MAX_DEFENCE = 20;
    private static final int MIN_DEFENCE = 15;
    private static final int GOLD = 100;


    public Dragon() 
    {
        setName("Dragon");
        setHealth(MAX_HEALTH);
        setMaxHealth(MAX_HEALTH);
        setDamMin(MIN_DAMAGE);
        setDamMax(MAX_DAMAGE);
        setDefMin(MIN_DEFENCE);
        setDefMax(MAX_DEFENCE);
        setGold(GOLD);
        setProb(0.00);
    }

    public void special()
    {
        if(Math.random() < 0.25)
        {
            setSpecial(" damage inflicted will double");
            setChance(0.25);
            setAbility(getDamage() + getDamage());
        }
        else if(Math.random() < 0.10)
        {   
            setSpecial(" Restored 10 hp");                        
            setHealth((int) Math.min(getMaxHealth(), getHealth() + 10));
        }
    }



}