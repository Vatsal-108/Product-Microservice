package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.exception.ProductNotFoundException;
import com.product.entity.*;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		
		Product newProduct=productRepository.save(product);
		return newProduct;
	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		Optional<Product> optionalProduct=productRepository.findById(productId);
		if(optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Product Not existing with Id:"+productId);
		}
		Product product=optionalProduct.get();
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> products=productRepository.findAll();
		return products;
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> optionalProduct=productRepository.findById(product.getProductId());
		if(optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Product Not existing with Id:"+product.getProductId());
		}
		Product updatedProduct=productRepository.save(product);
		
		return updatedProduct;
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		Optional<Product> optionalProduct=productRepository.findById(productId);
		if(optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Product Not existing with Id:"+productId);
		}
		productRepository.deleteById(productId);
		
	}
	@Override
	public Product saveProduct(int categoryId, Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	
}