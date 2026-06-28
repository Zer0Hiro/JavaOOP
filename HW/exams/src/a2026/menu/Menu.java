package a2026.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu<T extends Dish> implements Iterable<T> {
    private List<T> dishes = new ArrayList<>();

    public void Add(T dish) {
        dishes.add(dish);
    }

    public T get(String name) {
        for (T dish : dishes) {
            if (dish.getName().equals(name))
                return dish;
        }
        return null;
    }
}
