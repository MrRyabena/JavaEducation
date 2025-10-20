package Pokemons;

import ru.ifmo.se.pokemon.Pokemon;


public class Snover extends Pokemon {
    public Snover(String name, int level) {
        super(name, level);

        /*
         * HP               60
         * Attack           62
         * Defense          50
         * Special Attack   62
         * Spacial Defense  60
         * Speed            40
         */
        this.setStats(60d, 62d, 50d, 62d, 60d, 40d);
        this.setType(Type.ICE);
        // this.setMove(n=);
    }
}
