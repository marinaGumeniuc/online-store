package com.oline.store.storage;

import com.oline.store.enteties.Product;

import java.util.List;

public interface ProductStoringService {
	
	List<Product> loadProducts();

}
