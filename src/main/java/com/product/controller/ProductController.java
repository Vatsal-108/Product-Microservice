package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.*;
import com.product.service.*;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/product/all")
	public List<Product> fetchAllProducts(){
		List<Product> products=productService.getAllProduct();
		return products;
	}
	
	
	
	@GetMapping("/product/get/{productId}")
	public ResponseEntity<Object> fetchProductDetails(@PathVariable("productId") int productId) {
		ResponseEntity<Object> responseEntity;
		 Product product=productService.getProductById(productId);
		 responseEntity=new ResponseEntity<>(product,HttpStatus.OK);
		return responseEntity;
		
	}
	
	@PostMapping("/product/{categoryId}/save")
	public ResponseEntity<Product> addProduct(@PathVariable int categoryId,@RequestBody Product product) {
		Product newProduct=productService.saveProduct(categoryId,product);
		ResponseEntity<Product> responseEntity=new ResponseEntity<>(newProduct,HttpStatus.CREATED); 
		return responseEntity;
	}
	
	@PutMapping("/product/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product updatedProduct=productService.updateProduct(product);
		ResponseEntity<Product> responseEntity=new ResponseEntity<>(updatedProduct,HttpStatus.OK); 
		return responseEntity;
	}
	
	@DeleteMapping("/product/delete/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId) {
		productService.deleteProduct(productId);
		ResponseEntity<String> responseEntity=new ResponseEntity<>("Product deleted successfully",HttpStatus.OK); 
		return responseEntity;
	}
}
