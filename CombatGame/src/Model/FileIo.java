package Model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import Controller.ItemFactory;

public class FileIo 
{
    public FileIo()
    {

    }
    
    public void read(String stock, Map<String, Item> shop) throws IOException
    {        
        System.out.println("reading" + stock);
        fileInput(stock, shop);
	}

    private void fileInput(String inFileName, Map<String, Item> shop) throws IOException
    {
        FileInputStream fileStrm = null;                                        
        InputStreamReader rdr;                                                  
        BufferedReader bufRdr;                                                  
        String line;
        try                                                                     
        {                                                                       
            fileStrm = new FileInputStream(inFileName);                         
            rdr = new InputStreamReader(fileStrm);                              
            bufRdr = new BufferedReader(rdr);
            
            //Input line from the file                                      
            line = bufRdr.readLine(); 
  
            while(line != null)
            {      
                 try                                                             
                {//process first character to be used in case statment
                    switch(line.charAt(0))
                    {
                        case 'W': case 'w':
                            processItem(line, shop);
                            break; 
                        case 'P': case 'p': case 'A': case 'a':
                            processItem2(line, shop);
                            break;                                              
                    }
                }
                catch  (StringIndexOutOfBoundsException e)                      
                {
                    System.out.println( " Error: String index is out of bounds,"
                                        + e.getMessage());                      
                }                                                               
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("Error: Array size is full, " 
                                        + e.getMessage());
                }
                catch (IllegalArgumentException e)
                {
                    System.out.println(e.getMessage());
                } 


                line = bufRdr.readLine();
            }//END FOR                                                          
            fileStrm.close();  
            System.out.println("File Has been Read");                                                 
        }//END TRY                                                              
        catch (IOException e)                                                   
        {                                                                       
            if (fileStrm != null)                                               
            {                                                                   
                try                                                             
                {                                                               
                    fileStrm.close();                                           
                }//END TRY                                                      
                catch(IOException ex2)                                          
                {                                                               
                }//END CATCH                                                    
            }//END IF                                                           
            System.out.println("Error in file processing: " + e.getMessage());
        }                                    
    }
    // process item from file line and Constucts an object to be returned to 
    // be added later into storage
    public void processItem(String line, Map<String, Item> shop)
    {
        char type;
        String name, description, weaponType;
        int minValue, maxValue, cost;

        String [] lineArray = line.split(",");

        type = lineArray[0].charAt(0);
        name = lineArray[1];
        minValue = Integer.parseInt(lineArray[2]);
        maxValue = Integer.parseInt(lineArray[3]);
        cost = Integer.parseInt(lineArray[4]);
        description = lineArray[5];
        weaponType = lineArray[6];

        ItemFactory stock = new ItemFactory();
        Item items = stock.makeItem(type, name, minValue, maxValue, cost, description, weaponType);
        shop.put(name, items);
    }

    public void processItem2(String line, Map<String, Item> shop)
    {
        char type;
        String name, description, weaponType;
        int minValue, maxValue, cost;
        String [] lineArray = line.split(",");
        type = lineArray[0].charAt(0);
        name = lineArray[1];
        minValue = Integer.parseInt(lineArray[2]);
        maxValue = Integer.parseInt(lineArray[3]);
        cost = Integer.parseInt(lineArray[4]);
        description = lineArray[5];
        weaponType = "";

        ItemFactory stock = new ItemFactory();
        Item items = stock.makeItem(type, name, minValue, maxValue, cost, description, weaponType);
        shop.put(name, items);
    }

    
}