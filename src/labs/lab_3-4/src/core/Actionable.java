package core;

import transport.BreakException;

public interface Actionable {
    public void start();

    public void stop();

    public default void action() throws BreakException, InterruptedException {
        Thread.sleep(delay_timeout);
    }

    int delay_timeout = 1000;
}
