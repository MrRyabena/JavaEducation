package transport;

public class Automobile extends Transport {
    public Automobile(Parameters params, Engine engine, double reliability) {
        super(TransportTypes.AUTOMOBILE, params, engine, reliability);
    }

    public Automobile(Parameters params, Engine engine) {
        super(TransportTypes.AUTOMOBILE, params, engine);
    }

    @Override
    public void start() {
        m_engine.start();
        m_setStatus("starting");
    }

    @Override
    public void action() throws BreakException, InterruptedException {
        m_setStatus("moving");
        super.action();
    }

    @Override
    public void stop() {
        m_engine.stop();
        m_setStatus("stop");
    }

}
