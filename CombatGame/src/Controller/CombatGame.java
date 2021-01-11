package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import Model.Characters;
import Model.FileIo;
import Model.Item;
import View.UserInterface;

public class CombatGame {
    private static UserInterface ui = new UserInterface();
    private static CharacterFactory enemyFactory = new CharacterFactory();
    private static FileIo fileIo = new FileIo();
    private static int count = 1;
    private static CharacterController main = new CharacterController();

    public static void main(String[] args) {
        Characters enemy = null;
        Characters player = null;
        Map<String, Item> stock = new HashMap<>();
        Map<Integer, Item> inventory = new HashMap<>();

        try {
            String file = "Itemlist.txt";
            fileIo.read(file, stock);
            enemy = setup(enemy, 'N');
            player = setup(player, 'P');
            setupGear(inventory, stock, 'W');
            setupGear(inventory, stock, 'A');

            for (Entry<Integer, Item> obj : inventory.entrySet()) 
            {
                Item item = obj.getValue();
                if(item.getType() == 'W')
                {
                    player.setDamMax(item.getMaxValue());
                    player.setDamMin(item.getMinValue());
                }
                else if(item.getType() == 'A')
                {
                    player.setDefMax(item.getMaxValue());
                    player.setDefMin(item.getMinValue());
                }

                ui.printMessage(item.getName() + " Equiped");                           
            }

            main.showMainMenu(stock, inventory, player, count);

        } 
        catch (IOException e) 
        {
            ui.printMessage(e.getMessage() + "File Not Found");
        }
    }

    /*  ******************************************************************************************
     *  Creates Characters checking what type enemy or player and generate a character from
     *  character factory
     * *******************************************************************************************/
    private static Characters setup(Characters gameChar, char type) {
        if (type == 'p') 
        {
            ui.printMessage("Setting up Player");
        } 
        else if (type == 'N') 
        {
            ui.printMessage("Setting up Enemy");
        }
        try 
        {
            //Send type of charater (enemy or Player) and returns generated gamecharacter
            gameChar = enemyFactory.makeCharacter(type);
            //tells user it found monster
            if ((type == 'N') && (gameChar != null))
            {
                ui.printMessage("monster: " + gameChar.getName() + " was found");
            }
        } 
        catch (IllegalArgumentException e) 
        {
            ui.printMessage(e.getMessage());
        }

        return gameChar;
    }
    /*  ******************************************************************************************
     *  imports hashmap of inventory, stock and char type
     *  Method Checks for cheapest item of type (armour 'A' or Weapon 'W')
     *  ******************************************************************************************/

    private static void setupGear(Map<Integer, Item> inventory, Map<String, Item> stock, char type) {
        int max, min = 0;
        for (Map.Entry<String, Item> obj : stock.entrySet()) {
            Item item = obj.getValue();
            max = item.getCost();
            if ((min == 0 || min > item.getCost()) && (item.getType() == type)) 
            {
                min = max;
                inventory.put(count++, obj.getValue());
                item.setEquip(true);
                break;
            }
        }
    }
}