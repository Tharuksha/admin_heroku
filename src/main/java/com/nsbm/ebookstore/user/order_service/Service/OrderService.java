// OrderService.java
package com.nsbm.ebookstore.Service;



import ch.qos.logback.core.util.Loader;
import com.nsbm.ebookstore.Model.Order;

import java.util.List;

// OrderService interface
public interface OrderService {
    List<Order> getAllOrders();
    Order placeOrder(Order order);
    void deleteOrder(Long orderId);
    Order updateOrder(Long orderId, Order order);
    Order getOrderById(Long orderId);// Method to get an order by ID
    List<Order> GetOrdersByBookId(Long book_id);
    List<Order> GetOrdersByUserId(Long userid);



}
