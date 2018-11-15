package com.techmerch.techmerch;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "select * from db_techmerch.products where category_id = :categoryId", nativeQuery=true)
    List<Product> findAllByCategory(@Param("categoryId") Long categoryId);
}
