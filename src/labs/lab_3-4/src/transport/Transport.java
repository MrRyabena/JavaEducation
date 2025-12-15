package transport;

import java.util.HashSet;
import java.util.Random;

public abstract class Transport extends core.Statusable
        implements core.Actionable, core.Explorable, Comparable<Transport> {

    public final TransportTypes type;

    public static record Parameters(String model, int capacity, int grace, int resource) {}

    protected final Parameters m_parameters;
    protected Engine m_engine;

    protected int m_mileage;

    protected HashSet<characters.Character> m_passengers;
    protected double m_reliability;

    public Transport(
            TransportTypes set_type, Parameters params, Engine set_engine, double set_reliability) {
        type = set_type;
        m_parameters = params;
        m_engine = set_engine;
        m_engine.onStatusChange(
                (obj) -> {
                    this.m_setStatus(obj.toString());
                });

        m_reliability = set_reliability;

        m_passengers = new HashSet<characters.Character>(m_parameters.capacity());
    }

    public Transport(TransportTypes set_type, Parameters params, Engine set_engine) {
        type = set_type;
        m_parameters = params;
        m_engine = set_engine;
        m_engine.onStatusChange(
                (obj) -> {
                    this.m_setStatus(obj.toString());
                });

        var random = new Random();
        m_reliability = random.nextDouble(0.5, 1.5);

        m_passengers = new HashSet<characters.Character>(m_parameters.capacity());
    }

    public String getCaption() {
        return type.toString() + " \"" + m_parameters.model() + "\"";
    }

    public Parameters getParameters() {
        return m_parameters;
    }

    public Engine.Parameters getEngineParameters() {
        return m_engine.parameters;
    }

    public EngineTypes getEngineType() {
        return m_engine.type;
    }

    public int getMileage() {
        return m_mileage;
    }

    public void addPassenger(characters.Character passenger) throws core.ScriptException {
        if (m_passengers.size() >= m_parameters.capacity())
            throw new core.ScriptException("To many m_passengers on board.");
        if (!m_passengers.add(passenger))
            throw new core.ScriptException("Passenger '" + passenger.name + "' already on board.");

        m_setStatus("has new passenger: " + passenger.name);
    }

    public void removePassenger(characters.Character passenger) throws core.ScriptException {
        if (!m_passengers.remove(passenger))
            throw new core.ScriptException(
                    "Passenger '" + passenger.name + "' not found on board.");

        m_setStatus("drop off passenger: " + passenger.name);
    }

    public boolean isPassenger(characters.Character passenger) {
        return m_passengers.contains(passenger);
    }

    @Override
    public String explore() {
        StringBuilder result = new StringBuilder(type.toString());
        result.append(" " + m_parameters.model());
        result.append(". The Capacity is " + m_parameters.capacity());
        result.append(". The grace is " + m_parameters.grace());
        result.append(". The m_engine power is " + m_engine.parameters.power());
        result.append(" and it works on " + m_engine.parameters.fuel());
        result.append(". The mileage is " + m_mileage);
        result.append(
                ". There are "
                        + m_passengers.size()
                        + " m_passengers on board"
                        + (m_passengers.size() > 0 ? ": " : ". "));

        for (var p : m_passengers) {
            result.append(p.name + " ");
        }
        return result.toString();
    }

    @Override
    public void action() throws BreakException, InterruptedException {
        if (m_reliability * m_parameters.resource() < ++m_mileage) {
            m_setStatus("is break down");
            throw new BreakException("Break down!");
        }
        Thread.sleep(delay_timeout);
    }

    @Override
    public int compareTo(Transport other) {
        var o_par = other.getParameters();
        var comp = new StringBuilder("Compare " + getCaption() + " and " + other.getCaption());
        comp.append("capacity: " + m_parameters.capacity() + "/" + o_par.capacity() + "\n");
        comp.append("grace:    " + m_parameters.grace() + "/" + o_par.grace() + "\n");
        comp.append("resource: " + m_parameters.resource() + "/" + o_par.resource() + "\n");
        comp.append("Engine:   " + m_engine.type + "/" + other.getEngineType() + "\n");
        comp.append(
                "power:    "
                        + m_engine.parameters.power()
                        + "/"
                        + other.getEngineParameters().power()
                        + "\n");
        comp.append(
                "fuel:     "
                        + m_engine.parameters.fuel()
                        + "/"
                        + other.getEngineParameters().fuel()
                        + "\n");

        m_setStatus(comp.toString());

        return getCaption().compareTo(other.getCaption());
    }

    @Override
    public String toString() {
        return "[" + type + " \"" + m_parameters.model() + "\"]: " + m_status;
    }
}
