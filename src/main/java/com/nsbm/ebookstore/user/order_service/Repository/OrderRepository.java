package com.nsbm.ebookstore.Repository;
import com.nsbm.ebookstore.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT r FROM Order r WHERE r.book_id = :book_id")
    List<Order> findOrderByBookID (@Param("book_id") Long book_id);

    @Query(value = "SELECT r FROM Order r WHERE r.userid = :userid")
    List<Order> findOrdersByUserID (@Param("userid") Long userid);
}