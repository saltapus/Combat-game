package Controller;

import java.util.*;

import Model.Characters;
import Model.EnchanmentFireDmg;
import Model.EnchanmentPowerUp;
import Model.EnchanmentUpFive;
import Model.EnchanmentUpTwo;
import Model.GenericWeapon;
import Model.Item;
import Model.Weapon;
import View.UserInterface;

public class ShopController {

    private String x = "===============================================";
    private static Scanner input = new Scanner(System.in);    
    private static UserInterface ui = new UserInterface();

    //MAKE INTO A SHOP CONTROLLER
    /**************************************************************
     * PURPOSE: ALLOWS USER TO CHOOSE TO BUY , SELL, OR ENCHANT ITEMS
     * @param stock
     * @param player
     * @param inventory
     * @param count
     */
    public void showStock(Map<String, Item> stock, Characters player, Map<Integer, Item> inventory, int count) 
    {
        ui.printMessage(x);
        String requestItem, enhanceItem;
        int choice;
        boolean done = false;
        while (!done) 
        {
            choice = ui.showShopMenu();
            try 
            {
                switch (choice) 
                {
                    //SHOWS ITEMS THAT CAN BE PURCHASED
                    case 1:
                        ui.showMarket(stock);
                        break;
                    //SHOWS PLAYERS INVENTORY
                    case 2:
                        ui.showInventory(inventory);
                        break;
                    //SHOWS PLAYERS BALANCE AND CHECK SELECT ITEM TO BUY
                    //MUST ENTER EXACT STRING VALUE 
                    case 3:
                        ui.printMessage("Enter Item name");
                        ui.printMessage("Balance: " + player.getGold());
                        requestItem = input.nextLine();
                        requestItem = requestItem.replaceAll("\\s+", ""); // removes the spaces from string reducing error
                        ui.printMessage(x);
                        for (Map.Entry<String, Item> obj : stock.entrySet()) 
                        {
                            String itemName = obj.getKey();
                            Item item = obj.getValue();
                            itemName = itemName.replaceAll("\\s+", "");
                            //CHECKS IF ITEM EXISTS AND THEN CHECKS PLAYERS BALANCE IF THEY CAN AFFORD
                            //THEN CHECKS IF THEY CAN FIT ITEM IN INVENTORY
                            if (requestItem.equals(itemName) && (checkBalance(player, item.getCost()) && (inventory.size() <= 15)))
                            {
                                    ui.printMessage("you have purchase " + obj.getKey());
                                    player.setGold(player.getGold() - item.getCost());
                                    inventory.put(count++, item);
                                    ui.printMessage("current Balance " + player.getGold());


                            }
                            else if(inventory.size() > 15)
                            {
                                ui.printMessage("Not enough storage space");
                            }
                            else if (!checkBalance(player, item.getCost()))
                            {
                                ui.printMessage("insufficient funds");
                            }                 
                        }
                        break;
                    //SELLS ITEMS FROM INVENTORY
                    case 4:
                        try
                        {
                            ui.printMessage("Enter Item slot");
                            ui.printMessage("Balance: " + player.getGold());                        
                            requestItem = input.nextLine();
                            requestItem = requestItem.replaceAll("\\s+", "");
                            ui.printMessage(x);
                            for (Map.Entry<Integer, Item> obj : inventory.entrySet()) 
                            {
                                int key = obj.getKey();
                                Item item = obj.getValue();
                                if ((Integer.parseInt(requestItem) == key) && (checkBalance(player, item.getCost()) && (item.getEquiped() == false)))
                                {
                                    ui.printMessage("you have sold item number " + obj.getKey() + " " + item.getName());
                                    player.setGold(player.getGold() + (int)(item.getCost() * .5));
                                    ui.printMessage("current Balance " + player.getGold());                        
                                    inventory.entrySet().removeIf(entry -> entry.getKey() == key);
                                }
                                else if(item.getEquiped() == true)
                                {
                                    ui.printMessage("cannot sell equiped items");
                                } 
                                else if (obj.getValue() == null)
                                {
                                    ui.printMessage("item Does not exist");
                                }                       
                            }
                        }
                        catch (ConcurrentModificationException e)
                        {

                        }

                        break;
                    //ALLOWS USER TO ENCHANT AN WEAPON
                    case 5:
                        Weapon weapon = new GenericWeapon();
                        ui.printMessage("Enter Item slot");
                        ui.printMessage("Balance: " + player.getGold());  
                        requestItem = input.nextLine();
                        requestItem = requestItem.replaceAll("\\s+", "");   
                        ui.printMessage("Enter enhancement type [ Fire, PowerUp, +2 Dmg, +5 Dmg ]");
                        enhanceItem = input.nextLine();
                        enhanceItem = enhanceItem.replaceAll("\\s+", "");
                        ui.printMessage(x);
                        for (Map.Entry<Integer, Item> obj : inventory.entrySet()) 
                        {
                            int key = obj.getKey();
                            Item item = obj.getValue();   
                            char type = item.getType();
                            
                            //CHECKS IF ITEM IS A WEAPON
                            if ((type == 'W') && (Integer.parseInt(requestItem) == key))
                            {
                                //CREATES A GENERIC WEAPON FROM ITEM VALUES
                                weapon = new GenericWeapon(item.getType(), item.getName(), item.getMinValue(), item.getMaxValue(),
                                item.getCost(), item.getDescription(), item.getWeaponType());
                                weapon.setEquip(item.getEquiped());
                                //APPENDS NEW FUNCTIONALITY TO GENERIC WEAPON
                                if ((enhanceItem.equals("Fire")) && (player.getGold() >= 20))
                                {
                                    weapon = new EnchanmentFireDmg(weapon);
                                    inventory.put(Integer.parseInt(requestItem), weapon);
                                    player.setGold(player.getGold() - 20);
                                }
                                else if ((enhanceItem.equals("PowerUp")) && (player.getGold() >= 10))
                                {
                                    weapon = new EnchanmentPowerUp(weapon);
                                    inventory.put(Integer.parseInt(requestItem), weapon);
                                    player.setGold(player.getGold() - 10);
                                }       
                                else if((enhanceItem.equals("+5Dmg")) && (player.getGold() >= 10))
                                {
                                    weapon = new EnchanmentUpFive(weapon);
                                    inventory.put(Integer.parseInt(requestItem), weapon);
                                    player.setGold(player.getGold() - 10);
                                }
                                else if ((enhanceItem.equals("+2Dmg")) && (player.getGold() >= 5))
                                {
                                    weapon = new EnchanmentUpTwo(weapon);
                                    inventory.put(Integer.parseInt(requestItem), weapon);
                                    player.setGold(player.getGold() - 5);
                                }
                                else
                                {
                                    ui.printMessage("not enough Gold");
                                }
                            }
                        }

                        break;
                    case 6:
                        done = true;
                        break;

                    default:
                        ui.printMessage("Enter only numbers 1-4");
                        break;
                }
            } 
            catch (NumberFormatException e) 
            {
                ui.printMessage("enter number " + e.getMessage());
            }
        }
    }
    //CHECKS IF PLAYER HAS ENOUGH GOLD
    private boolean checkBalance(Characters player, int cost)
    {
        return player.getGold() > cost;
    }
}