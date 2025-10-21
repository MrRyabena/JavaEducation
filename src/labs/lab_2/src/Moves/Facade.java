package Moves;

public class Facade extends PhisicalMove {
     public Facade() {
         /*
         * power     70
         * accuracy  100
         * priority  0
         * hits      1
         */
        super(Type.NORMAL, 70, 100, 0, 1);
    }

    /*
     * Facade deals damage, and hits with double power (140) if the user is burned, poisoned or paralyzed.
     * 
     * In the case of a burn, the usual attack-halving still occurs so Facade hits with an effective power of 70.
     */
    @Override
    protected void applySelfEffects(Pokemon self) {
        self.setMod(Stat.DAMAGE, 
         switch (self.getCondition()) {
            case Status.BURN, Status.POISON, Status.Paralyzed -> 140;
            default -> 70;
        }
        );
    }

    @Override
    protected String describe() {
        return "deals";
    }
}
