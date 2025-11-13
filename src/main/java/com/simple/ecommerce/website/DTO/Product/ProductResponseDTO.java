package com.simple.ecommerce.website.DTO.Product;



import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class ProductResponseDTO {

    private Integer id;

    private String name;

    private String description;

    private BigDecimal price;

}
