package Items;

import Entity.Player;
import Map.LockedPath;

public class Key extends Item{

	//consider removing
    public Key(String name, String description){
        super(name, description);
    }

    //
    public boolean use(Player player){
    	if (player.getCurrentRoom().getLockedExits().size() > 0){
    	// if there are locked paths
    		for (LockedPath exit : player.getCurrentRoom().getLockedExits()){
    			if (exit.unlock(this)){
    				System.out.println("You unlocked "+exit.getDirection()+"!");
    				return true;
    			}
    		}
            return true;
    	}
    	return false;
    	// if there are no locked paths
    	

    }
}
