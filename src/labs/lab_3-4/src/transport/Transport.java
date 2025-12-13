package transport;


public abstract class Transport {
    TransportType type;
    String model;

    protected String status;

    Transport(TransportType set_type, String set_model) {
        type = set_type;
        model = set_model;
    }

    abstract void start();

    abstract void stop();

    abstract boolean breakdown();

    String typeToString() {
        return switch (type) {
            case AUTOMOBILE -> "automobile";
            case BALLOON -> "balloon";
        };
    }
}
