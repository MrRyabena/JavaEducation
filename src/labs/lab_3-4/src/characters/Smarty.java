package characters;

import transport.*;

public final class Smarty extends Character {

    public Smarty() throws core.ScriptException {
        super("Smarty");

        if (m_created) throw new core.ScriptException("Only one instance of Smarty is allowed!");
        m_created = true;
    }

    public Transport inventTransport(TransportTypes type) {
        m_setStatus("make a " + type.toString().toLowerCase());
        var rnd = new java.util.Random();

        m_quality += rnd.nextDouble(0.1, 0.5);

        return switch (type) {
            case BALLOON ->
                    new Balloon(
                            new Transport.Parameters(
                                    "Blue-ball",
                                    8,
                                    (int) (100 * m_quality),
                                    (int) (1000 * m_quality)),
                            new Burner(new Engine.Parameters((int)(500 * m_quality), Engine.Fuel.GAS)),
                            rnd.nextDouble(0.5, 1.5));
            case AUTOMOBILE ->
                    new Automobile(
                            new Transport.Parameters(
                                    "Red-car", 4, (int) (100 * m_quality), (int) (10 * m_quality)),
                            m_automobile_counter > 0
                                    ? new ModifiedWaterEngine(
                                            new Engine.Parameters(
                                                    (int) (2500 * m_quality), Engine.Fuel.WATER))
                                    : new WaterEngine(
                                            new Engine.Parameters(
                                                    (int) (2500 * m_quality),
                                                    Engine.Fuel.CARBONATED_WATER)),
                            rnd.nextDouble(0.5, 1.5));
            default -> null;
        };
    }

    private int m_automobile_counter = 0;
    private double m_quality = 1d;

    private static boolean m_created = false;
}
