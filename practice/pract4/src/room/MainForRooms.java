package room;

public class MainForRooms {
    public static void main(String[] args) {
        Room r1 = new Room(2, 2, 50);
        System.out.println(r1);
        Room r2 = new Bathroom(2, 2, 2, 50);
        System.out.println(r2);
    }
}
