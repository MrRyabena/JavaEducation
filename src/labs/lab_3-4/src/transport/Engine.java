package transport;

public abstract class Engine extends core.Statusable {
    public static enum Fuel {
        WATER,
        HEATED_WATER,
        GAS
    }

    public static record Parameters(int power, Fuel fuel) {}

    public final EngineTypes type;
    public final Parameters parameters;
    protected boolean m_state;

    public Engine(EngineTypes set_type, Parameters params) {
        type = set_type;
        parameters = params;
    }

    public void start() {
        m_state = true;
        m_setStatus("start");
    }

    public void stop() {
        m_state = false;
        m_setStatus("stop");
    }

    public boolean isWorking() {
        return m_state;
    }

    public String toString() {
        return type.toString() + " " + m_status;
    }
}
