package PlayOfGame;

import java.util.ArrayList;

import Map.*;
import Controls.Command;
import Items.Item;


public class Player {

    private World myWorld;
    private Room currentRoom;
    private String name = "";
    public ArrayList<Item> inventory;
    
    public Player(World world) {
        myWorld = world;
        inventory = new ArrayList<Item>(0);
    }
    
    public Player(String name, World world) {
        this(world);
        this.name = name;
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
        if (inventory == null){
        	System.out.println("You open your bag to find nothing.i");
        } else {
        	System.out.print("You open your bag and find a ");
        	for (Item item : inventory) {
        		System.out.print(item.getName());
        		i++;
        		if (i != inventory.size()) {
        			System.out.print(", ");
        		} else {
        			System.out.print(".");
        		}
        		if (i == (inventory.size() - 1)) {
                    System.out.print("and ");
        		}
        	}
        }
    }
    
    public void actionTake(Command turn){
        //String itemName = turn.getSecondWord();
    	if (currentRoom.hasItem()){
    		if (((ItemRoom) currentRoom).isHere()) {
            	((ItemRoom) currentRoom).setHere(false);
            	inventory.add(((ItemRoom) currentRoom).getItem());
            	System.out.println(((ItemRoom) currentRoom).getItem().getDescription());
            	System.out.println("You add the "+((ItemRoom) currentRoom).getItem().getName()+ " to your bag");
            } else {
                System.out.println("There is nothing left to take.");
            }
    	} else {
    		System.out.println("It dosn't look like there is anything to take.");
    	}
    }
    
    public void actionUse(Command turn){
    	for (Item item : inventory) {
    		System.out.println(item.getName()+".");
    		System.out.println(turn.getSecondWord()+".");
    		if (item.getName().equals(turn.getSecondWord())){
    			item.use(this);
    			return;
    		}
    	}
    	
    	System.out.println("You don't have that item.");
    	
    }
    
    




}