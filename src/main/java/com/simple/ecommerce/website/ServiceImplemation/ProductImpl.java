package com.simple.ecommerce.website.ServiceImplemation;






import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.ecommerce.website.DTO.DtoMapper;
import com.simple.ecommerce.website.DTO.Product.CreateProductDTO;
import com.simple.ecommerce.website.DTO.Product.ProductResponseDTO;
import com.simple.ecommerce.website.Entity.Product;
import com.simple.ecommerce.website.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductImpl {


    @Autowired
    private final ProductRepository productRepository;


    
    @Transactional  // Create or adding new product
    public ProductResponseDTO addProduct(CreateProductDTO dto) { 

        Product p = Product.builder()
        .name(dto.getName())
        .description(dto.getDescription())
        .price(dto.getPrice())
        .build();

        return DtoMapper.toResponse(productRepository.save(p));
    }



    @Transactional()
    public List<ProductResponseDTO> getAllProducts() {
      return productRepository.findAll().stream().map(DtoMapper::toResponse).toList();
    }


    
    @Transactional
    public ProductResponseDTO getProductById(Integer ProductId)
    {
        return productRepository.findById(ProductId)
        .map(DtoMapper::toResponse)
        .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Transactional
    public ProductResponseDTO updateProduct(Integer ProductId, CreateProductDTO dto) {
        Product p = productRepository.findById(ProductId)
        .orElseThrow(() -> new RuntimeException("Product not found"));

        p.setName(dto.getName());
        p.setDescription(dto.getDescription());
        p.setPrice(dto.getPrice());

        return DtoMapper.toResponse(productRepository.save(p));
    }
   

    @Transactional
    public void deleteProduct(Integer ProductId) {
        if (!productRepository.existsById(ProductId)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(ProductId);
    }
}
