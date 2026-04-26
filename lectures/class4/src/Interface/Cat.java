package Interface;

public class Cat implements HelloInterface {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void Hello() {
        System.out.println("Hello Cat " + name + "!");
    }

    @Override
    public void Goodbye() {
        System.out.println("Bye bye " + name + " o/");

    }

}
