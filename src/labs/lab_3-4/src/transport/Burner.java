package transport;

public class Burner extends Engine {
    public Burner(Parameters params)
    {
        super(EngineTypes.BURNER, params);
    }

    @Override
    public void start()
    {
        m_state = true;
        m_setStatus("is lighting up");
    }

    @Override
    public void stop()
    {
        m_state = false;
        m_setStatus("is going out");
    }

}
