package Moves;

import ru.ifmo.se.pokemon.Move.*;

public class ZingZap extends PhisicalMove {

    public ZingZap() {
        /*
         * power     80 
         * accuracy  100
         * priority  0
         * hits      1
         */
        super(Type.ELECTRIC, 80, 100, 0, 1);
    }

    /*
     * May cause flinching. (30% chance)
     */
    @Override
    protected void applySelfEffects(Pokemon self) {
        Effect eff = new Effect().attack(0.3);
        
        eff.flinch(self);
    }


    @Override
    protected String describe() {
        return "flinch";
    }
 }
 

    

