package com.simple.ecommerce.website.ServiceInterface;

import java.util.List;


import com.simple.ecommerce.website.Entity.Product;


public interface ProductService {

List<Product> getAllProducts();  // Fecth all products

Product getProductById(Integer ProductId); // fetch product by id

Product addProduct(Product product); // create new product

Product updateProduct(Integer ProductId, Product product); // update existing product info

void deleteProduct(Integer ProductId); // delete product by id


}
