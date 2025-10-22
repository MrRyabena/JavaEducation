import ru.ifmo.se.pokemon.*;
import Pokemons.*;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();
        

        battle.addAlly(new Snover("Frostbite", 1));
        battle.addAlly(new Abomasnow("Blizzard", 1));
        battle.addAlly(new Seedot("Acorn", 1));
       

        battle.addFoe(new Mimikyu("Disguise", 1));
        battle.addFoe(new Nuzleaf("Shadowleaf", 1));
        battle.addFoe(new Shiftry("Stormwind", 1));
        
        battle.go();
    }
}
