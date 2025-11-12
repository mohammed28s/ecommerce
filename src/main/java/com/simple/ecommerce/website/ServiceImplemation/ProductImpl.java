package com.simple.ecommerce.website.ServiceImplemation;







import org.springframework.stereotype.Service;

import com.simple.ecommerce.website.DTO.Product.CreateProduct;
import com.simple.ecommerce.website.DTO.Product.ProductResponse;
import com.simple.ecommerce.website.Entity.Product;
import com.simple.ecommerce.website.Repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductImpl {


    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public ProductResponse (CreateProduct dto) {
        Product p = Product.builder()
            .name(dto.getName())
            .description(dto.getDescription())
            .price(dto.getPrice())
            .build();
            return DtoMapper.toResponse(productRepository.save(p));
    }



}
