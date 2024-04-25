package com.nsbm.ebookstore.Controller;

import com.nsbm.ebookstore.Model.Order;
import com.nsbm.ebookstore.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(OrderController.ORDER_BASE_URL)
public class OrderController {

    public static final String ORDER_BASE_URL = "/api/orders";
    public static final String ALL_ORDERS_ENDPOINT = "/all";

    public static final String ORDER_BY_ORDER_ID_ENDPOINT = "/{orderId}";
    public static final String DELETE_SUCCESS_MESSAGE = "Deleted Successfully";
    public static final String UPDATE_SUCCESS_MESSAGE = "Updated Successfully";

    @Autowired
    private OrderService orderService;

    @GetMapping(ALL_ORDERS_ENDPOINT)
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return orders.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(orders);
    }

    @GetMapping(ORDER_BY_ORDER_ID_ENDPOINT)
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);
        return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Order placedOrder = orderService.placeOrder(order);
        return new ResponseEntity<>(placedOrder, HttpStatus.OK);
    }

    @DeleteMapping(ORDER_BY_ORDER_ID_ENDPOINT)
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok(DELETE_SUCCESS_MESSAGE);
    }

    @PutMapping(ORDER_BY_ORDER_ID_ENDPOINT)
    public ResponseEntity<String> updateOrder(@PathVariable Long orderId, @RequestBody Order order) {
        Order updatedOrder = orderService.updateOrder(orderId, order);
        return ResponseEntity.ok(UPDATE_SUCCESS_MESSAGE);
    }
}
