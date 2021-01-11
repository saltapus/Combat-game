package Controller;

import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import Model.Characters;
import Model.Dragon;
import Model.Item;
import View.UserInterface;

/**************************************************************
 * PURPOSE: ALLOWS THE USER TO DECIDE TO MANAGE EQUIPMENT
 *          FIGHT OR SHOP
 *          GAME ENDS ONCE PLAYER KILLS DRAGON
 **************************************************************/

public class CharacterController {

    private String x = "===============================================";
    private static Scanner input = new Scanner(System.in);
    private static CharacterFactory enemyFactory = new CharacterFactory();
    private static UserInterface ui = new UserInterface();
    private static ShopController shop = new ShopController();
    private Random rand = new Random();

/***************************************************************
 * @param stock
 * @param inventory
 * @param player
 * @param count
 * PURPOSE: MAIN MENU TO SELECT SHOP, EQUIPMENT OPTIONS OR BATTLE
 ***************************************************************/
    public void showMainMenu(Map<String, Item> stock, Map<Integer, Item> inventory, Characters player, int count) {
        boolean done = false;
        int choice;
        while (!done) 
        {
            try 
            {
                choice = ui.showMenu();
                switch (choice) 
                {
                    // SENDS USER TO THE SHOP CONTROLLER
                    case 1:
                        ui.printMessage("Opening Shop Menu");
                        shop.showStock(stock, player, inventory, count);
                        break;
                    //SETS PLAYER NAME
                    case 2:
                        ui.printMessage("Enter player name");
                        String name = input.nextLine();
                        player.setName(name);
                        ui.printMessage(player.toString());
                        break;
                    //USER ENTERS INVENTORY SLOT AND EQUIPS ITEM
                    case 3:
                        ui.printMessage("Select Weapon");
                        ui.showInventoryType(inventory, 'W');
                        ui.printMessage("Enter Item slot to equip");
                        int requestItem = input.nextInt();
                        ui.printMessage(x);
                        for (Map.Entry<Integer, Item> obj : inventory.entrySet()) 
                        {
                            int key = obj.getKey();
                            Item item = obj.getValue();
                            ui.printMessage(x);
                            ui.printMessage("inventorySlot " + obj.getKey());
                            //CHECKS THE INVENTORY FOR KEY IF IT EXISTS IF IT DOES CHECKS IF EQUIPMENT IS 
                            //ALREADY EQUIPED
                            if ((requestItem == key) && (item.getEquiped() == false)) 
                            {
                                //SETS THE EQUIPMENT TO TRUE AND SETS THE ITEMS MIN AND MAX VALUE
                                item.setEquip(true);
                                player.setDamMax(item.getMaxValue());
                                player.setDamMin(item.getMinValue());
                            } 
                            //IF ITEM IS ALREADY EQUIPED DO NOTHING
                            else if ((requestItem == key) && (item.getEquiped() == true)) 
                            {
                                ui.printMessage("Item already Equiped");
                            } 
                            //IF NEW ITEM IS EQUIPED SET ALL ITEMS OF WEAPONS TO FALSE
                            else if ((requestItem != key) && (item.getEquiped() == true) && (item.getType() == 'W')) 
                            {
                                item.setEquip(false);
                            }
                            //SHOWS UPDATE OF PLAYERS EQUIPMENT AND STATS
                            ui.printMessage(item.toString());
                            ui.printMessage(player.toString());
                        }
                        break;
                    //USER ENTERS INVENTORY SLOT AND EQUIPS ITEM DOES THE SAME AS ABOVE
                    case 4:
                        ui.printMessage("Select Armour");
                        ui.showInventoryType(inventory, 'A');
                        ui.printMessage("Enter Item slot to equip");
                        requestItem = input.nextInt();
                        ui.printMessage(x);
                        for (Map.Entry<Integer, Item> obj : inventory.entrySet()) 
                        {
                            int key = obj.getKey();
                            Item item = obj.getValue();
                            ui.printMessage(x);
                            ui.printMessage("inventorySlot " + obj.getKey());
                            if ((requestItem == key) && (item.getEquiped() == false)) 
                            {
                                item.setEquip(true);
                                player.setDamMax(item.getMaxValue());
                                player.setDamMin(item.getMinValue());
                            }
                            else if ((requestItem == key) && (item.getEquiped() == true)) 
                            {
                                ui.printMessage("Item already Equiped");
                            }
                            // selects all equipment of type armour and unequips them
                            else if ((requestItem != key) && (item.getEquiped() == true) && (item.getType() == 'A')) 
                            {
                                item.setEquip(false);
                            }
                            ui.printMessage(item.toString());
                            ui.printMessage(player.toString());
                        }

                        break;
                    //SENDS USER TO GO INTO BATTLE
                    case 5:
                        ui.printMessage("Battle Phase");
                        showBattlePhase(player, inventory);
                        break;
                    //EXITS GAME
                    case 6:
                        done = true;
                        break;
                }

            } catch (NumberFormatException e) {
                // The user entered something non-numerical.
                System.out.println("Enter a number between");
            }
        }

    }
    /*****************************************************************
     * PURPOSE: TURN BASE COMBAT WITH PLAYER AND ENEMY. GAME ENDS IF 
     * DRAGON OR PLAYER DIES
     * FUNCTIONALITY: USER CAN CHOOSE TO USE POTION, RUN AWAY OR ATTACK
     * @param player
     * @param inventory
     ******************************************************************/
    public void showBattlePhase(Characters player, Map<Integer, Item> inventory)
    {
        boolean done = false;
        //CREATES NEW MONSTER                         
        Characters enemy = enemyFactory.makeCharacter('N');                        
        ui.printMessage(player.toString());
        ui.printMessage("found " + enemy.toString());                        
        if (enemy.getName().equals("Dragon"))
        {
             ui.printMessage("Final Boss Emerged DRAGON APPROACHING!!!");               
        }
        while (!done)
        {
            ui.printMessage("(1) Attack (2) Use Potion (3) Run Away");
            try 
            {
                switch (input.nextInt()) 
                {
                    //ATTACK PHASE
                    case 1: //need to add check weapon type and damage type do something with word equiped?

                        //GRABS PLAYER DAMAGE AND DEFENCE VALUES
                        int playerDamage = player.getDamage();
                        int playerDef = player.getDefence();  

                        //GRABS EQUIPED ITEMS
                        Item weapon = grabEquip('W', inventory);
                        Item armour = grabEquip('A', inventory);

                        //PLAYER ATTACKS ENEMY
                        enemy.setDamageRec(playerDamage);
                        ui.printMessage(player.getName() + " delt "  + playerDamage + " doing " + weapon.getDescription() + " damage with " +  weapon.getWeaponType()) ;

                        //GRABS ENEMY DAMAGE AND DEFENCE VALUE
                        int enemyDamage = enemy.doAbility();
                        int enemyDef = enemy.getDefence();

                        ui.printMessage(enemy.getName() + " defended with " + enemyDef);
                        //PLAYER FIGHTS DRAGON
                        if (enemy.getName().equals("Dragon"))
                        {
                            Dragon dragon = (Dragon) enemy;
                            dragon.special();
                            enemyDamage = dragon.doAbility();
                            player.setDamageRec(enemyDamage);
                            ui.printMessage("You have taken " + enemyDamage + " Dmg! from " + enemy.getName() + " and defended with " + playerDef 
                                    + " with armour made of " + armour.getDescription());
                        }
                        //PLAYER FIGHTS OTHER MONSTERS
                        else
                        {
                            player.setDamageRec(enemyDamage);
                            ui.printMessage("You have taken " + enemyDamage + " Dmg! from " + enemy.getName() + " and defended with " + playerDef 
                                    + " with armour made of " + armour.getDescription());
                        }

                        //ENDS GAME IF PLAYER OR DRAGON DIES
                        if(player.checkDeath(player.getHealth()))
                        {
                            ui.printMessage("You Died");
                            System.exit(1);
                        }
                        else if(enemy.checkDeath(enemy.getHealth()))
                        {
                            ui.printMessage("You Killed " + enemy.getName());
                            ui.printMessage("player health Restored " + (int) Math.min(player.getMaxHealth(), player.getHealth() * 1.5)+ "/" + player.getMaxHealth());
                            player.setHealth((int) Math.min(player.getMaxHealth(), player.getHealth() * 1.5));
                            player.setGold(player.getGold() + enemy.getGold());
                            if(enemy.getName().equals("Dragon"))
                            {
                                ui.printMessage("YOU HAVE WON!!");
                                System.exit(1);
                            }
                            done = true;
                        }
                        break;
                    case 2:
                        ui.printMessage("Select Potion");
                        ui.showInventoryType(inventory, 'P');
                        ui.printMessage("Enter Item slot to equip");
                        int requestItem = input.nextInt();
                        ui.printMessage(x);
                        for (Map.Entry<Integer, Item> obj : inventory.entrySet()) 
                        {
                            int key = obj.getKey();
                            Item item = obj.getValue();         
                            char type = item.getDescription().charAt(0);

                            if ((requestItem == key) && (type == 'H'))
                            {                            
                                ui.printMessage(x);
                                ui.printMessage("inventorySlot " + obj.getKey());
                                int heal = rand.nextInt(item.getMaxValue() - item.getMinValue()) + item.getMinValue();
                                ui.printMessage("restored " + heal + "hp");
                                player.setHealth((int) Math.min(player.getMaxHealth(), player.getHealth() + heal ));
                                inventory.entrySet().removeIf(entry -> entry.getKey() == key);
                            }
                            if ((requestItem == key) && (type == 'D'))
                            {
                                ui.printMessage(x);
                                ui.printMessage("inventorySlot " + obj.getKey());
                                ui.printMessage(item.toString());
                                int dmg = rand.nextInt(Math.max(1, item.getMaxValue() - item.getMinValue())) + item.getMinValue();
                                ui.printMessage(item.getName() + " does " + dmg + "Dmg");                                    
                                enemy.setHealth(enemy.getHealth() - dmg);
                                inventory.entrySet().removeIf(entry -> entry.getKey() == key);
                            }
                        }
                        break;
                    case 3:
                        done = true;
                        break;

                    default:
                        ui.printMessage("Enter only numbers 1-4");
                        break;

                }
                ui.printMessage(player.toString());
                ui.printMessage(enemy.toString());
            } 
            catch (NumberFormatException e) 
            {
                ui.printMessage("enter number " + e.getMessage());
            }
            catch (IllegalArgumentException e)
            {
                ui.printMessage(e.getMessage()   + " illegal Argument");
            }
            catch (ConcurrentModificationException e)
            {

            }
        }
    }

    //GRABS EQUIPED ITEMS
    private Item grabEquip(char type, Map<Integer, Item> inventory)
    {
        Item equipment = null;
        for (Map.Entry<Integer, Item> obj : inventory.entrySet()) 
        {
            Item item = obj.getValue();
            if ((type == item.getType()) && (item.getEquiped() == true)) 
            {
                equipment = item;
            }
        }

        return equipment;
    }
}