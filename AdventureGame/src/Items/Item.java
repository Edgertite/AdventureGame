package Items;

import PlayOfGame.Player;

public abstract class Item
{
    // instance variables - replace the example below with your own
    protected int id;
    private String name;
    protected String description;
    
    Item(int id, String name, String description){
    	this.id = id;
    	this.name = name;
    	this.description = description;
    }

    
    public abstract boolean use(Player player);


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
}
