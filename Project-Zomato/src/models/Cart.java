package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private Restaurant restaurant;
    private List<MenuItem> menu = new ArrayList<>();

    public Cart(){
        this.restaurant = null;
    }

    public boolean isMenuEmpty(){
        return restaurant==null || menu.isEmpty();
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void clear(){
        menu.clear();
        restaurant=null;
    }

    public void addItems(MenuItem menuItem){
        if(restaurant==null){
            System.out.println("Cart: Set a restaurant before adding items.");
            return;
        }
        menu.add(menuItem);
    }

    public double getCost(){
        double cost = 0;
        for(MenuItem m : menu){
            cost += m.getPrice();
        }
        return  cost;
    }

}
