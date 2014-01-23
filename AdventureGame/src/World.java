public class World {
    private Room[] rooms = new Room[2];
    private Door[] doors = new Door[1];
    private Player player;
    
    public static void main(String[] args) {
        World theWorld = new World();
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                new AdventureGUI().setVisible(true);
            }
        });
    }
    
    public World() {
        player = new Player();
        /////// constructs all Rooms
        //////
        rooms[0] = new Room(
            "bedroom" ,
            "You are in a strange bedroom. The only reason you know it is a bedroom is \n" +
            "by the large, rumpled bed against the wall. The pillow resembles a cement block, \n" +
            "and the sheets sandpaper. The air is stale, and there isn't much of interest here.\n");
        rooms[1] = new Room(
            "intersection",
            "Yout walk throught the door, and see a dark room only lit by a stove. \n" + 
            "There are 4 doors in this room, and it looks like there may be a few \n" + 
            "other things worth looking at.");
        doors[0] = new Door(rooms[0], rooms[1]);
        Player.currentRoom = rooms[0];
    }
}
