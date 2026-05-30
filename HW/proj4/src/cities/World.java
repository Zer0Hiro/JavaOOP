package cities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class World {
    private Map<String, Country> countries;

    public World() {
        this.countries = new TreeMap<>();
    }

    public void addCountry(String name) {
        countries.put(name, new Country(name));
    }

    public void addCity(String name, String countryName, int population) {
        // Get country out of tree map
        Country cntry = countries.get(countryName);
        if (cntry == null) {
            throw new IllegalArgumentException("Error: This Country does not exist!");
        }
        cntry.addCity(new City(name, cntry, population));
    }

    // Counts world population
    public int population() {
        int world_pop = 0;
        // Check population in each country
        for (Country country : countries.values()) {
            world_pop += country.population();
        }
        return world_pop;
    }

    // Returns all sities in the world smaller than under
    public List<City> smallCities(int under) {
        List<City> temp = new ArrayList<>();

        for (Country cntry : countries.values()) {
            temp.addAll(cntry.smallCities(under));
        }

        Collections.sort(temp);

        return temp;
    }

    // Prints all countries with cities and population
    public String report() {
        String allReports = "";
        for (Country cntry : countries.values()) {
            allReports += cntry.report();
            allReports += "\n";
        }
        allReports += "Total population is " + this.population() + "\n";
        return allReports;
    }
}
