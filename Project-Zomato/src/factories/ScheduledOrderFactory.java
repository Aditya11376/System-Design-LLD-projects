package factories;

import models.*;
import strategies.PaymentStrategy;
import utils.TimeUtils;

import java.util.List;

public class ScheduledOrderFactory implements OrderFactory{

    private String scheduleTime;

    public ScheduledOrderFactory(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems, PaymentStrategy paymentStrategy, double cost, String orderType) {
        Order order = new DeliveryOrder();
        if(order.getType().equals("delivery")){
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order=deliveryOrder;
        }else{
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getLocation());
            order=pickupOrder;
        }
        order.setUser(user);
        order.setMenuItems(menuItems);
        order.setPaymentStrategy(paymentStrategy);
        order.setTotal(cost);
        order.setRestaurant(restaurant);
        return order;
    }
}
