public class Door {
    private Room[] rooms = new Room[2];
    
    public Door(Room roomA, Room roomB, int ia){
        int ib = 4;
        if (ia==0){
            ib = 3;
        } else if (ia==1) {
            ib = 2;
        } else if  (ia==2) {
            ib = 1;
        } else if (ia==3) {
            ib = 0;
        }
        rooms[0] = roomA;
        rooms[1] = roomB;
        rooms[0].addExit(this, ia);
        rooms[1].addExit(this, ib);
    }
    
}
