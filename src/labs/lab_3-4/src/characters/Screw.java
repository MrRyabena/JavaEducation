package characters;

public final class Screw extends Character {
        public Screw() throws core.ScriptException
    {
        super("Screw");
        if (m_created) throw new core.ScriptException("Only one instance of Screw is allowed!");
        m_created = true;
    }

    private static boolean m_created;
}
