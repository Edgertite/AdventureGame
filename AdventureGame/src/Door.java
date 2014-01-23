
public class Door {
    private Room[] rooms = new Room[2];
    
    public Door(Room roomA, Room roomB){
        rooms[0] = roomA;
        rooms[1] = roomB;
        rooms[0].addExit(this);
        rooms[1].addExit(this);
    }
    
}
