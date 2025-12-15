package characters;

import transport.*;

public class Smarty extends Character {

    public Smarty() throws core.ScriptException {
        super("Smarty");
                
        if (m_created) throw new core.ScriptException("Only one instance of Smarty is allowed!");
        m_created = true;
    }

    public Transport inventTransport(TransportType type) {
        m_setStatus("make a " + type.toString().toLowerCase());
        var rnd = new java.util.Random();

        m_quality += rnd.nextDouble(0.1, 0.5);
        return switch (type) {
            case BALLOON -> new Balloon("Blue-ball", (int)(1000 * m_quality), rnd.nextDouble(0.5, 1.5));
            case AUTOMOBILE -> new Automobile("Red-car", (int)(10 * m_quality), rnd.nextDouble(0.5, 1.5));
            default -> null;
        };
    }

    private static boolean m_created = false;
    private double m_quality = 1d;
}
