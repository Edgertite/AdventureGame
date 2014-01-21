package Entity;

import java.util.ArrayList;

import Map.*;
import PlayOfGame.World;
import Controls.Command;
import Items.Item;


public class Player extends Character{
    
	//
    public Player(World world) {
        //myWorld = world;
        setInventory(new ArrayList<Item>(0));
    }
    
    //may remove later as it does the same as the above
    public Player(String name, World world) {
        this(world);
        //this.name = name;
    }
     
    //////
    ////// Handle Commands
    //////

    //
    public void dispatch(Command turn) {
        if (turn.isLookRoom()) {
            actionLookRoom();
            
        } else if (turn.isTravel(getCurrentRoom())) {
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

    //
    public void actionTravel(Command turn) {
        String newDir = turn.getSecondWord();
        Room newRoom = getCurrentRoom().tryToExit(newDir);
        if (newRoom == null) {
            System.out.println("You can't go that direction from here.");
        } else {
            if (newRoom.enterRoom()) {
            	setCurrentRoom(newRoom);
            } else {
                System.out.println("You can't go there.");
            }
        }
    }

    //
    public void actionLookRoom() {
        getCurrentRoom().printDescription();
    }
    
    //
    public void actionInventory() {
        int i = 0;
        if (getInventory() == null){
        	System.out.println("You open your bag to find nothing.i");
        } else {
        	System.out.print("You open your bag and find a ");
        	for (Item item : getInventory()) {
        		System.out.print(item.getName());
        		i++;
        		if (i != getInventory().size()) {
        			System.out.print(", ");
        		} else {
        			System.out.print(".");
        		}
        		if (i == (getInventory().size() - 1)) {
                    System.out.print("and ");
        		}
        	}
        }
    }
    
    //
    public void actionTake(Command turn){
        //String itemName = turn.getSecondWord();
    	if (getCurrentRoom().hasItem()){
    		if (((ItemRoom) getCurrentRoom()).isHere()) {
            	((ItemRoom) getCurrentRoom()).setHere(false);
            	getInventory().add(((ItemRoom) getCurrentRoom()).getItem());
            	System.out.println(((ItemRoom) getCurrentRoom()).getItem().getDescription());
            	System.out.println("You add the "+((ItemRoom) getCurrentRoom()).getItem().getName()+ " to your bag");
            } else {
                System.out.println("There is nothing left to take.");
            }
    	} else {
    		System.out.println("It dosn't look like there is anything to take.");
    	}
    }
    
    //
    public void actionUse(Command turn){
    	for (Item item : getInventory()) {
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