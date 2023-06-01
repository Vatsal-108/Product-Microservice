package com.product.service;

import java.util.List;

import com.product.entity.*;

public interface ProductService {
public Product saveProduct(int categoryId,Product product);
	
	public Product getProductById(int productId);
	
	public List<Product> getAllProduct();

	public Product updateProduct(Product product);
	
	public void deleteProduct(int productId);
	

}
