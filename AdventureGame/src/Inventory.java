
public class Inventory {

	private Item[] inventory;

	public Inventory() {
		inventory = new Item[4];
	}

	public boolean pickUp(Item item){
		for (Item i : inventory){
            if (i == null){
                i = item;
                return true;
            }
        }
		return false;
	}
}
