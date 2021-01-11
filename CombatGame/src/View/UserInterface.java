package View;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import Model.Item;

public class UserInterface 
{
    private static Scanner input = new Scanner(System.in);    
    private String x = "===============================================";

    public void printMessage(String Message) 
    {
        System.out.println(Message);
    }

    //RETURNS USER INPUT AND SHOWS OPTIONS
    public int showMenu()
    {
        int choice = 0;
        boolean done = false;
        do
        {
            try
            {
                printMessage("(1) Go to Shop, (2) Choose Character Name, (3) Choose Weapon"
                + " (4) Choose Armour, (5) Start Battle (6) Exit Game");
                choice = input.nextInt();
                if ((choice >=1) && (choice <=6))
                {
                    done = true;
                }                
            }
            catch (InputMismatchException e)
            {
                printMessage(e.getMessage() + "value should be inbetween 1-6");
            }

        } while (!done);
        return choice;
    }
    
    //RETURNS USER INPUT AND SHOWS OPTIONS
    public int showShopMenu()
    {
        int choice = 0;
        boolean done = false;
        do
        {
            try
            {
                printMessage("(1) show Store Inventory (2) show Inventory (3) Buy Item (4) Sell Item (5) EnchantWeapon (6) Exit");
                choice = input.nextInt();
                if ((choice >=1) && (choice <=6))
                {
                    done = true;
                }
            }
            catch (InputMismatchException e)
            {
                printMessage(e.getMessage() + "value should be inbetween 1-6");
            }

        } while (!done);
        return choice;
    }

    //PRINTS OUT THE PLAYERS INVENTORY
    public void showInventory(Map<Integer, Item> inventory)
    {
        for (Map.Entry<Integer, Item> obj : inventory.entrySet()) 
        {
            Item item = obj.getValue();
            printMessage("inventorySlot " + obj.getKey());
            printMessage(item.toString());
            printMessage(x);
        }
    }

    //PRINTS PLAYER INVENTORY WITH RESTRICTION OF TYPE
    public void showInventoryType(Map<Integer, Item> inventory, char type)
    {
        for (Map.Entry<Integer, Item> obj : inventory.entrySet()) 
        {
            Item item = obj.getValue();
            if (item.getType() == type)
            {
                printMessage("inventorySlot " + obj.getKey());
                printMessage(item.toString());
                printMessage(x);
            }
        }
    }

    //PRINTS LIST OF ITEMS AVALIBLE ON MARKET
    public void showMarket(Map<String, Item> stock)
    {
        for (Map.Entry<String, Item> obj : stock.entrySet()) 
        {
            Item item = obj.getValue();
            printMessage(item.toString());
            printMessage(x);
        } 
    }
}
