package Model;

public class EnchanmentUpTwo extends EnchantmentDecorator
{
    private boolean equip = tempWeapon.getEquiped();
    public EnchanmentUpTwo(WeaponInterface enchantment) 
    {
        super(enchantment);
        System.out.println("Enchanting Weapon Damage + 2");
    }
    @Override
    public String getName()
    {
        return tempWeapon.getName() + "[+2 Dmg]";
    }

    @Override
    public String getDescription()
    {
        return tempWeapon.getDescription() + " [Added + 2]";
    }

    @Override
    public String getWeaponType() 
    {
        return tempWeapon.getWeaponType();
    }

    @Override
    public int getCost() 
    {
        return tempWeapon.getCost() + 5;
    }

    @Override
    public int getDamage() {
        return tempWeapon.getDamage() + 2;
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