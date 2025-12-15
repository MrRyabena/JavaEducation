package characters;

public final class Dunno extends Character {
    public Dunno() throws core.ScriptException {
        super("Dunno");

        if (m_created) throw new core.ScriptException("Only one instance of Dunno is allowed!");
        m_created = true;
    }

    private static boolean m_created = false;
}
