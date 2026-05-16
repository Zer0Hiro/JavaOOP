package circuits;

import java.util.ArrayList;
import java.util.List;

public class OrGate extends Gate {

    public OrGate(Gate[] inGates) {
        super(inGates);
    }

    @Override
    // if any of values == true return true
    protected boolean func(boolean[] inValues) throws CircuitException {
        for (boolean b : inValues) {
            if (b == true)
                return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return "OR";
    }

    @Override
    public Gate simplify() {
        List<Gate> simpleInputs = new ArrayList<>();

        // Simplify all child gates
        for (Gate gate : inGates) {
            Gate simpleGate = gate.simplify();

            // Instant true
            if (simpleGate instanceof TrueGate)
                return TrueGate.instance();

            // If not false gate
            if (!(simpleGate instanceof FalseGate))
                simpleInputs.add(simpleGate);
        }

        // No gates at all
        if (simpleInputs.isEmpty())
            return FalseGate.instance();

        // Only one gate
        if (simpleInputs.size() == 1)
            return simpleInputs.get(0);

        return new OrGate(simpleInputs.toArray(new Gate[0]));
    }

}
