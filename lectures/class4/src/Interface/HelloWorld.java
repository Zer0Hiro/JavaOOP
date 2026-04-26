package Interface;

public class HelloWorld implements HelloInterface {

    @Override
    public void Goodbye() {
        System.out.println("Bye bye o/");
    }

    @Override
    public void Hello() {
        System.out.println("Hello World!");
    }

}


