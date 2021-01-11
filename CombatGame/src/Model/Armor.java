package Model;

public class Armor implements Item
{

    private String name, description;
    private char type;
    private int minDef, maxDef, cost;
    private boolean equip;

    public Armor(char inType, String inName, int inMinDef, int inMaxDef, int inCost, String inDesc)
    {
        setType(inType);
        setName(inName);
        setMaxDef(inMaxDef);
        setMinDef(inMinDef);
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

    public void setMinDef(int inMinDef)
    {
        minDef = inMinDef;
    }

    public void setMaxDef(int inMaxDef)
    {
        maxDef = inMaxDef;
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
        return minDef;
    }

    @Override
    public int getMaxValue() 
    {
        return maxDef;
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

    public String toString()
    {
        return "Armour: " + getName() + " Equiped: "+ getEquiped() + " \n[ Defence:" + getMinValue() + " - " + getMaxValue() + ", GOLD: "
                + getCost()
                + ", Material: " + getDescription() + " ]";
    }

    @Override
    public boolean getEquiped() 
    {
        return equip;
    }
}