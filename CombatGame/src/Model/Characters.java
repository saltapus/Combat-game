package Model;

import java.util.Random;

public abstract class Characters
{
    private String name, special;
    private int maxHealth, health, damage, gold, minDam, maxDam, minDef, maxDef, ability;
    private double probability, chance;
    private Random rand = new Random();

    public String getName() 
    {
        return name;
    }

    public int getHealth() 
    {
        return health;
    }
    
    public int getMaxHealth() 
    {
        return maxHealth;
    }

    public int getDamage() 
    {
        return rand.nextInt(maxDam - minDam) + minDam;
    }

    public int getDefence() 
    {
        return rand.nextInt(maxDef - minDef) + minDef;
    }

    public int getGold() 
    {
        return gold;
    }

    public double getProbablity() 
    {
        return probability;
    }

    public void setDamMax(int inDamage) 
    {
        maxDam = inDamage;
    }

    public void setDamMin(int inDamage) 
    {
        minDam = inDamage;
    }

    public void setDefMax(int inDefence) 
    {
        maxDef = inDefence;
    }

    public void setDefMin(int inDefence) 
    {
        minDef = inDefence;
    }

    public void setName(String inName) 
    {
        name = inName;
    }

    public void setHealth(int inHealth) 
    {
        health = inHealth;
    }
    
    public void setMaxHealth(int inHealth) 
    {
        maxHealth = inHealth;
    }

    public void setGold(int inGold) 
    {
        gold = inGold;
    }

    public void setProb(double inProbability) 
    {
        probability = inProbability;
    }
    
    public void setDamageRec(int inDamage)
    {
        setHealth(getHealth() - Math.max(0, inDamage - getDefence()));
    }

    public void setChance(double inChance)
    {
        chance = inChance;
    }

    public double getChance()
    {
        return chance;
    }

    public String toString()
    {
        return name + " [ " + doAbility() + " dam : " + getDefence() + " def : " + health + "/" + getMaxHealth()+ " hp : " + getProbablity() + " prob ]";
    }

    public String abilityString()
    {
        return "ability activated " + special;
    }

    public void setSpecial(String inSpecial)
    {
        special = inSpecial;
    }

    public void setAbility(int inAbility)
    {
        ability = inAbility;
    }

    public int doAbility()
    {
        if (Math.random() < getChance())
        {
            System.out.println(abilityString());
            damage = ability;
        }
        else
            damage = getDamage();
        return damage;
    }  

    public boolean checkDeath(int curHp)
    {
        boolean death = false;
        if(curHp <= 0)
        {
            death = true;
        }
        return death;
    }

}