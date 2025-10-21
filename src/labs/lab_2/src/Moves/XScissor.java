package Moves;

import ru.ifmo.se.pokemon.*;

public class XScissor extends PhysicalMove {

    public XScissor() {
        /*
         * power 80
         * accuracy 100
         * priority 0
         * hits 1
         */
        super(Type.BUG, 80, 100, 0, 1);
    }

    /*
     * X-Scissor deals damage with no additional effect.
     */

    @Override
    protected String describe() {
        return "uses X-Scissor";
    }
}
