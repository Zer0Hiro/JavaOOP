package cities;

public class City implements Comparable<City> {
    private String name;
    private Country country;
    private int population;

    public City(String name, Country country, int population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return name + " (of " + country + ")";
    }

    @Override
    public int compareTo(City otherCity) {
        return this.name.compareTo(otherCity.getName());
    }

    @Override
    public boolean equals(Object obj) {
        // Same obj
        if(this == obj)
            return true;

        // Cast obj to city
        City otherCity = (City) obj;
        
        return this.name.equals(otherCity.getName());
    }

}
