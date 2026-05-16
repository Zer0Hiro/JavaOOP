package circuits;

public class VarGate extends Gate {
    private String name;
    private boolean val;
    private boolean alreadySet;

    public VarGate(String name) {
        super(null);
        this.name = name;
    }

    public void setVal(boolean val) {
        this.val = val;
        this.alreadySet = true;
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        if (!alreadySet)
            throw new CircuitException();
        return this.val;
    }

    @Override
    public String getName() {
        return "V" + name;
    }

    @Override
    // Simplifies it to True/False Gate
    public Gate simplify() {
        if (alreadySet)
            return val ? TrueGate.instance() : FalseGate.instance();
        return this; // if not set
    }

}
