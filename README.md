============================
=======Adventure Game=======
============================
=A Project From The Gitters=
============================

Members of The Gitters:
~ Edgertite
~ magicjamesv
~ brandon96
~ jlwirth
~ mpieczynski

Others may have contributed parts to this project, but the members of The Gitters are the only ones who are to take credit for this game seeing as it is mostly the work of The Gitters.

========================================
=How we would like to see the code look=
========================================

    package Entity;                         // package should be line 1, not 2or anything else
                                            // leave 1 line of spase between everything
    import Items.Key;                       // only import what you need. notice this is not import Items.*;
    
    public class Character {
    
        private int health;                 // every thing inside a pair of {} will be indented. an indent is = to 4 spases
        private int damage;                 // all variables are private use getters and setters if you need to change it
    
        public Character() {                // no space between method name and parentheses its not Character () {
            this.health = 10;
            this.damage = 1;
        }
        
        //
        public int getHealth() {            // follow this pattern for getters
            return health;
        }
        
        //
        public void setHealth(int health) { // follow this pattern for setters
            this.health = health;
        }
        
        // follow this pattern for methods
        // include a line for a comment even if you don't write a comment
        
        // takes health away from target in an amount equal to damage of attacker
        public void attack(Character target) {
            target.setHealth(target.getHealth()-damage);
        }
    }
