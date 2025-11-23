package com.simple.ecommerce.website.DTO.Product;




import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CreateProductDTO { // This for creating new product 

    @NotBlank
    String name;

    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "Description can only contain alphanumeric characters and spaces")
    String description;

    @NotBlank
    @DecimalMin("0.01")
    BigDecimal price;


}
