package circuits;

public abstract class Gate {
    protected Gate[] inGates;

    public Gate(Gate[] inGates) {
        this.inGates = inGates;
    }

    // recursive function saves all func t/f to inValues
    public boolean calc() throws CircuitException {
        if (inGates == null || inGates.length == 0)
            return func(null);

        boolean[] inValues = new boolean[inGates.length];

        for (int i = 0; i < inGates.length; i++)
            inValues[i] = inGates[i].calc();

        return func(inValues);
    }

    protected abstract boolean func(boolean[] inValues) throws CircuitException;

    public abstract String getName();

    public abstract Gate simplify();

    @Override
    public String toString() {
        // if empty
        if (inGates == null || inGates.length == 0)
            return getName();

        StringBuilder sb = new StringBuilder();

        sb.append(getName() + "[");
        // run through all of gates and return toString
        for (int i = 0; i < inGates.length; i++) {
            sb.append(inGates[i].toString());

            if (i < inGates.length - 1)
                sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

}
