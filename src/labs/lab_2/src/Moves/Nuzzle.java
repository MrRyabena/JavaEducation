package Moves;

import ru.ifmo.se.pokemon.*;

public class Nuzzle extends PhysicalMove {

    public Nuzzle() {
        /*
         * power 20
         * accuracy 100
         * priority 0
         * hits 1
         */
        super(Type.ELECTRIC, 20, 100, 0, 1);
    }

    /*
     * Nuzzle deals damage and paralyzes the target. Paralyzed Pokémon have a 25%
     * chance of not being able to attack, and their Speed is decreased by 50% (75%
     * in Generations 1-6).
     * 
     * Electric type Pokémon, those with the ability Limber or those behind a
     * Substitute cannot be paralyzed.
     */
    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().condition(Status.PARALYZE));
    }

    @Override
    protected String describe() {
        return "uses Nuzzle";
    }
}
