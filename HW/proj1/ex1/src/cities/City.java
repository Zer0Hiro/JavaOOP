package cities;

public class City {
    private static final int ROADS_AMOUNT = 10;
    private String name;
    private Road[] roads;
    private int numRoads;

    public City(String name) {
        this.name = name;
        this.roads = new Road[ROADS_AMOUNT];
        this.numRoads = 0;
    }

    public void connect(Road r) {
        roads[numRoads] = r;
        this.numRoads++;
    }

    // return the closest city
    public City nearestCity() {
        if (numRoads == 0)
            return null;

        Road shortersRoad = roads[0];

        for (int i = 1; i < numRoads; i++) {
            if (roads[i].getLength() < shortersRoad.getLength())
                shortersRoad = roads[i];
        }

        // Check if same City
        if (shortersRoad.getCity1() == this) {
            return shortersRoad.getCity2();
        }
        return shortersRoad.getCity1();
    }

    @Override
    public String toString() {
        return name;
    }

}
