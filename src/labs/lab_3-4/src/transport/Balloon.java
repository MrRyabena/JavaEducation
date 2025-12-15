package transport;

public class Balloon extends Transport {
    public Balloon(Parameters params, Engine engine, double reliability) {
        super(TransportTypes.BALLOON, params, engine, reliability);
    }

    public Balloon(Parameters params, Engine engine) {
        super(TransportTypes.BALLOON, params, engine);
    }

    @Override
    public void start() {
        m_engine.start();
        m_setStatus("filling with hot air");
    }

    @Override
    public void action() throws BreakException, InterruptedException {
        m_setStatus("fly");
        super.action();
    }

    @Override
    public void stop() {
        m_engine.stop();
        m_setStatus("landing");
    }
}
