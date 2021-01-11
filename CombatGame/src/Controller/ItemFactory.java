package Controller;

import Model.Armor;
import Model.GenericWeapon;
import Model.Item;
import Model.Potion;

public class ItemFactory {

    private Item item;

    public ItemFactory() 
    {
    }
    /*********************************************************
     * PURPOSE: CREATES ITEMS FROM IMPORTED PARAMETERS
     * @param type
     * @param name
     * @param minValue
     * @param maxValue
     * @param cost
     * @param description
     * @param weaponType
     * @return
     */
    public Item makeItem(char type, String name, int minValue, int maxValue, int cost, String description,
            String weaponType) 
    {
        item = null;
        try {
            switch (type) 
            {
                case 'W': case 'w':
                    item = new GenericWeapon(type, name, minValue, maxValue, cost, description, weaponType);
                    break;
                    
                case 'P': case 'p':
                    item = new Potion(type, name, minValue, maxValue, cost, description);
                    break;
                    
                case 'A': case 'a':
                    item = new Armor(type, name, minValue, maxValue, cost, description);
                    break;
            }
        }
        catch(IllegalArgumentException e)
        {
        }
        return item;
    }
}