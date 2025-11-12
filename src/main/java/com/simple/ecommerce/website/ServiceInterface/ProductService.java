package com.simple.ecommerce.website.ServiceInterface;

import java.util.List;

import com.simple.ecommerce.website.DTO.Product.CreateProduct;
import com.simple.ecommerce.website.DTO.Product.ProductResponse;
import com.simple.ecommerce.website.Entity.Product;


public interface ProductService {

List<ProductResponse> getAllProducts();  // Fecth all products

ProductResponse getProductById(Integer ProductId); // fetch product by id

ProductResponse addProduct(ProductResponse product); // create new product

ProductResponse updateProduct(Integer ProductId, CreateProduct product); // update existing product info

void deleteProduct(Integer ProductId); // delete product by id


}
