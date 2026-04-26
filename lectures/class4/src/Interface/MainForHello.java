package Interface;

public class MainForHello {
    /*
    Implementing Type of object
    */
    public static void hiAndbye(HelloInterface h) {
        h.Hello();
        h.Goodbye();
    }

    public static void main(String[] args) {
        // Creates object of type HelloWorld, will give it Hello and Goodbye
        hiAndbye(new HelloWorld());
        hiAndbye(new Cat("Kitty"));
    }
}
