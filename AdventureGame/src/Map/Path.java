package Map;

import Map.Room;

public class Path {
    
	// A Path is a connection between two rooms, a source Room and a target Room 
	// Each path has a direction that it exits the source room.  The direction
	// is simply a string, such as "east", "up", or "the hole in the wall".
	
    private Room source;
    private Room target;
    private String direction;
    private boolean hasLock = false;
    
    public Path(Room source, Room target, String exitName) {
        setSource(source);
        setTarget(target);
        setDirection(exitName);
        source.addExit(this);
    }
    
    
    // source Room setter
    public void setSource(Room source) {
        this.source = source;
    }

    // source Room getter
    public Room getSource() {
        return source;
    }

    // target Room setter
    public void setTarget(Room target) {
        this.target = target;
    }

    // target room getter
    public Room getTarget() {
        return target;
    }

    // direction setter
    public void setDirection(String direction) {
        this.direction = direction;
    }

    // direction getter
    public String getDirection() {
        return direction;
    }


	//
	public boolean hasLock() {
		return hasLock;
	}
}  // end class Path
