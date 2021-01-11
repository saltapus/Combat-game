package Model;

public abstract class EnchantmentDecorator extends Weapon 
{
    protected WeaponInterface tempWeapon;
    
    public EnchantmentDecorator(WeaponInterface enchantment)
    {
        tempWeapon = enchantment;
    }

    public String getDescription()
    {
        return tempWeapon.getDescription();
    }

    public int getDamage()
    {
        return tempWeapon.getDamage();
    }

    public int getCost()
    {
        return tempWeapon.getCost();
    }

    public boolean getEquiped()
    {
        return tempWeapon.getEquiped();
    }

    
}