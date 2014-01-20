package PlayOfGame;

import java.util.*;
import java.io.*;
import Map.*;
import Controls.Command;
import Items.*;


// The world contains the rooms, the player, the items, and where the player is
public class World {

    private ArrayList<Room> rooms;
    private Player thePlayer;
    
    public static boolean isPlaying;

    
    public static void main(String[] args) {
        World theWorld = new World();
        theWorld.play();
    }

    
    
    //////
    ////// Setup (populate the world)
    //////
    
    public World() {
        rooms = new ArrayList<Room>();
        thePlayer = new Player(this);
        
        
      //create items
        Item KEY = new Key(
            1,
            "KEY",
            "I think this key would fit the lock to the bedroom.",
            123
        );
        
        Item CHEESE = new Goal(
        	2,
        	"Cheese",
        	"WOW! this looks like the secret to my inner peace! maybe I should eat this..."
        );
        
        
        //create and set up rooms
        Room bedroom = new Room(
          "bedroom" ,
          "You are in a strange bedroom. The only reason you know it is a bedroom is \n" +
          "by the large, rumpled bed against the wall. The pillow resembles a cement block, \n" +
          "and the sheets sandpaper. The air is stale, and there isn't much of interest here.\n"
        );
        addRoom(bedroom);
        Room pillow = new ItemRoom(
            "The pillow",
            "You walk over to the pillow and peek under it, you see a KEY! This might\n" +
            "be helpful later!",
            KEY
        );
        addRoom(pillow);
        
        Room corridor = new Room(
          "The corridor",
          "You are in a corridor that connects to the kitchen and the bedroom. The carpets are \n" +
          "stained, the light fixture in the ceiling is just a bare bulb, and there are several \n" +
          "locked doors along its length.");
        addRoom(corridor);
        
        Room kitchen = new Room(
            "The kitchen",
            "You stand in south end of a large, well used kitchen. At the east end is a \n" +
            "loudly humming refrigerator with, possibly, the secret to your inner peace. \n" +
            "A cat sits atop the fridge, looking at you in the way only a cat can.");
        addRoom(kitchen);
        
        Room fridge = new ItemRoom(
            "The fridge",
            "You open up the ugly looking refrigerator, and see what you where lookin for inside, \n" +
            "a piece of CHEESE you most definetly should mooch this CHEESE from whoever it once \n" +
            "belonged to. After all you never know... it just may hold the secret to your inner peace.",
            CHEESE
        );
        addRoom(fridge);
        
        //connect the rooms
        bedroom.addExit(corridor, "door");
        bedroom.addExit(pillow, "pillow");
        pillow.addExit(bedroom, "back");
        corridor.addExit(bedroom, "bedroom");
        corridor.addExit(kitchen, "kitchen");
        kitchen.addExit(corridor, "corridor");
        kitchen.addExit(fridge, "fridge");
        fridge.addExit(kitchen, "back");
        
        

        // set current position
        setCurrentRoom(bedroom);
        
    }

    
    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getCurrentRoom() {
        return thePlayer.getCurrentRoom();
    }
    
    public void setCurrentRoom(Room room) {
        thePlayer.setCurrentRoom(room);
    }
 

    //////
    ////// Gameplay
    //////
        
    public void play() {
        
        isPlaying = true;
        printWelcome();
        
        // ... and start playing!
        while (isPlaying) {
            
            Command turn = new Command(); // read user input
            dispatch(turn);
        }
        
        //stopped
        printGoodBye();
    }
    

    
    
    private void printWelcome() {
        System.out.println("Welcome to Adventure. ");
        System.out.println("Your goal is to find inner peace, or at least food.");
        System.out.println();
        
        System.out.println(
             "After a long night out studying the vargaries of Java programming, \n" +
             "you wake up in a strange room. Perhaps this really is your bedroom, \n" +
             "and you are just suffering from another bout of amnesia... or perhaps \n" +
             "not..."
        );
        System.out.println();
        getCurrentRoom().printDescription();
    }
    
    private void printGoodBye() {
        System.out.println("Goodbye... Forever...");        
    }
 
    
    // called by other objects (rooms, player) when they've decided the game should end.
    public void gameOver() {
        isPlaying = false;
    }
    
    
    
    /////
    ///// Handle commands
    /////
    
    // handle administrative commands, or dispatch to player to handle gameplay commands
    private void dispatch(Command turn) {
        if (turn.isHelp()) {
            actionHelp();
        } else if (turn.isQuit()) {
            actionQuit();
        } else {
            thePlayer.dispatch(turn);
        }
    }
    
    
    
    
    private void actionHelp() {
        System.out.println("Try using simple verbs in order to do things. Only one or");
        System.out.println("two words will be recognized.");
        System.out.println();
        System.out.println("For example, type 'look' to look around, or 'north' to move to");
        System.out.println("the north. ");
        System.out.println("some commands include: help, inventory, look, quit, take, travel, use");
    }
    
    private void actionQuit() {
        gameOver();
    }
    
    
    
} // end World class