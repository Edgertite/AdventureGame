package Map;

import java.util.ArrayList;

import Map.LockedPath;

public class Room{

    // protected because subclasses can get to it...
    private String name;
    private String description;
    private ArrayList<Path> exits;
    private ArrayList<LockedPath> lockedExits;

    public Room(String name, String description) {
        this.setName(name);
        this.setDescription(description);
        this.setExits(new ArrayList<Path>());
        this.setLockedExits(new ArrayList<LockedPath>());
    }

    //is true in item rooms
    public boolean hasItem(){
    	return false;
    }
    
    // adds a exit for this room
    public void addExit(Path path) {
        getExits().add(path);
    }
    
    // adds a locked exit for this room
    public void addLockedExit(LockedPath lockedPath) {
    	getLockedExits().add(lockedPath);
	}

    public void printDescription() {
        System.out.println(description);
        printExits();
    }

    ////// Movement
    //////
    
    // method that gets called when you first enter a room; returns a boolean
    // indicating whether entry was sucessful.
    // This might get overridden by subclasses if something fancy should happen.
    public boolean enterRoom() {
        printDescription();
        return true;
    }
    
    // Returns a boolean indicating a successful exit. This version
    // does nothing, but subclasses might override this.
    public boolean exitRoom(Path path) {
    	if (path.hasLock()){
    		System.out.println("is a lockedpath path is unlocked: "+ ((LockedPath)path).isUnlocked());
   			return ((LockedPath)path).isUnlocked();
    	}
    	System.out.println("is a path");
    		return true;
    }

    // When the player tries to move, it calls its room's tryToMove method.
    // This method returns null if unsuccessful. Otherwise, it returns the
    // room that the player has moved to.
    public Room tryToExit(String direction) {
        //check if this is a valid direction
        Path path = getExit(direction);
        if (path != null) {
            if (exitRoom(path)) {
                return path.getTarget();
            }
        }
        return null;
    }

    // returns the path object if the argument is a direction to that path.
    // if no such direction exists, returns null.
    public Path getExit (String possibleExit) {
    	Path path = null;
    	for (Path p: getExits()) {
            if (p.getDirection().equalsIgnoreCase(possibleExit)) {
                path = p;
            }
        }
    	for (LockedPath p: getLockedExits()) {
            if (p.getDirection().equalsIgnoreCase(possibleExit)) {
                path = p;
            }
        }
        return path;
    }
 
    //
    public void printExits() {
        if (getExits().size() == 0) {
            System.out.println("There are no exits, and therefore no way out of here!");
        } else {
            int i = 0;
            System.out.print("The exits are ");
            for (Path p: getExits()) {
                System.out.print(p.getDirection());
                i++;
                if (i != getExits().size()) {
                    System.out.print(", ");
                } else {
                    System.out.print(".");
                }
                if (i == (getExits().size() - 1)) {
                    System.out.print("and ");
                }
            }
            System.out.println();
        }
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
	public String getDescription() {
		return description;
	}

	//
	public void setDescription(String description) {
		this.description = description;
	}

	//
	public ArrayList<Path> getExits() {
		return exits;
	}

	//
	public void setExits(ArrayList<Path> exits) {
		this.exits = exits;
	}

	//
	public ArrayList<LockedPath> getLockedExits() {
		return lockedExits;
	}

	//
	public void setLockedExits(ArrayList<LockedPath> lockedExits) {
		this.lockedExits = lockedExits;
	}
} // end Room