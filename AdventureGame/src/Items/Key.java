package Items;

import Entity.Player;
import Map.Room;

public class Key extends Item{

	private Room currentRoom;
	private Room target;
	private String exitName;

	//consider removing
    public Key(String name, String description){
        super(name, description);
    }
    
    public Key(String name, String description,Room currentRoom, Room target, String exitName){
        super(name, description);
        this.currentRoom = currentRoom;
        this.target = target;
        this.exitName = exitName;
        
    }

    //
    public boolean use(Player player){
        if (player.getCurrentRoom() == currentRoom){
        	System.out.println("You unlocked "+exitName+"!");
        	player.getCurrentRoom().addExit(target, exitName);
        } else {
        	System.out.println("You just activated an item, but nothing happened.");
        }
        return true;
    }

	//
	public Room getCurrentRoom() {
		return currentRoom;
	}

	//
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	//
	public Room getTarget() {
		return target;
	}

	//
	public void setTarget(Room target) {
		this.target = target;
	}

	//
	public String getExitName() {
		return exitName;
	}

	//
	public void setExitName(String exitName) {
		this.exitName = exitName;
	}
}
