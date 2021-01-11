package Model;

import java.util.Random;

public abstract class Weapon implements Item, WeaponInterface
{
    private String name, description, weaponType;
    private char type;
    private int minDam, maxDam, cost;
    private Random rand = new Random();



    public void setType(char inType)
    {
        type = inType;
    }

    public void setName(String inName)
    {
        name = inName;
    }

    public void setMinDam(int inMinDam)
    {
        minDam = inMinDam;
    }

    public void setMaxDam(int inMaxDam)
    {
        maxDam = inMaxDam;
    }

    public void setDesc(String inDesc)
    {
        description = inDesc;
    }

    public void setWeaponType(String inWeaponType)
    {
        weaponType = inWeaponType;
    }

    public void setCost(int inCost)
    {
        cost = inCost;
    }

    @Override
    public String getName() 
    {
        return name;
    }

    @Override
    public char getType() 
    {
        return type;
    }

    @Override
    public int getMinValue() 
    {
        return minDam;
    }

    @Override
    public int getMaxValue() 
    {
        return maxDam;
    }

    @Override
    public int getCost() 
    {
        return cost;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public String getWeaponType() 
    {
        return weaponType;
    }

    @Override
    public int getDamage()
    {
        return rand.nextInt(maxDam - minDam) + minDam; 
    }

    public String toString()
    {
        return "Weapon: " + getName() + " Equiped: " + getEquiped() + " \n[ Damage:" + getMinValue() + " - " + getMaxValue() + ", GOLD: "
                + getCost()
                + ", DamageType: " + getDescription() + ", WeaponType: " + getWeaponType() + " ]";
    }

}