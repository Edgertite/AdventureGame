package Items;

public abstract class Item
{
    // instance variables - replace the example below with your own
    protected int id;
    private String name;
    protected String description;

    
    public abstract void activate();


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
}
