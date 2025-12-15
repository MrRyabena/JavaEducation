package characters;

public abstract class Character extends core.Statusable implements Comparable<Character> {
    public String name;
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

    public void boardTransport(transport.Transport tr) throws core.ScriptException {
        m_setStatus("set to transport: " + tr.type + " " + tr.model);
        tr.addPassenger(this);
    }

    public void leaveTransport(transport.Transport tr) throws core.ScriptException {
        m_setStatus("leaving transport: " + tr.type + " " + tr.model);
        tr.removePassenger(this);
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
}
