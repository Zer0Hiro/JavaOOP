package iterator;

public class IteratorToString {

    public static String toString(MyIterator it) {

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (it.hasNext()) {
            sb.append(it.next());

            // Checks if there is still numbers
            if (it.hasNext()) {
                sb.append(" ");
            }
        }

        sb.append("]");

        return sb.toString();

    }
}
