package transport;

public class Automobile extends Transport {
    public Automobile(String set_model, int set_resource, double set_reliability) {
        super(TransportType.AUTOMOBILE, set_model, set_resource, set_reliability);
    }

    public Automobile(String set_model, int set_resource) {
        super(TransportType.AUTOMOBILE, set_model, set_resource);
    }

    @Override
    public void start() {
        m_setStatus("starting");
    }

    @Override
    public void action() throws BreakException, InterruptedException {
        m_setStatus("moving");
        super.action();
    }

    @Override
    public void stop() {
        m_setStatus("stop");
    }
}
