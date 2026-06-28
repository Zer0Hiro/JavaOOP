package erezIr;

import java.util.Scanner;

public class ErezIr {
    private char letter;

    public ErezIr() {
        this.letter = 'A';
    }

    private synchronized void set() {
        if (letter == 'Z')
            letter = 'A';
        else
            letter++;

    }

    private synchronized char get() {
        return letter;
    }

    public void runExample() {
        Scanner input = new Scanner(System.in);
        Thread t = new Thread(new Task());
        t.start();
        input.nextLine();
        t.interrupt();
        System.out.println(get());
        try {
            t.join();
        } catch (InterruptedException e) {
        }
        System.out.println("END");
    }

    private class Task implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
                set();

            }
        }
    }

    public static void main(String[] args) {
        ErezIr bomba = new ErezIr();
        bomba.runExample();
    }

}
