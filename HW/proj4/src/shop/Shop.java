package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private ArrayList<Instrument> instruments = new ArrayList<>();

    public void add(Instrument i) {
        instruments.add(i);
    }

    // Returns instance of specific serial
    public Instrument get(int serial) {
        // If not same serial, Object does not exist
        for (Instrument inst : instruments) {
            if (inst.getSerial() == serial)
                return inst;
        }
        return null;
    }

    // Create list of all instruments
    public List<Integer> allSerials() {
        List<Integer> serialNumbers = new ArrayList<>();

        for (Instrument inst : instruments) {
            serialNumbers.add(inst.getSerial());
        }
        return serialNumbers;
    }

    // Returns list of guitars with the same type
    public List<Integer> guitarsOfType(Type t) {
        List<Integer> serialNumbers = new ArrayList<>();

        for (Instrument inst : instruments) {
            if (inst.getType() == t) {
                serialNumbers.add(inst.getSerial());
            }
        }
        return serialNumbers;
    }

    public void sell(int serial) throws MusicShopException {
        Instrument temp = get(serial);
        // If no serial number, throw Exception
        if (temp == null)
            throw new MusicShopException("Item does not exist");

        // Check amount of guitars
        int counter = 0;
        for (Instrument in : instruments) {
            if (in instanceof Guitar)
                counter++;
        }
        // If only one guitar
        if (counter == 1)
            throw new MusicShopException("Only one guitar in the shop!");
        instruments.remove(temp);
    }

    public int sellAll(int[] serials) {
        int counter = 0;
        for (int num : serials) {
            // If failed to sell -> counter++
            try {
                sell(num);
            } catch (Exception e) {
                counter++;
            }
        }
        return counter;
    }
}
