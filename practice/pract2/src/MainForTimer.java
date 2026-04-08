import ex1.Timerius;

public class MainForTimer {
    public static void main(String[] args) {
        Timerius t1 = new Timerius(5, 13, 15);
        Timerius t2 = new Timerius(187905);
        int seconds = t1.totalSeconds();
        System.out.println(t1);
        System.out.println("Seconds: "+ seconds);
        System.out.println(t2);
        while (t2.tickDown()) {
            System.out.println(t2);
        }
    }
}
