package factories;

import models.*;
import strategies.PaymentStrategy;
import utils.*;

import java.util.List;
import java.util.Objects;

public class NowOrderFactory implements OrderFactory{
    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems, PaymentStrategy paymentStrategy, double cost, String orderType) {
        Order order =  new DeliveryOrder();
        if(Objects.equals(order.getType(), "delivery")){
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
        order.setScheduled(TimeUtils.getCurrentTime());
        return order;
    }
}
