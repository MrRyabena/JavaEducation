package Pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import Moves.*;

public class Nuzleaf extends Seedot {
    public Nuzleaf(String name, int level) {
     super(name, level);

        /*
         * HP               70
         * Attack           70
         * Defense          40
         * Special Attack   60
         * Spacial Defense  40
         * Speed            60
         */
        this.setStats(70d, 70d, 40d, 60d, 40d, 60d);
        this.addType(Type.DARK);
        
        // Add Extrasensory to legacy attacks (Energy Ball, Confide)
        this.addMove(new Extrasensory());
    }
}
