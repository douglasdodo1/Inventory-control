package com.inventorycontrol.inventorycontrol.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inventorycontrol.inventorycontrol.models.ProductModel;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel,Long> {

}
