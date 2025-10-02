import ru.ifmo.se.pokemon.*;

public class PokemonSnover extends Pokemon {
    public PokemonSnover(String name, int level) {
        super(name, level);
        this.setStats(100, 100, 100, 100, 100, 100);
        this.setType(Type.ICE);
        // this.setMove(n=);
    }
}
