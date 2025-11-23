package com.simple.ecommerce.website.ServiceImplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.simple.ecommerce.website.DTO.DtoMapper;
import com.simple.ecommerce.website.DTO.Cart.CartAddDTO;
import com.simple.ecommerce.website.DTO.Cart.CartItemDTO;
import com.simple.ecommerce.website.Entity.Cart;
import com.simple.ecommerce.website.Entity.Product;
import com.simple.ecommerce.website.Entity.User;
import com.simple.ecommerce.website.Repository.CartRepository;
import com.simple.ecommerce.website.Repository.ProductRepository;
import com.simple.ecommerce.website.ServiceInterface.CartService;
import com.simple.ecommerce.website.ServiceInterface.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final UserService userService;

    private final ProductRepository productRepository;



    @Override
    @Transactional
    public CartItemDTO addItem(Integer userId, CartAddDTO dto){
        User user = userService.getEntity(userId);

        Product product = productRepository.findById(dto.getProductId())
        .orElseThrow(() -> new
        RuntimeException("Product not found"));

        Cart cart = cartRepository.findByUserAndProduct(user, product)
                            .orElseGet(() -> Cart.builder()
                                               .user(user)
                                               .product(product)
                                               .quantity(0)
                                               .build());
        cart.setQuantity(cart.getQuantity() + dto.getQuantity());
        return DtoMapper.toCartItemDTO(cartRepository.save(cart));
}


 @Override
    @Transactional()
    public List<CartItemDTO> getCart(Integer userId) {
        User user = userService.getEntity(userId);
        return cartRepository.findByUser(user)
                       .stream()
                       .map(DtoMapper::toCartItemDTO)
                       .toList();
    }


  @Override
    @Transactional
    public void removeItem(Integer userId, Integer productId) {
        User user = userService.getEntity(userId);
        cartRepository.deleteByUserAndProduct(user,
               productRepository.getReferenceById(productId));
    }

    @Override
    @Transactional
    public void clearCart(Integer userId) {
        User user = userService.getEntity(userId);
        cartRepository.deleteByUser(user);
    }

}
