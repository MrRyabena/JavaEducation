package Moves;

import ru.ifmo.se.pokemon.*;

public final class Rest extends StatusMove {

    public Rest() {
        /*
         * power -
         * accuracy -
         * priority 0
         * hits 1
         */
        super(Type.PSYCHIC, 0, 0);
    }

    /*
     * User sleeps for 2 turns, but user is fully healed.
     */
    @Override
    protected void applySelfEffects(Pokemon self) {
        self.addEffect(new Effect().condition(Status.SLEEP).turns(2));
        self.restore();
    }

    @Override
    protected String describe() {
        return "uses Rest";
    }
}
