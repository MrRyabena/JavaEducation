package Moves;

import ru.ifmo.se.pokemon.*;

public class IcyWind extends SpecialMove {

    public IcyWind() {
        /*
         * power 55
         * accuracy 95
         * priority 0
         * hits 1
         */
        super(Type.ICE, 55, 95, 0, 1);
    }

    /*
     * Icy Wind deals damage and lowers the target's Speed by one stage.
     * 
     * Stats can be lowered to a minimum of -6 stages each.
     */
    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().stat(Stat.SPEED, -1));
    }

    @Override
    protected String describe() {
        return "uses Icy Wind";
    }
}
