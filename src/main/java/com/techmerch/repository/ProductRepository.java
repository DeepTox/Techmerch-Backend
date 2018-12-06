package com.techmerch.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.techmerch.model.Product;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "select * from db_techmerch.products where category_id = :categoryId", nativeQuery=true)
    List<Product> findAllByCategory(@Param("categoryId") Long categoryId);
    @Query(value = "select * from db_techmerch.products where subcategory_id = :subcategoryId", nativeQuery=true)
    List<Product> findAllBySubCategory(@Param("subcategoryId") Long subcategoryId);

}
