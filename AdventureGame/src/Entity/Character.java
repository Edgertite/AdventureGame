package Entity;

import java.util.ArrayList;

import Items.Item;
import Map.Room;

public class Character {

	private int health;
	private Room currentRoom;
    private String name = "";
    private ArrayList<Item> inventory;
    private String description;
    
    
    
	public int getHealth() {
		return health;
	}
	
	//
	public void setHealth(int health) {
		this.health = health;
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
	public String getName() {
		return name;
	}
	
	//
	public void setName(String name) {
		this.name = name;
	}
	
	//
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	//
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	
	//
	public String getDescription() {
		return description;
	}
	
	//
	public void setDescription(String description) {
		this.description = description;
	}

	
}
