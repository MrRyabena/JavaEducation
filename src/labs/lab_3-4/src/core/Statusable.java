package core;

import java.util.function.Consumer;

public class Statusable {

    public Statusable onStatusChange(Consumer<Statusable> callback) {
        m_on_status_change = callback;
        return this;
    }

    protected String m_status;
    protected Consumer<Statusable> m_on_status_change;

    protected void m_setStatus(String new_status) {
        m_status = new_status;
        if (m_on_status_change != null) m_on_status_change.accept(this);
    }
}
