package Moves;
import ru.ifmo.se.pokemon.Move.*;

public class WorkUp extends StatusMove {

    public WorkUp() {
         /*
         * power     -
         * accuracy  -
         * priority  0
         * hits      1
         */
        super(Type.NORMAL);
    }

    /*
     * Work Up raises the user's Attack and Special Attack by one stage each.
     * 
     * Stats can be raised to a maximum of +6 stages each.
     */
    @Override
    protected void applySelfEffects(Pokemon self) {
        self.restore();
        self.stat(Stat.ATTACK, 6);
        self.stat(Stat.SPECIAL_ATTACK, 6);
    }

    @Override
    protected String describe() {
        return "flinch";
    }
    
}
