package transport;

public class WaterEngine extends Engine {
    public WaterEngine(EngineTypes type, Parameters params)
    {
        super(type, params);
    }

        public WaterEngine(Parameters params)
    {
        super(EngineTypes.WATER_ENGINE, params);
    }

    @Override
    public void start()
    {
        m_state = true;
        m_setStatus("starts");
    }

    @Override
    public void stop()
    {
        m_state = false;
        m_setStatus("stalls");
    }

}
