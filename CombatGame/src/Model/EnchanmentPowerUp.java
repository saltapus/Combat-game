package Model;

public class EnchanmentPowerUp extends EnchantmentDecorator 
{

    private boolean equip = tempWeapon.getEquiped();
    public EnchanmentPowerUp(WeaponInterface enchantment) 
    {
        super(enchantment);
        System.out.println("Enchanting Weapon: Power Up");
    }

    @Override
    public String getName()
    {
        return tempWeapon.getName() + "[PowerUp]";
    }

    @Override
    public String getDescription()
    {
        return tempWeapon.getDescription() + " [Multipled dmg by *1.1]";
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
        return (int) (tempWeapon.getDamage() * 1.1);
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