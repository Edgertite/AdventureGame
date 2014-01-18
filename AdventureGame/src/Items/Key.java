package Items;

public class Key extends Item{

    private int code;

    public Key(int id, String name, String Description, int code){
        this.id = id;
        this.name = name;
        this.description = description;
        this.code = code;
    }

    public void activate(){
        System.out.println("you just activated an item, but nothing happened.");
    }
}
