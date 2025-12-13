package characters;

import transport.Balloon;

public class Smarty extends Character {

    public Smarty() {
        super("Smarty");
    }

    public Balloon makeBalloon() {
        m_setStatus("make balloon");
        var rnd = new java.util.Random();
        return new Balloon("Blue balloon", 1000, rnd.nextDouble(0, 1.5));
    }
}
