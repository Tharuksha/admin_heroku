package com.nsbm.ebookstore.user.order_service.Repository;
import com.nsbm.ebookstore.user.order_service.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT r FROM Order r WHERE r.book_id = :book_id")
    List<Order> findOrderByBookID (@Param("book_id") Long bookId);

    @Query(value = "SELECT r FROM Order r WHERE r.userid = :userId")
    List<Order> findOrdersByUserID (@Param("userId") Long userId);
}