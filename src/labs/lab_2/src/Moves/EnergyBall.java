package Moves;

import ru.ifmo.se.pokemon.*;

public final class EnergyBall extends SpecialMove {

    public EnergyBall() {
        /*
         * power 90
         * accuracy 100
         * priority 0
         * hits 1
         */
        super(Type.GRASS, 90, 100, 0, 1);
    }

    /*
     * Energy Ball deals damage and has a 10% chance of lowering the target's
     * Special Defense by one stage.
     * 
     * Stats can be lowered to a minimum of -6 stages each.
     */
    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().chance(0.1).stat(Stat.SPECIAL_DEFENSE, -1));
    }

    @Override
    protected String describe() {
        return "uses Energy Ball";
    }
}
