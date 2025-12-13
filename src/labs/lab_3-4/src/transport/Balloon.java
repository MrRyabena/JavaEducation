package transport;

public class Balloon extends Transport {
    public Balloon(String set_model, int set_resource, double set_reliability) {
        super(TransportType.BALLOON, set_model, set_resource, set_reliability);
    }
    
    @Override
    public void start()
    {
        
    }

    @Override
    public void action() throws BreakException, InterruptedException {
        m_setStatus("fly");
        super.action();
    }

    @Override
    public void stop()
    {

    }
}
