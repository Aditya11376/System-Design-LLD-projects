package models;

import strategies.PaymentStrategy;

import java.util.List;

public abstract class Order {

    private static int nextId = 0;

    protected int orderId;
    protected User user;
    protected Restaurant restaurant;
    protected List<MenuItem> menuItems;
    protected double total;
    protected String scheduled;
    protected PaymentStrategy paymentStrategy;

    public Order(){
        this.user = null;
        this.restaurant = null;
        this.total = 0;
        this.scheduled = "";
        this.orderId = ++nextId;
        this.paymentStrategy=null;
    }

    public abstract String getType();

    public boolean processPayment(){
        if(paymentStrategy!=null){
            paymentStrategy.pay(total);
            return true;
        }else{
            System.out.println("Please choose a payment mode first");
            return false;
        }
    }

    public int getOrderId() {
        return orderId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
        total = 0;
        for(MenuItem i : menuItems){
            total+=i.getPrice();
        }
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}
