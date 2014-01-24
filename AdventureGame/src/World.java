public class World {
    public static Room[] rooms = new Room[26];
    public static Player player;
    
    public static void main(String[] args) {
        World theWorld = new World();
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                new AdventureGUI().setVisible(true);
            }
        });
    }
    
    public World() {
        player = new Player();
        /////// constructs all Rooms
        //////
        rooms[0] = new Room(
        		"Dressing Room" ,
        		"You wake up in a dressing room with your hair messed up and clothes all crumpled. You look at your watch and see it is 5 in the morning. You think you blacked out and you don't know how you got there but you reach to empty your pockets.You find a cookie connection coupon that has todays date. Then you realize you have to get to work at cookie connection. As you take in your surroundings you see a shiny key in the corner that looks like it could be useful. You start to get dizzy and your stomach is growling. You must get enough food and drinks before you pass out so you can make it to work on time to deliver Mr. Amalongs chocolate chip cookies.");
        rooms[1] = new Room(
        		"Dressing Room corridor",
        		"You step into the dressing room corridor and you see a wallet that has your name on it. You see a banana on the ground and decide it will have to do for now. You see two more         dressing rooms and an exit to H&M.");
        rooms[2] = new Room(
        		"Dressing Room",
        		"You are in the dressing and see a soggy sandwich on the floor but that has never stopped you before.");
        rooms[3] = new Room(
        		"Dressing Room",
        		"You are in a dressing room.");
        rooms[4] = new Room(
        		"H&M",
        		"You step into H&M and start looking at clothes and find a scarf that you really like and when you put it on it makes your shirt look less wrinkled.");
        rooms[5] = new Room(
        		"Couches",
        		"You find couches and lay down and you feel something hard but judging on the memories from last night it could be interesting so you look to see what it is. You find a remote but you don't recognize that it goes to any of the tv's in that room.");
        rooms[6] = new Room(
        		"Escalator",
        		"You reach the escalator and realize it is locked and you need to get the key that will turn it on and the remote that will get it moving.");
        rooms[7] = new Room(
        		"Macy’s",
        		"You find Macy's and walk in to an look at yourself in a full facing mirror. You look god awful that party last night really messed you up. Your eyes are bloodshot from all the drugs you did. You see a pair of sunglasses and decide these would help your image.");
        rooms[8] = new Room(
        		"Jewelry",
        		"");
        rooms[9] = new Room(
        		"Shoes",
        		"You go to the shoes department and wow do you like shoes and considering you didn't have any to start the day off you picked out a nice par of heels. Although they are the         most uncomfortable shoe even you think to your self wow I almost look presentable.");
        rooms[10] = new Room(
        		"JCPenny",
        		"You’ve arrived in JC Penny’s. This is a huge department store with many items, but none that seem beneficial to making it to work on time . Unless you are interested in watches that is….");
        rooms[11] = new Room(
        		"Backroom Storage",
        		"You are now in the backroom storage of JC Penny’s. Behind a shelf you see an apple. You haven’t had anything to eat in awhile so this could be a nice treat!");
        rooms[12] = new Room(
        		"Employee Room",
        		"You have now entered the Employee Room. Be careful so you do not get caught back here! Wow around the corner there are 3 bags of chips! That could really stop your stomach from growling!");
        rooms[13] = new Room(
        		"Mall Hallway",
        		"You’ve gotten off of the elevator and now you are in the Mall Hallway. There are people everywhere so it’s hard to see if there is anything useful around. It’s best to not spend too much time here. There’s a more important mission you should get back to.");
        rooms[14] = new Room(
        		"Jamba Juice",
        		"Oooh you’ve reached Jamba Juice. It’s probably a good idea to pick up a smoothie to quench your thirst. It’s been a long trip and you still have a bit of a ways to go. You can’t be late or you’re going to lose your job!");
        rooms[15] = new Room(
        		"Playground",
        		"You’ve stepped outside to the Playground. Small children are screaming and running everywhere. You dodge a piece of bark being thrown at you from across the slide. Oh look there is a shoe under the swings. Maybe that could be handy for another room.");
        rooms [16] = new Room(
        		"American Eagle",
        		"You’re back inside American Eagle now. The workers are harassing you trying to force you into trying on a pair of jeans. You better not waste your time. It doesn’t look like there is much for you here.");
        rooms[17] = new Room(
        		"Dressing Room",
        		"Looks like you’ve been talked into trying on a pair of jeans after all. Well luckily for you there seems to be a bagel over on that bench. You should probably go pick it up so you don’t get hungry. Anything that looks edible is worth it at this point in the game!");
        rooms[18] = new Room(
        		"Swings",
        		"You walk over to the swings. Under one of the swings you see a bag of cheez-its. Other  than that, this area looks pretty empty.");
        rooms[19] = new Room(
        		"Food Court",
        		"You walk into the Food Court.To the east and west you can see some restaurants with some delicious food.");
        rooms[20] = new Room(
        		"Mongolian BBQ",
        		"You walk over to Mongolian BBQ. Here you can get a bowl full of noodles.");
        rooms[21] = new Room(
        		"Pluto’s",
        		"You walk over to Pluto’s where you can get a large ceasar salad.");
        rooms[22] = new Room(
        		"Mall Hallway",
        		"After exiting the food court, you’re in another hallway. It’s just as crowded as the last hallway. Try not to get lost and remember you need to get to work!");
        rooms[23] = new Room(
        		"Bathroom",
        		"You walk into the bathroom. You don’t see anyone and it seems pretty empty.");
        rooms[24] = new Room(
        		"Urban Outfitters",
        		"You walk into Urban Outfitters. There doesn’t seem to be anything useful for you in here.");
       	rooms[25] = new Room(
        		"Cookie Connection",
        		"Congratulations! You have reached Cookie Connection and can now eat as many warm, fresh-out-of-the-oven, chocolate chip cookies as you wish!");


        Player.currentRoom = rooms[0];
        //0= north
        //1 = west
        //2 = east
        //3 = south
        link(rooms[0], rooms[1], 2);
        link(rooms[1], rooms[2], 0);
        link(rooms[1], rooms[3], 2);
        link(rooms[1], rooms[4], 3);
        link(rooms[4], rooms[5], 2);
        link(rooms[4], rooms[6], 3);
        link(rooms[6], rooms[7], 2);
        link(rooms[7], rooms[8], 2);
        link(rooms[7], rooms[9], 3);
        link(rooms[6], rooms[10], 1);
        link(rooms[10], rooms[11], 0);
        link(rooms[11], rooms[12], 1);
        link(rooms[6], rooms[13], 3);
        link(rooms[13], rooms[14], 2);
        link(rooms[13], rooms[15], 1);
        link(rooms[15], rooms[16], 0);
        link(rooms[16], rooms[17], 0);
        link(rooms[15], rooms[18], 1);
        link(rooms[13], rooms[19], 3);
        link(rooms[19], rooms[20], 2);
        link(rooms[19], rooms[21], 1);
        link(rooms[19], rooms[22], 3);
        link(rooms[22], rooms[23], 2);
        link(rooms[22], rooms[24], 1);
        link(rooms[22], rooms[25], 3);
}
private void link(Room roomA, Room roomB, int a){
        //sets b to direction from room b to room A
        int b = 4 ;
        if (a==0){b=3;}else if(a==1){b=2;}else if(a==2){b=1;}else if(a==3){b=0;}
        roomA.addExit(roomB, a);
        roomB.addExit(roomA, b);
    }

}
