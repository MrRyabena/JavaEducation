package Pokemons;


import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import Moves.*;

public class Mimikyu extends Pokemon {
    public Mimikyu(String name, int level) {
     super(name, level);

        /*
         * HP               55
         * Attack           90
         * Defense          80
         * Special Attack   50
         * Spacial Defense  105
         * Speed            96
         */
        this.setStats(55d, 90d, 80d, 50d, 105d, 96d);
        this.setType(Type.FAIRY);
        this.setMove(new ZingZap(), new WorkUp(), new Facade(), new Nuzzle());
    }
    
}
