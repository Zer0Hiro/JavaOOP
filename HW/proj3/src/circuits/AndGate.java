package circuits;

import java.util.ArrayList;
import java.util.List;

public class AndGate extends Gate {
    public AndGate(Gate[] inGates) {
        super(inGates);
    }

    @Override
    // if any of values == false return false
    protected boolean func(boolean[] inValues) throws CircuitException {
        for (boolean b : inValues) {
            if (b == false)
                return false;
        }
        return true;
    }

    @Override
    public String getName() {
        return "AND";
    }

    @Override
    public Gate simplify() {
        List<Gate> simpleInputs = new ArrayList<>();

        // Simplify all child gates
        for (Gate gate : inGates) {
            Gate simpleGate = gate.simplify();

            // Instant false
            if (simpleGate instanceof FalseGate)
                return FalseGate.instance();

            // If not false gate
            if (!(simpleGate instanceof TrueGate))
                simpleInputs.add(simpleGate);
        }

        // No gates at all
        if (simpleInputs.isEmpty())
            return TrueGate.instance();

        // Only one gate
        if (simpleInputs.size() == 1)
            return simpleInputs.get(0);

        return new AndGate(simpleInputs.toArray(new Gate[0]));
    }

}
