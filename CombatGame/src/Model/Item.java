package Model;

public interface Item 
{
    public String getName();

    public char getType();

    public int getMinValue();
    
    public int getMaxValue();
    
    public int getCost();

    public String getDescription();

    public String getWeaponType();

    public String toString();

    public boolean getEquiped();

    public void setEquip(boolean isEquiped);

}