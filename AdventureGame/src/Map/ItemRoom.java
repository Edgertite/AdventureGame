package Map;

import java.util.ArrayList;

import Items.Item;

public class ItemRoom extends Room{

    private Item item;
    private boolean isHere;
    private boolean isInfinite;
    private boolean mustTake;

    public ItemRoom(String name, String desc, Item item) {
        this.name = name;
        this.description = desc;
        this.item = item;
        this.isHere = true;
        this.mustTake = false;
        this.isInfinite = false;
        setExits(new ArrayList<Path>());
    }

    public ItemRoom(String name, String desc, Item item, boolean isInfinite) {
        this.name = name;
        this.description = desc;
        this.item = item;
        this.isHere = true;
        this.mustTake = false;
        this.isInfinite = isInfinite;
        setExits(new ArrayList<Path>());
    }

    public boolean takeItem()
    {
        if (isHere){
            if (isInfinite) return true;
            
        }
        return true;
    }
}
