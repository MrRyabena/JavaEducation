package Pokemons;


public class Abomasnow extends Snover {
    public Abomasnow(String name, int level) {
        super(name, level);

        /*
         * HP               90
         * Attack           92
         * Defense          75
         * Special Attack   92
         * Spacial Defense  85
         * Speed            60
         */
        this.setStats(90d, 92d, 75d, 92d, 85d, 60d);
        
    }
    
}
