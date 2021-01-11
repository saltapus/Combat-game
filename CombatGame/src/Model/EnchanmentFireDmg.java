package Model;

import java.util.Random;

public class EnchanmentFireDmg extends EnchantmentDecorator 
{

    private Random rand = new Random();
    private boolean equip = tempWeapon.getEquiped();
    
    public EnchanmentFireDmg(WeaponInterface enchantment) 
    {
        super(enchantment);
        System.out.println("Enchanting Weapon with fire");
    }
    @Override
    public String getName()
    {
        return tempWeapon.getName() + "[Fire]";
    }

    @Override
    public String getDescription()
    {
        return tempWeapon.getDescription() + " [Added fire randomly adds 5-10 dmg]";
    }
    
    @Override
    public String getWeaponType() 
    {
        return tempWeapon.getWeaponType();
    }

    @Override
    public int getCost() 
    {
        return tempWeapon.getCost() + 20;
    }

    @Override
    public int getDamage() 
    {
        return tempWeapon.getDamage() + rand.nextInt(10 - 5) + 5;
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