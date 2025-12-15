package characters;

public final class Dowel extends Character {

    public Dowel() throws core.ScriptException
    {
        super("Dowel");
        if (m_created) throw new core.ScriptException("Only one instance of Dowel is allowed!");
        m_created = true;
    }

    private static boolean m_created;
    
}
