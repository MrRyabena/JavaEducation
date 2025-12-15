package transport;

import java.util.HashSet;
import java.util.Random;

public abstract class Transport extends core.Statusable
        implements core.Actionable, core.Explorable {

    public final TransportTypes type;
    public static record Parameters(String model, int capacity, int grace, int resource) {}

    protected final Parameters parameters;
    protected Engine engine;

    protected int m_mileage;

    protected HashSet<characters.Character> passengers;
    protected double reliability;

    public Transport(TransportTypes set_type, Parameters params, Engine set_engine, double set_reliability) {
        type = set_type;
        parameters = params;
        engine = set_engine;
        engine.onStatusChange(
                (obj) -> {
                    this.m_setStatus(obj.toString());
                });

        reliability = set_reliability;

        passengers = new HashSet<characters.Character>(parameters.capacity());
    }

    public Transport(TransportTypes set_type, Parameters params, Engine set_engine) {
        type = set_type;
        parameters = params;
        engine = set_engine;
        engine.onStatusChange(
                (obj) -> {
                    this.m_setStatus(obj.toString());
                });

        var random = new Random();
        reliability = random.nextDouble(0.5, 1.5);

        passengers = new HashSet<characters.Character>(parameters.capacity());
    }

    public Parameters getParameters() {
        return parameters;
    }

    public Engine.Parameters getEngineParameters() {
        return engine.parameters;
    }

    public int getMileage() {
        return m_mileage;
    }

    public void addPassenger(characters.Character passenger) throws core.ScriptException {
        if (passengers.size() >= parameters.capacity())
            throw new core.ScriptException("To many passengers on board.");
        if (!passengers.add(passenger))
            throw new core.ScriptException("Passenger '" + passenger.name + "' already on board.");

        m_setStatus("has new passenger: " + passenger.name);
    }

    public void removePassenger(characters.Character passenger) throws core.ScriptException {
        if (!passengers.remove(passenger))
            throw new core.ScriptException(
                    "Passenger '" + passenger.name + "' not found on board.");

        m_setStatus("drop off passenger: " + passenger.name);
    }

    @Override
    public String explore() {
        StringBuilder result = new StringBuilder(type.toString());
        result.append(" " + parameters.model());
        result.append(". The Capacity is " + parameters.capacity());
        result.append(". The grace is " + parameters.grace());
        result.append(". The engine power is " + engine.parameters.power());
        result.append(" and it works on " + engine.parameters.fuel_type());
        result.append(". The mileage is " + m_mileage);
        result.append(
                ". There are "
                        + passengers.size()
                        + " passengers on board"
                        + (passengers.size() > 0 ? ": " : ". "));

        for (var p : passengers) {
            result.append(p.name + " ");
        }
        return result.toString();
    }

    @Override
    public void action() throws BreakException, InterruptedException {
        if (reliability * parameters.resource() < ++m_mileage) {
            m_setStatus("is break down");
            throw new BreakException("Break down!");
        }
        Thread.sleep(delay_timeout);
    }

    @Override
    public String toString() {
        return "[" + type + " \"" + parameters.model() + "\"]: " + m_status;
    }
}
