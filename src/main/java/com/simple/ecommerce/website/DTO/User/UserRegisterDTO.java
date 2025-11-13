package com.simple.ecommerce.website.DTO.User;





import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class UserRegisterDTO {


    @NotBlank
    @Size(min = 3, max = 30)
    String username;

    @NotBlank()
    @Size(min = 6)
    String password; // passwrod will be encoded example Bycrypt
}
