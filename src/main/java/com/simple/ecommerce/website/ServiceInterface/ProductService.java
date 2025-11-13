package com.simple.ecommerce.website.ServiceInterface;

import java.util.List;

import com.simple.ecommerce.website.DTO.Product.CreateProductDTO;
import com.simple.ecommerce.website.DTO.Product.ProductResponseDTO;


public interface ProductService {

List<ProductResponseDTO> getAllProducts();  // Fecth all products

ProductResponseDTO getProductById(Integer ProductId); // fetch product by id

ProductResponseDTO addProduct(CreateProductDTO product); // create new product

ProductResponseDTO updateProduct(Integer ProductId, CreateProductDTO product); // update existing product info

void deleteProduct(Integer ProductId); // delete product by id


}
