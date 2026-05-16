package circuits;

import java.util.ArrayList;
import java.util.List;

public class NotGate extends Gate {

    // Return only one var
    public NotGate(Gate inGate) {
        super(new Gate[] { inGate });
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        return !inValues[0];
    }

    @Override
    public String getName() {
        return "NOT";
    }

    @Override
    public Gate simplify() {
        Gate simpleChild = inGates[0].simplify();

        if (simpleChild instanceof TrueGate)
            return FalseGate.instance();

        if (simpleChild instanceof FalseGate)
            return TrueGate.instance();

        // Double negation
        if (simpleChild instanceof NotGate)
            return simpleChild.inGates[0];

        return new NotGate(simpleChild);
    }

}
