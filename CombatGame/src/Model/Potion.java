package Model;

public class Potion implements Item
{

    private String name, description;
    private char type;
    private int minEff, maxEff, cost;
    private boolean equip;

    public Potion(char inType, String inName, int inMinEff, int inMaxEff, int inCost, String inDesc)
    {
        setType(inType);
        setName(inName);
        setMaxDef(inMaxEff);
        setMinDef(inMinEff);
        setCost(inCost);
        setDesc(inDesc);
        setEquip(false);
    }

    public void setType(char inType)
    {
        type = inType;
    }

    public void setName(String inName)
    {
        name = inName;
    }

    public void setMinDef(int inMinEff)
    {
        minEff = inMinEff;
    }

    public void setMaxDef(int inMaxEff)
    {
        maxEff = inMaxEff;
    }

    public void setDesc(String inDesc)
    {
        description = inDesc;
    }

    public void setCost(int inCost)
    {
        cost = inCost;
    }

    public void setEquip(boolean isEquiped)
    {
        equip = isEquiped;
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
        return minEff;
    }

    @Override
    public int getMaxValue() 
    {
        return maxEff;
    }

    @Override
    public int getCost() 
    {
        return cost;
    }

    public String getDescription()
    {
        return description;
    }

    @Override
    public String getWeaponType() 
    {
        return null;
    }

    public String getEffect()
    {
        String eff = "";
        if(getDescription().charAt(0) == 'H')
        {
            eff = "Potion of Healing";
        }
        else if(getDescription().charAt(0) == 'D')
        {
            eff = "Potion of Damage";
        }
        return eff;
    }

    public String toString()
    {
        return "Potion: " + getName() + " Equiped: " + getEquiped() + " \n[ Effect:" + getMinValue() + " - " + getMaxValue() + ", GOLD: "
                + getCost()
                + ", Description: " + getEffect() + " ]";
    }

    @Override
    public boolean getEquiped()
    {
        return equip;
    }
}