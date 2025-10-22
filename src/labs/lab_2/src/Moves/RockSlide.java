package Moves;

import ru.ifmo.se.pokemon.*;

public final class RockSlide extends PhysicalMove {

    public RockSlide() {
        /*
         * power 75
         * accuracy 90
         * priority 0
         * hits 1
         */
        super(Type.ROCK, 75, 90, 0, 1);
    }

    /*
     * Rock Slide deals damage and has a 30% chance of causing the target to flinch
     * (if the target has not yet moved).
     * 
     * Pokémon with the ability Inner Focus or those behind a Substitute cannot be
     * made to flinch..
     */
    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect flinchEffect = new Effect().chance(0.3);
        flinchEffect.flinch(p);
        p.addEffect(flinchEffect);
    }

    @Override
    protected String describe() {
        return "uses Rock Slide";
    }
}
