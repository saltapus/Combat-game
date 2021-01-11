package Model;

public class GenericWeapon extends Weapon
{
    private boolean equip;
    public GenericWeapon()
    {
        
    }
        
    public GenericWeapon(char inType, String inName, int inMinDam, int inMaxDam, int inCost, String inDesc, String inWeaponType) 
    {
        setType(inType);
        setName(inName);
        setMaxDam(inMaxDam);
        setMinDam(inMinDam);
        setCost(inCost);
        setDesc(inDesc);
        setWeaponType(inWeaponType);
        setEquip(false);
	}
    
    @Override
    public boolean getEquiped() 
    {
        return equip;
    }

    @Override
    public void setEquip(boolean isEquiped) 
    {
        equip = isEquiped;
    }

}