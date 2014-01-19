package PlayOfGame;

import java.util.ArrayList;
import Map.Room;
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
    //////   Handle Commands
    //////
    
    public void dispatch(Command turn) {
        if (turn.isLookRoom()) {
            actionLookRoom();
            
        } else if (turn.isTravel(currentRoom)) {
            actionTravel(turn);

        } else if (turn.isInventory()){
        	actionInventory();
        } else {
            System.out.println("Huh?");
        }
    }


    
    public void actionTravel(Command turn) {
        String newDir = turn.getDirectionReference();
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
    	System.out.print("You open your bag and find");
    	for (Item item : inventory) {
    		System.out.print(", " + item.getName());
    	}
    }
    
    
    




}
