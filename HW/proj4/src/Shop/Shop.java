package Shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private ArrayList<Instrument> instruments = new ArrayList<>();

    public void add(Instrument i) {
        instruments.add(i);
    }

    public Instrument get(int serial) {
        return instruments.get(serial);
    }

    public List<Integer> allSerials() {
        List<Integer> serialNumbers = new ArrayList<>();

        for (Instrument inst : instruments) {
            serialNumbers.add(inst.getSerial());
        }
        return serialNumbers;
    }

    public List<Integer> guitarsOfType(Type t) {
        List<Integer> serialNumbers = new ArrayList<>();

        for (Instrument inst : instruments) {
            if (inst.getType() == t) {
                serialNumbers.add(inst.getSerial());
            }
        }
        return serialNumbers;
    }

    public void sell(int serial) throws MusicShopException
}
