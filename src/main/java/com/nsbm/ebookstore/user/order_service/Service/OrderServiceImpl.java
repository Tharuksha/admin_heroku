package com.nsbm.ebookstore.user.order_service.Service;
import com.nsbm.ebookstore.user.order_service.Model.Order;
import com.nsbm.ebookstore.user.order_service.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long orderId, Order order) {
        if (orderRepository.existsById(orderId)) {
            Optional<Order> existingOrderOptional = orderRepository.findById(orderId);
            if (existingOrderOptional.isPresent()) {
                Order existingOrder = existingOrderOptional.get();
                existingOrder.setContactNumber(order.getContactNumber());
                existingOrder.setOrderDate(order.getOrderDate());
                existingOrder.setShippingAddress(order.getShippingAddress());
                existingOrder.setNote(order.getNote());
                return orderRepository.save(existingOrder);
            } else {
                return null; // No order found with this ID
            }
        } else {
            return null; // No order found with this ID
        }
    }

    @Override
    public void deleteOrder(Long orderId) {
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
        }
    }

    @Override
    public Order getOrderById(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.orElse(null);
    }

    public List<Order> GetOrdersByBookId(Long book_id) {
        return orderRepository.findOrderByBookID(book_id);
    }

    public List<Order> GetOrdersByUserId(Long userid) {
        return orderRepository.findOrdersByUserID(userid);
    }

}
