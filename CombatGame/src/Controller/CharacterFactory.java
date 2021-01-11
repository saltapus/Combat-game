package Controller;

import Model.*;

public class CharacterFactory 
{
    private Characters character;
    private Slime slime;
    private Goblin goblin;
    private Ogre ogre;
    private Dragon dragon;

    public CharacterFactory()
    {
        slime = new Slime();
        goblin = new Goblin();
        ogre = new Ogre();
        dragon = new Dragon();
    }

    public Characters makeCharacter(char type)
    {
        //CREATES TYPE OF CHARACTER EITHER PLAYER OR ENEMY
        if (type == 'P')
        {
            character = createPlayer();
        }
        else if(type == 'N')
        {
            character = createEnemy();
        }
        return character;
    }

    //CREATS PLAYER
    private Characters createPlayer()
    {
        character = new Player();
        return character;
    }

    /************************************************
     * PURPOSE: CREATES ENEMY AND CHECKS IF CHARACTER IS NULL
     *          GRABS THE ENEMYS PROBABLITY OF BEING SPOTTED
     * @return
     *************************************************/
    private Characters createEnemy()
    {   
        do
        {
            if(Math.random() < slime.getProbablity())
            {
                decreaseProb();
                increaseProb();
                character = new Slime();
            } 
            else if (Math.random() < goblin.getProbablity())
            {
                decreaseProb();
                increaseProb();
                character = new Goblin();
            } 
            else if (Math.random() < ogre.getProbablity())
            {
                decreaseProb();
                increaseProb();
                character = new Ogre();
            }
            else if(Math.random() < dragon.getProbablity())
            {
                decreaseProb();
                increaseProb();
                character = new Dragon();            
            }    

        }while(character == null);
        return character;
    }
    
    //INCREASES CHANCES OF ENCOUNTERING A DRAGON
    private void increaseProb()
    {
        dragon.setProb(dragon.getProbablity() + 0.15);
    }
    
    //DECREASES THE CHANCES OF ENCOUNTERING TYPE OF ENEMY
    private void decreaseProb()
    {
        slime.setProb(slime.getProbablity() - 0.05);
        goblin.setProb(goblin.getProbablity() - 0.05);
        ogre.setProb(ogre.getProbablity() - 0.05);
        
    }

}