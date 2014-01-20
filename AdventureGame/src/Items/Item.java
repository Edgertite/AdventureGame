package Items;

import PlayOfGame.Player;

public class Item
{
    // instance variables - replace the example below with your own
    protected int id;
    private String name;
    protected String description;
    
    public Item(int id, String name, String description){
    	this.id = id;
    	this.name = name;
    	this.description = description;
    }

    
    public boolean use(Player player){
    	//TODO finish use(Player player)
    	return true;
    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
}
