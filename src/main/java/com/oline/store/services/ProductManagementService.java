package com.oline.store.services;

import com.oline.store.enteties.Product;

import java.util.List;

public interface ProductManagementService {

	List<Product> getProducts();

	Product getProductById(int productIdToAddToCart);

}
