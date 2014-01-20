package Items;

import PlayOfGame.Player;

public class Key extends Item{

    private int code;

    public Key(int id, String name, String description, int code){
        super(id, name, description);
        this.code = code;
    }


    public boolean use(Player player){
        System.out.println("you just activated an item, but nothing happened.");
        return true;
    }
}
