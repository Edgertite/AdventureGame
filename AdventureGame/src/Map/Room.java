package Map;

import java.util.ArrayList;

public class Room{

    // protected because subclasses can get to it...
    protected String name;
    protected String description;

    private ArrayList<Path> exits;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new ArrayList<Path>();
    }


    // setters and getters
        
    public void setDescription(String description) {
        this.description = description;
    }
    
    // adds a path from this room
    public void addExit(Room target, String dir) {
        Path path = new Path(this, target, dir);
        getExits().add(path);
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
    public boolean exitRoom() {
        return true;
    }

    // When the player tries to move, it calls its room's tryToMove method.
    // This method returns null if unsuccessful. Otherwise, it returns the
    // room that the player has moved to.
    public Room tryToExit(String direction) {
        //check if this is a valid direction
        Path path = getExit(direction);
        if (path != null) {
            if (exitRoom()) {
                return path.travelDestination();
            }
        }
        return null;
    }

    
    // returns the path object if the argument is a direction to that path.
    // if no such direction exists, returns null.
    public Path getExit (String possibleExit) {
        for (Path p: getExits()) {
            if (p.getDirection().equalsIgnoreCase(possibleExit)) {
                return p;
            }
        }
        return null;
    }
 
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

        public ArrayList<Path> getExits() {
                return exits;
        }

        public void setExits(ArrayList<Path> exits) {
                this.exits = exits;
        }
 




} // end Room