package Items;

import Entity.Player;
import PlayOfGame.World;

public class Goal extends Item{
	
	public Goal(String name, String description){
		super(name, description);
	}

	@Override
	public boolean use(Player player){
		World.isPlaying = false;
		System.out.println("You eat the cheese and find yourself in a sence of peace \n"
				+ "although its not as fuffilling as you antisipated you feel content. \n"
				+ "After all that is what inner peace is... right..."
				+ " \n"
				+ "Then it dawns on you, the question thats been in the bac of your mind. \n"
				+ " \n"
				+ "How do i get out of this house?");
		return true;
	}
}
