import javax.swing.ImageIcon;

/**
 *
 * @author Thomas
 */
public class Room {
    private String name;
    private String description;
    private Door[] exits = new Door[4];

    

    
    public Room(String name, String description){
        this.name = name;
        this.description = description;
        //north
        exits[0] = null;
        //west
        exits[1] = null;
        //east
        exits[2] = null;
        //south
        exits[3] = null;
    }
    public void addExit(Door door, int i){
        for (Door d : exits){
            if (d == null){
                d = door;
                return;
            }
        }
    }
    
    //Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Door getExits(int i) {
        return exits[i];
    }
    public void setExits(Door[] exits) {
        this.exits = exits;
    }
}
