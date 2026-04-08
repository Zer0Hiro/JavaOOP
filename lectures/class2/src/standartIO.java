/* 

system.in <- input
system.out -> out (BUFFERED OUT)
sytem.err -> also out (URGENT UNBUFFERED OUT)


EXCEPTIONS FOR IO not INT:

throws IOException
*/

// SCANNER
// Allows to get all of the words from INFO without spaces  
import java.util.Scanner;
Scanner name1 = new Scanner("INFO");
while(name1.hasNext()); // <- allows to check if there is next element
name1.next(); // <- moves to the next element
nam1.nextInt(); // <- also works with int

// IF YOU NEED TO CHANGE PRINT FOR OBJECT USE
public String toString();