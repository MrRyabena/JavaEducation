package Moves;

import ru.ifmo.se.pokemon.*;

public final class Extrasensory extends SpecialMove {

    public Extrasensory() {
        /*
         * power 80
         * accuracy 100
         * priority 0
         * hits 1
         */
        super(Type.PSYCHIC, 80, 100, 0, 1);
    }

    /*
     * Extrasensory deals damage and has a 10% chance of causing the target to
     * flinch (if the target has not yet moved).
     * 
     * Pokémon with the ability Inner Focus or those behind a Substitute cannot be
     * made to flinch.
     */
    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect flinchEffect = new Effect().chance(0.1);
        flinchEffect.flinch(p);
        p.addEffect(flinchEffect);
    }

    @Override
    protected String describe() {
        return "uses Extrasensory";
    }
}
