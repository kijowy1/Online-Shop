package com.springdemo.nobsv2.product.validators;

import com.springdemo.nobsv2.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    //Tu springJPA sam sugeruje na bazie tego co mam w product, jak ma filtrowac
    List<Product> findByNameContaining(String name);

}
