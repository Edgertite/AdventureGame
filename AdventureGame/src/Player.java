/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thomas
 */
public class Player {
    public static Room currentRoom;
    private int hunger;

    public Player() {
        
    }

    
    
    
    
    
    public static Room getCurrentRoom() {
        return currentRoom;
    }
    public static void setCurrentRoom(Room currentRoom) {
        Player.currentRoom = currentRoom;
    }
}
