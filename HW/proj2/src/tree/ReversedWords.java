package tree;

import java.util.Scanner;

public class ReversedWords {
    public static int checkReversed() {
        int counter = 0;
        Node root = new Node();
        Scanner string = new Scanner(System.in);

        while (true) {
            String input = string.next();

            // End of string
            if (input.equals("X")) {
                break;
            }


            //Reversed string
            String reversed = new StringBuilder(input).reverse().toString();

            //Check if already in Tree
            if(root.num(reversed) == 0){
                root.add(input);
            }
            else{
                counter++;
            }
        }
        string.close();
        return counter;
    }
}
