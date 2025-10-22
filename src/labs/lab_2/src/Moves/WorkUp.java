package Moves;

import ru.ifmo.se.pokemon.*;

public final class WorkUp extends StatusMove {

    public WorkUp() {
        /*
         * power -
         * accuracy -
         * priority 0
         * hits 1
         */
        super(Type.NORMAL, 0, 0);
    }

    /*
     * Rock Slide deals damage and has a 30% chance of causing the target to flinch
     * (if the target has not yet moved).
     * 
     * Pokémon with the ability Inner Focus or those behind a Substitute cannot be
     * made to flinch.
     */
    @Override
    protected void applySelfEffects(Pokemon self) {
        self.addEffect(new Effect().stat(Stat.ATTACK, 1).stat(Stat.SPECIAL_ATTACK, 1));
    }

    @Override
    protected String describe() {
        return "uses Work Up";
    }

}
