package Moves;

import ru.ifmo.se.pokemon.*;

public class ZingZap extends PhysicalMove {

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
    protected void applyOppEffects(Pokemon p) {
        Effect flinchEffect = new Effect().chance(0.3);
        flinchEffect.flinch(p);
        p.addEffect(flinchEffect);
    }

    @Override
    protected String describe() {
        return "uses Zing Zap";
    }
 }
 

    

