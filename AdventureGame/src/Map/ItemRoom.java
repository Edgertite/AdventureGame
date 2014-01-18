package Map;

import java.util.ArrayList;

import Items.Item;

public class ItemRoom extends Room{

    private Item item;
    private boolean isHere;
    private boolean isInfinite;
    private boolean mustTake;

    public ItemRoom(String name, String desc, Item item){
        this.name = name;
        this.description = desc;
        this.item = item;
        this.isHere = true;
        this.mustTake = false;
        this.isInfinite = false;
        setExits(new ArrayList<Path>());
    }

    public ItemRoom(String name, String desc, Item item, boolean isInfinite){
        this.name = name;
        this.description = desc;
        this.item = item;
        this.isHere = true;
        this.mustTake = false;
        this.isInfinite = isInfinite;
        setExits(new ArrayList<Path>());
    }

    // Returns a boolean indicating success at taking the Item . if the item is finite,
    //it will run out. If its out it will return false.
    public boolean takeItem(){
        if (isHere){
            if (isInfinite){
            	return true;
            }
            isHere = false;
            return true;
        }
        return false;
    }

    //TODO: When the player tries to take the item, it calls its room's tryToMove method.
    // This method returns null if unsuccessful. Otherwise, it returns the
    // room that the player has moved to.
    public Room tryToTake() {
        //check if this is a valid direction
        if (takeItem()) {
            //item to bag
        }
        return null;
    }
}
