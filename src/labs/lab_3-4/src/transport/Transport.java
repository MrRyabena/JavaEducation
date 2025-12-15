package transport;

import java.util.HashSet;
import java.util.Random;

public abstract class Transport extends core.Statusable
        implements core.Actionable, core.Explorable {
    public TransportType type;
    public String model;
    public int mileage;

    protected HashSet<characters.Character> passengers;
    protected double reliability;
    protected int resource;

    public Transport(
            TransportType set_type, String set_model, int set_resource, double set_reliability) {
        type = set_type;
        model = set_model;
        resource = set_resource;
        reliability = set_reliability;
        passengers = new HashSet<characters.Character>();
    }

    public Transport(TransportType set_type, String set_model, int set_resource) {

        type = set_type;
        model = set_model;
        resource = set_resource;

        var random = new Random();
        reliability = random.nextDouble(0.5, 1.5);

        passengers = new HashSet<characters.Character>();
    }

    public void addPassenger(characters.Character passenger) throws core.ScriptException {
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
        result.append(" " + model);
        result.append(". The mileage is " + mileage);
        result.append(". There are " + passengers.size() + " passengers on board" + (passengers.size() > 0 ? ": " : ". "));

        for (var p : passengers) {
            result.append(p.name + " ");
        }
        return result.toString();
    }

    @Override
    public void action() throws BreakException, InterruptedException {
        if (reliability * resource < ++mileage) {
            m_setStatus("is break down");
            throw new BreakException("Break down!");
        }
        Thread.sleep(delay_timeout);
    }

    @Override
    public String toString() {
        return "[" + type + " \"" + model + "\"]: " + m_status;
    }
}
