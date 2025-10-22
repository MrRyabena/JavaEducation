package Pokemons;

import Moves.*;

public final class Shiftry extends Nuzleaf {
    public Shiftry(String name, int level) {
     super(name, level);

        /*
         * HP               90
         * Attack           100
         * Defense          60
         * Special Attack   90
         * Spacial Defense  60
         * Speed            80
         */
        this.setStats(90d, 100d, 60d, 90d, 60d, 80d);

        // Add X-Scissor to legacy attacks (Energy Ball, Confide, Extrasensory)
        this.addMove(new XScissor());
    }
    
}
