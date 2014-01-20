package PlayOfGame;

import java.util.ArrayList;

import Map.*;
import Controls.Command;
import Items.Item;


public class Player {

    private World myWorld;
    private Room currentRoom;
    private String myName = "";
    private Item[] inventory;
    
    public Player(World world) {
        myWorld = world;
    }
    
    public Player(String name, World world) {
        myName = name;
        myWorld = world;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }
    
    public Room getCurrentRoom() {
        return( currentRoom );
    }
    
    //////
    ////// Handle Commands
    //////
    
    public void dispatch(Command turn) {
        if (turn.isLookRoom()) {
            actionLookRoom();
            
        } else if (turn.isTravel(currentRoom)) {
            actionTravel(turn);

        } else if (turn.isInventory()){
                actionInventory();
        } else if (turn.isTake()){
                actionTake(turn);
        } else if (turn.isUse()){
        	actionUse(turn);
        } else {
            System.out.println("Huh?");
        }
    }


    
    public void actionTravel(Command turn) {
        String newDir = turn.getSecondWord();
        Room newRoom = currentRoom.tryToExit(newDir);
        if (newRoom == null) {
            System.out.println("You can't go that direction from here.");
        } else {
            if (newRoom.enterRoom()) {
                currentRoom = newRoom;
            } else {
                System.out.println("You can't go there.");
            }
        }
    }


    public void actionLookRoom() {
        currentRoom.printDescription();
    }
    
    public void actionInventory() {
            int i = 0;
        System.out.print("You open your bag and find a ");
        for (Item item : inventory) {
            System.out.print(item.getName());
            i++;
            if (i != inventory.length) {
                System.out.print(", ");
            } else {
                System.out.print(".");
            }
            if (i == (inventory.length - 1)) {
                       System.out.print("and ");
            }
        }
    }
    
    public void actionTake(Command turn){
        //String itemName = turn.getSecondWord();
        ItemRoom newRoom = (ItemRoom) currentRoom;
            if (newRoom.isHere()) {
            inventory[inventory.length+1] = ((ItemRoom) currentRoom).getItem();
        } else {
                System.out.println("You can't go that direction from here.");
        }
    }
    
    public void actionUse(Command turn){
    	String itemName = turn.getSecondWord();
    	loop:
    	for (Item item : inventory) {
    		if (item.getName() == itemName){
    			item.use(this);
    			return;
    		}
    	}
    	
    	System.out.println("You don't have that item.");
    	
    }
    
    




}