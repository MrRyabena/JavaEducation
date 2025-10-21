package Moves;

import ru.ifmo.se.pokemon.*;

public class Confide extends StatusMove {

    public Confide() {
        /*
         * power -
         * accuracy -
         * priority 0
         * hits 1
         */
        super(Type.NORMAL, 0, 0);
    }

    /*
     * Confide lowers the target's Special Attack by one stage.
     * 
     * Stats can be lowered to a minimum of -6 stages each.
     */
    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().stat(Stat.SPECIAL_ATTACK, -1));
    }

    @Override
    protected String describe() {
        return "uses Confide";
    }
}
