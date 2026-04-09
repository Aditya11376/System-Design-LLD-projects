package models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private static int restaurantId = 0;
    private String name;
    private String location;
    private List<MenuItem> menu = new ArrayList<>();

    public Restaurant(String name, String loc){
        this.name=name;
        this.location=loc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void addMenuItem(MenuItem item) {
        this.menu.add(item);
    }
}
