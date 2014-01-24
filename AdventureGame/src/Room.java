public class Room {
    private String name;
    private String description;
    private Room[] rooms = new Room[4];
    
    public Room(String name, String description){
        this.name = name;
        this.description = description;
    }
    public void addExit(Room room, int i){
        rooms[i] = room;
    }
    
    public Room getNextRoom(int i){
        
        return null;
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
        public Room getRooms(int i) {
        return rooms[i];
    }
    public void setRoom(Room room, int i) {
        this.rooms[i] = room;
    }
}
