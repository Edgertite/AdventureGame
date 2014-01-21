package Items;

import Entity.Player;

public class Item {
    // instance variables - replace the example below with your own
    private String name;
    protected String description;
    
    public Item(String name, String description){
    	this.name = name;
    	this.description = description;
    }

    //
    public boolean use(Player player){
    	System.out.print(description);
    	return true;
    }

	//
	public String getName() {
		return name;
	}

	//
	public void setName(String name) {
		this.name = name;
	}

	//
	public String getDescription() {
		return description;
	}

	//
	public void setDescription(String description) {
		this.description = description;
	}
}
