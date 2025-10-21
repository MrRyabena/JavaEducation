package Pokemons;


import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Seedot extends Pokemon {
    public Seedot (String name, int level) {
        super(name, level);

        /*
         * HP               40
         * Attack           40
         * Defense          50
         * Special Attack   30
         * Spacial Defense  30
         * Speed            30
         */
        this.setStats(40d, 40d, 50d, 30d, 30d, 30d);
        this.setType(Type.GRASS);
        // this.setMove(n=);
    }
}
