package com.techmerch.repository;


import com.techmerch.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {
    @Query(value = "select * from db_techmerch.sub_category where category_id = :categoryId", nativeQuery=true)
    List<SubCategory> findAllByCategory(@Param("categoryId") Long categoryId);
}
