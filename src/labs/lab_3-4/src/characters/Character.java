package characters;

import core.ScriptException;
import transport.BreakException;
import transport.Transport;

public abstract class Character extends core.Statusable implements Comparable<Character> {
    public final String name;
    Feeling feeling;
    Wish wish;

    public Character(String set_name) {
        name = set_name;
    }

    public void setFeeling(Feeling set_feeling) {
        feeling = set_feeling;
        m_setStatus("feeling " + feeling.toString().toLowerCase());
    }

    public void setWish(Wish set_wish) {
        wish = set_wish;
        m_setStatus("wishing " + wish.toString().toLowerCase());
    }

    public void boardTransport(Transport tr) throws core.ScriptException {
        m_setStatus("set to transport: " + tr.getCaption());
        tr.addPassenger(this);
    }

    public void leaveTransport(Transport tr) throws core.ScriptException {
        m_setStatus("leaving transport: " + tr.getCaption());
        tr.removePassenger(this);
    }

    public void driveTransport(Transport tr, final int distance)
            throws core.ScriptException, InterruptedException {
        if (!tr.isPassenger(this)) {
            throw new ScriptException(
                    "The character "
                            + name
                            + "can't drive transport "
                            + tr.getCaption()
                            + ", because he is't a passenger.");
        }

        try {
            tr.start();

            for (int i = 0; i < distance; i++) tr.action();
            tr.stop();
            m_setStatus(
                    "successfully drove the "
                            + tr.getCaption()
                            + " for the "
                            + distance
                            + " miles");
            setFeeling(Feeling.HAPPY);
        } catch (BreakException e) {
            m_setStatus(
                    "Did not drove the "
                            + tr.getCaption()
                            + " to its destination, because "
                            + e.toString());
            setFeeling(Feeling.SAD);
        }
    }

    public void see(core.Explorable obj) {
        m_setStatus("sees: " + obj.explore());
    }

    @Override
    public int compareTo(Character other) {
        return name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "[" + name + "]: " + m_status;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Character && name.equals(((Character) other).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
