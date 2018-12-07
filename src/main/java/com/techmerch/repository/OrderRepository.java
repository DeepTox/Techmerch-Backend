package com.techmerch.repository;

import com.techmerch.model.Order;
import com.techmerch.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select * from db_techmerch.orders where order_client_id = :clientId", nativeQuery=true)
    List<Order> findAllByClientId(@Param("clientId") String clientId);
}
