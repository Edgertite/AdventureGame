package Items;

import PlayOfGame.Player;

public class Key extends Item{

    public Key(String name, String description){
        super(name, description);
    }


    public boolean use(Player player){
        System.out.println("you just activated an item, but nothing happened.");
        return true;
    }
}
