package cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Country implements Comparable<Country> {
    private Set<City> cities;
    private String name;

    public Country(String name) {
        this.name = name;
        this.cities = new TreeSet<>();
    }

    public void addCity(City city) {
        // If city not from this country
        if (city.getCountry() != this) {

            throw new IllegalArgumentException("Error: The city belongs to a different country!");
        }
        this.cities.add(city);
    }

    // Returs population of the country (Sum of populations of cities)
    public int population() {
        int populationAll = 0;
        for (City city : cities) {
            populationAll += city.getPopulation();
        }
        return populationAll;
    }

    @Override
    public String toString() {
        return name;
    }

    // Returns cities list withh population under (under)
    public List<City> smallCities(int under) {

        List<City> temp = new ArrayList<>();

        for (City city : cities) {
            if (city.getPopulation() < under)
                temp.add(city);
        }
        return temp;

    }

    // Prints all cities in the Country with population
    public String report() {
        int i = 0;
        String str = "" + name + "(" + this.population() + ") :";
        for (City city : cities) {
            if (i != 0)
                str += ",";
            str += " " + city.getName() + "(" + city.getPopulation() + ")";
            i++;
        }
        return str;
    }

    @Override
    public int compareTo(Country otherCountry) {
        return this.name.compareTo(otherCountry.name);
    }
}
