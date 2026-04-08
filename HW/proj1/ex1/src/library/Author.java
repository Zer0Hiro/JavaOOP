package library;

public class Author {
    private String name;
    private int birthYear;

    public Author(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    // return the age of Author
    public int getAge(int thisYear) {
        int age = thisYear - this.birthYear;
        return age;
    }

    @Override
    public String toString() {
        return name + "(" + birthYear + ")";
    }

}
