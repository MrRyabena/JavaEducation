package transport;

public class Automobile extends Transport {
    public Automobile(String set_model) {
        super(TransportType.AUTOMOBILE, set_model);
    }

    @Override
    void start() {
        super.status = "starting";
    }

    @Override
    void stop() {
        super.status = "stop";
    }

    @Override
    boolean breakdown() {
        return false;
    }

    @Override
    public String toString() {
        return "[" + typeToString() + " \"" + model + "\"]: " + status;
    }
}
