
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
        exits[0] = null;
        exits[1] = null;
        exits[2] = null;
        exits[3] = null;
    }
    public void addExit(Door door){
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
}
