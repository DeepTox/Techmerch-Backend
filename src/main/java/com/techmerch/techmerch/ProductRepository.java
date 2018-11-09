package com.techmerch.techmerch;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ProductRepository extends CrudRepository<Product,Long> {
}
