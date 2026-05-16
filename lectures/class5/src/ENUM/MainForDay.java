package ENUM;

import java.util.Arrays;

public class MainForDay {
    public static void main(String[] args) {
        Day d = Day.TUESDAY;
        System.out.println(d); // TUESDAY
        System.out.println(d.ordinal()); // WILL RETURN INDEX OF D

        Day[] days = Day.values();
        System.out.println(Arrays.toString(days));
        // [SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        // THURSDAY, FRIDAY, SATURDAY]
        Day d2 = Day.valueOf("MONDAY");
        System.out.println(d2.compareTo(d)); // Will return d2-d
    }
}
