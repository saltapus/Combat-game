package Model;

public class EnchanmentUpFive extends EnchantmentDecorator 
{
    private boolean equip = tempWeapon.getEquiped();
    public EnchanmentUpFive(WeaponInterface enchantment) 
    {
        super(enchantment);
        System.out.println("Enchanting Weapon Damage + 5");
    }

    @Override
    public String getName()
    {
        return tempWeapon.getName() + "[+5 Dmg]";
    }

    @Override
    public String getDescription()
    {
        return tempWeapon.getDescription() + " [Added + 5]";
    }
 
    @Override
    public String getWeaponType() 
    {
        return tempWeapon.getWeaponType();
    }

    @Override
    public int getCost() 
    {
        return tempWeapon.getCost() + 10;
    }

    @Override
    public int getDamage() 
    {
        return tempWeapon.getDamage() + 5;
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

    @Override 
    public int getMaxValue()
    {
        return tempWeapon.getMaxValue();
    }
    
    @Override 
    public int getMinValue()
    {
        return tempWeapon.getMinValue();
    }
    @Override
    public char getType()    
    {
        return tempWeapon.getType();
    }
}