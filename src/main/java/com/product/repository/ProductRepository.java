package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.*;

public interface ProductRepository extends JpaRepository<Product,Integer>{


}