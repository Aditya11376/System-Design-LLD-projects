package managers;

import models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    private List<Order> orders = new ArrayList<>();
    private static OrderManager instance = null;

    private OrderManager(){}

    public static OrderManager getInstance(){
        if(instance==null){
            instance = new OrderManager();
        }
        return instance;
    }

    public void addOrders(Order order){
        System.out.println("\n--- All Orders ---");
        for (Order o : orders)
            System.out.println(o.getType() + " order for " + o.getUser().getName()
                    + " | Total: ₹" + o.getTotal()
                    + " | At: " + o.getScheduled());
    }

}
