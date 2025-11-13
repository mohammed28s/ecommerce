package com.simple.ecommerce.website.DTO.Product;




import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CreateProductDTO { // This for creating new product 

    @NotBlank
    String name;

    String description;

    @NotBlank
    @DecimalMin("0.01")
    BigDecimal price;


}
